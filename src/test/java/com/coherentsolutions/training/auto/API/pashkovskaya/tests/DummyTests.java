package com.coherentsolutions.training.auto.API.pashkovskaya.tests;

import com.coherentsolutions.training.auto.API.pashkovskaya.base.BaseTest;
import com.coherentsolutions.training.auto.API.pashkovskaya.model.Employee;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DummyTests extends BaseTest {
    private static final String SUCCESS_MESSAGE_TEXT_EMPLOYEE_CREATING = "Successfully! Record has been added.";
    private static final String SUCCESS_MESSAGE_TEXT_EMPLOYEE_DELETING = "Successfully! Record has been deleted";
    private static final String SUCCESS_MESSAGE_TEXT_GETTING_EMPLOYEE = "Successfully! Record has been fetched.";
    private static final String SUCCESS_MESSAGE_TEXT_GETTING_EMPLOYEES = "Successfully! All records has been fetched.";
    private static final String SUCCESS_MESSAGE_TEXT_EMPLOYEE_UPDATING = "Successfully! Record has been updated.";
    private int newlyCreatedEmployeeID;

    @Test(priority = 1)
    public void testCreatingValidEmployee() {
        Employee employee = new Employee("Vika", "10000", "27");

        Employee employees = given()
                .when()
                    .body(employee)
                    .post("/create")
                .then()
                    .body("message", Matchers.equalTo(SUCCESS_MESSAGE_TEXT_EMPLOYEE_CREATING))
                    .extract().body().jsonPath().getObject("data", Employee.class);

        newlyCreatedEmployeeID = employees.getId();
    }
    @Test(priority = 2)
    public void testUpdatingEmployeeWithValidData() {
        Employee employee = new Employee("Pasha", "11000", "29", newlyCreatedEmployeeID);

        given()
                .when()
                .body(employee)
                .put("/update/" + newlyCreatedEmployeeID)
                .then()
                .body("message", Matchers.equalTo(SUCCESS_MESSAGE_TEXT_EMPLOYEE_UPDATING))
                .extract().body().jsonPath().getObject("data", Employee.class);
    }
    @Test(priority = 3)
    public void testEmployeeDataIsFilledIn() {
        given()
                .when()
                .get("/employee/" + newlyCreatedEmployeeID)
                .then()
                .body("message", Matchers.equalTo(SUCCESS_MESSAGE_TEXT_GETTING_EMPLOYEE))
                .body("data", Matchers.notNullValue());
    }
    @Test(priority = 4)
    public void testDeletingExistingEmployee() {
        given()
                .when()
                .delete("/delete/" + newlyCreatedEmployeeID)
                .then()
                .body("message", Matchers.equalTo(SUCCESS_MESSAGE_TEXT_EMPLOYEE_DELETING));
    }

    @Test(priority = 5)
    public void testGettingAllCreatedEmployees() {
        given()
                .when()
                .get("/employees")
                .then()
                .body("message", Matchers.equalTo(SUCCESS_MESSAGE_TEXT_GETTING_EMPLOYEES));
    }
}
