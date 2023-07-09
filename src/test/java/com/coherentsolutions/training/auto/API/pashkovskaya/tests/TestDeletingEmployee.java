package com.coherentsolutions.training.auto.API.pashkovskaya.tests;

import com.coherentsolutions.training.auto.API.pashkovskaya.specs.Specs;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static com.coherentsolutions.training.auto.API.pashkovskaya.util.MainConstants.*;

public class TestDeletingEmployee {
    public static final String SUCCESS_MESSAGE_TEXT = "Successfully! Record has been deleted";

    @Test
    public void TestDeletingEmployee(){
        Specs.instalSpec(Specs.requestSpec(BASE_URI, BASE_PATH), Specs.responseSpecOK200());

        RestAssured
                .given()
                .when()
                    .delete("/delete/1")
                .then()
                    .body("message", Matchers.equalTo(SUCCESS_MESSAGE_TEXT));
    }
}
