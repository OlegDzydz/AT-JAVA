package com.example.bo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserBO {
    public Response createUser(String json) {
        return RestAssured.given()
                .contentType("application/json")
                .body(json)
                .post("https://reqres.in/api/users");
    }
}
