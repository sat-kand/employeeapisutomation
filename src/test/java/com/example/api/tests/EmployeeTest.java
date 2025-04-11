package com.example.api.tests;

import com.example.api.base.BaseTest;
import com.example.api.models.Employee;
import com.example.api.utils.JsonUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

public class EmployeeTest extends BaseTest {

    private static String employeeId;

    //Test to create employee using POST
    @Test(priority = 1)
    public void createEmployeeTest() {
        JSONObject employee = Employee.getValidEmployee();
        Response response = given()
            .contentType(ContentType.JSON)
            .body(employee.toString())
            .when()
            .post()
            .then()
            .statusCode(201)
            .extract().response();

        employeeId = response.jsonPath().getString("_id");
        Assert.assertNotNull(employeeId);
    }

    //Test to read the employee data using GET
    @Test(priority = 2, dependsOnMethods = "createEmployeeTest")
    public void getEmployeeTest() throws Exception {
        given()
            .when()
            .get("/" + employeeId)
            .then()
            .statusCode(200)
            .body("FirstName", equalTo("John"))
            .body(matchesJsonSchema(JsonUtil.readFileAsString("src/test/resources/schemas/employee-schema.json")));
    }

    //Test to delete the employee entity using DELETE
    @Test(priority = 3, dependsOnMethods = "getEmployeeTest")
    public void deleteEmployeeTest() {
        given()
            .when()
            .delete("/" + employeeId)
            .then()
            .statusCode(200);
    }

    //Negative Test to read an employee which is not available
    @Test(priority = 4, dependsOnMethods = "deleteEmployeeTest")
    public void getDeletedEmployeeTest() {
        given()
            .when()
            .get("/" + employeeId)
            .then()
            .statusCode(404);
    }
}