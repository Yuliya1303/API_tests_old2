package com.yuliya1303.helpers;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specs {

    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .contentType("application/x-www-form-urlencoded");

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();
}