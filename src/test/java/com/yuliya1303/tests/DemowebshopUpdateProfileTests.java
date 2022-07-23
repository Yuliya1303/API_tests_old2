package com.yuliya1303.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.yuliya1303.helpers.AllureRestAssuredFilter.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class DemowebshopUpdateProfileTests extends TestBase {

    static String login = "yuliya@gmail.com",
            password = "yuliya@gmail.com1",
            authCookieName = "NOPCOMMERCE.AUTH",
            newUserFirstName = "YuliyaNew",
            newUserLastName = "ByshkoNew";

    @Test
    @Tag("demowebshop")
    @DisplayName("Update User data")
    void userDataIsUpdatedWithValidData() {
        step("Get Auth cookie by api", () -> {
            String authCookieValue = given()
                    .filter(withCustomTemplates())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("Email", login)
                    .formParam("Password", password)
                    .log().all()
                    .when()
                    .post("/login")
                    .then()
                    .log().all()
                    .statusCode(302)
                    .extract().cookie(authCookieName);

            step("Update User data", () -> {
                        given()
                        .filter(withCustomTemplates())
                        .contentType("application/x-www-form-urlencoded")
                        .cookie(authCookieValue)
                        .formParam("FirstName", newUserFirstName)
                        .formParam("LastName", newUserLastName)
                        .log().all()
                        .when()
                        .post("/customer/info")
                        .then()
                        .log().all()
                        .statusCode(302);

                step("Open minimal content, because cookie can be set when site is opened", () ->
                        open("/Themes/DefaultClean/Content/images/logo.png"));
                step("Set Auth cookie to to browser", () -> {
                    Cookie authCookie = new Cookie(authCookieName, authCookieValue);
                    WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
                });
            });

            step("Open profile page", () ->
                    open("/customer/info"));
            step("Verify that new user FirstName is displayed in Profile", () ->
                    $("#FirstName").shouldHave(text(newUserFirstName)));

            step("Verify that new user LastName is displayed in Profile", () ->
                    $("#LastName").shouldHave(text(newUserLastName)));
        });
    }
}
