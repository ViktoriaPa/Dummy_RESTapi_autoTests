package com.coherentsolutions.training.auto.API.pashkovskaya.tests;

import com.coherentsolutions.training.auto.API.pashkovskaya.Employee;
import com.coherentsolutions.training.auto.API.pashkovskaya.specs.Specs;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static com.coherentsolutions.training.auto.API.pashkovskaya.util.MainConstants.*;

public class TestCreatingEmployee {
    public static final String SUCCESS_MESSAGE_TEXT = "Successfully! Record has been added.";

    @Test
    public void TestCreatingEmployee(){
        Specs.instalSpec(Specs.requestSpec(BASE_URI, BASE_PATH), Specs.responseSpecOK200());
        Employee employee = new Employee("Vika", "10000", "27");

        RestAssured
                .given()
                .when()
                    .body(employee)
                    .post("/create")
                .then()
                    .body("message", Matchers.equalTo(SUCCESS_MESSAGE_TEXT));
    }
}
