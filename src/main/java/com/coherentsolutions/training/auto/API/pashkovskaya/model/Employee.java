package com.coherentsolutions.training.auto.API.pashkovskaya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @JsonProperty("employee_name")
    private String employeeName;
    @JsonProperty("employee_salary")
    private String employeeSalary;
    @JsonProperty("employee_age")
    private String employeeAge;
}
