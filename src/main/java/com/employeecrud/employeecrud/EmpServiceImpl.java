package com.employeecrud.employeecrud;

import java.util.ArrayList;
import java.util.List;

public class EmpServiceImpl implements EmpService {

    List<Employee> employees  = new ArrayList<>();

    @Override
    public Employee createEmployee(Employee emp) {
        employees.add(emp);
        return emp;
    }

    @Override
    public List<Employee> readEmployees() {
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return true;
    }



    @Override
    public Employee updateEmployee(Employee emp) {
        return emp;
    }
    
}
