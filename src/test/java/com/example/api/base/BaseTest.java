package com.example.api.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    //Constructing the URL with dynamic token

    @BeforeClass
    public void setup() {

        String token = System.getProperty("token");
        final String BASE_URL = "https://crudcrud.com/api/" + token + "/Employees";

        if (token == null || token.isEmpty()) {
            throw new RuntimeException("Token for execution is not set!");
        }

        RestAssured.baseURI = BASE_URL;
    }
}
