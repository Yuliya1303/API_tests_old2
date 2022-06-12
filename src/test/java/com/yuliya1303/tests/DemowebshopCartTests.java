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


public class DemowebshopCartTests extends TestBase {

    static String login = "yuliya@gmail.com",
            password = "yuliya@gmail.com1",
            product = "1",
            expectedQuantity = "(1)",
            authCookieName = "NOPCOMMERCE.AUTH",
            cartCookieName = "Nop.customer";

    @Test
    @Tag("demowebshop")
    @DisplayName("Check that (1) item is displayed in Cart by authorized user")
    void itemExistsInCartOnMainPage() {
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

            step("Get Cart state cookie by api", () -> {
                String cartCookieValue = given()
                        .filter(withCustomTemplates())
                        .contentType("application/x-www-form-urlencoded")
                        .cookie(authCookieValue)
                        .formParam("addtocart_31.EnteredQuantity", product)
                        .log().all()
                        .when()
                        .post("/addproducttocart/details/31/1")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().cookie(cartCookieName);

                step("Open minimal content to set cookies", () ->
                        open("/Themes/DefaultClean/Content/images/logo.png"));
                step("Set Auth and Cart cookies to to browser", () -> {
                    Cookie authCookie = new Cookie(authCookieName, authCookieValue);
                    WebDriverRunner.getWebDriver().manage().addCookie(authCookie);

                    Cookie cartCookie = new Cookie(cartCookieName, cartCookieValue);
                    WebDriverRunner.getWebDriver().manage().addCookie(cartCookie);
                });
            });

            step("Open main page", () ->
                    open(""));
            step("Verify that (1) product is in cart", () ->
                    $(".ico-cart").shouldHave(text(expectedQuantity)));
        });
    }
}
