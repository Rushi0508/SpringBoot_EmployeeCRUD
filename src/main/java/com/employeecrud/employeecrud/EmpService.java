package com.employeecrud.employeecrud;

import java.util.List;

public interface EmpService {
    Employee createEmployee(Employee emp);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    Employee updateEmployee(Employee emp);
}
