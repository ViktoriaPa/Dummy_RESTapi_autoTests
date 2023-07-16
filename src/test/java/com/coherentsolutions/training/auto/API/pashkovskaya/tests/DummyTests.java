package com.coherentsolutions.training.auto.API.pashkovskaya.tests;

import com.coherentsolutions.training.auto.API.pashkovskaya.base.BaseTest;
import com.coherentsolutions.training.auto.API.pashkovskaya.model.Employee;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class DummyTests extends BaseTest {
    public static final String SUCCESS_MESSAGE_TEXT_EMPLOYEE_CREATING = "Successfully! Record has been added.";
    public static final String SUCCESS_MESSAGE_TEXT_EMPLOYEE_DELETING = "Successfully! Record has been deleted";
    public static final String SUCCESS_MESSAGE_TEXT_GETTING_EMPLOYEE = "Successfully! Record has been fetched.";
    public static final String SUCCESS_MESSAGE_TEXT_GETTING_EMPLOYEES = "Successfully! All records has been fetched.";
    public static final String SUCCESS_MESSAGE_TEXT_EMPLOYEE_UPDATING = "Successfully! Record has been updated.";

    @Test
    public void TestCreatingEmployee() {
        Employee employee = new Employee("Vika", "10000", "27");

        RestAssured
                .given()
                .when()
                    .body(employee)
                    .post("/create")
                .then()
                    .body("message", Matchers.equalTo(SUCCESS_MESSAGE_TEXT_EMPLOYEE_CREATING));
    }

    @Test
    public void TestDeletingEmployee() {
        RestAssured
                .given()
                .when()
                .delete("/delete/1")
                .then()
                .body("message", Matchers.equalTo(SUCCESS_MESSAGE_TEXT_EMPLOYEE_DELETING));
    }

    @Test
    public void TestGettingEmployee() {
        RestAssured
                .given()
                .when()
                .get("/employee/1")
                .then()
                .body("message", Matchers.equalTo(SUCCESS_MESSAGE_TEXT_GETTING_EMPLOYEE));
    }

    @Test
    public void TestGettingEmployees() {
        RestAssured
                .given()
                .when()
                .get("/employees")
                .then()
                .body("message", Matchers.equalTo(SUCCESS_MESSAGE_TEXT_GETTING_EMPLOYEES));
    }

    @Test
    public void TestUpdateEmployeeData() {
        Employee employee = new Employee("Vika", "10000", "27");

        RestAssured
                .given()
                .when()
                .body(employee)
                .put("/update/1")
                .then()
                .body("message", Matchers.equalTo(SUCCESS_MESSAGE_TEXT_EMPLOYEE_UPDATING));
    }
}
