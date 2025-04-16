package com.example.tests;

import com.example.bo.UserBO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

public class ApiTest {
    private final UserBO userBO = new UserBO();

    @Test
    public void testCreateUser() {
        String json = "{\"name\":\"morpheus\",\"job\":\"leader\"}";
        Response r = userBO.createUser(json);
        Assert.assertEquals(r.getStatusCode(), 201);
        Assert.assertNotNull(r.jsonPath().getString("id"));
    }
}
