package com.employeecrud.employeecrud;

import java.util.List;

public interface EmpService {
    String createEmployee(Employee emp);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    boolean updateEmployee(Long id, Employee emp);
    Employee readEmployeeById(Long id);
}
