package com.employeecrud.employeecrud;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String name;
    private String email;
    private String age;
    private String salary;
}
