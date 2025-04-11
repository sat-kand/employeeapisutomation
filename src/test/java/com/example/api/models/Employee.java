package com.example.api.models;

import org.json.JSONObject;

public class Employee {
    public static JSONObject getValidEmployee() {
        JSONObject obj = new JSONObject();
        obj.put("FirstName", "John");
        obj.put("LastName", "Doe");
        obj.put("DateOfBirth", "1990-01-01");
        obj.put("StartDate", "2023-01-01");
        obj.put("Department", "QA");
        obj.put("JobTitle", "Engineer");
        obj.put("Email", "john.doe@example.com");
        obj.put("Mobile", "0400123456");
        obj.put("Address", "123 Street");
        obj.put("BaseSalary", 70000);
        return obj;
    }
}
