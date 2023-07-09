package com.coherentsolutions.training.auto.API.pashkovskaya.tests;

import com.coherentsolutions.training.auto.API.pashkovskaya.specs.Specs;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static com.coherentsolutions.training.auto.API.pashkovskaya.util.MainConstants.*;

public class TestGettingEmployees {
    public static final String SUCCESS_MESSAGE_TEXT = "Successfully! All records has been fetched.";

    @Test
    public void TestGettingEmployees() {
        Specs.instalSpec(Specs.requestSpec(BASE_URI, BASE_PATH), Specs.responseSpecOK200());
        
        RestAssured
                .given()
                .when()
                   .get("/employees")
                .then()
                    .body("message", Matchers.equalTo(SUCCESS_MESSAGE_TEXT));
    }
}
