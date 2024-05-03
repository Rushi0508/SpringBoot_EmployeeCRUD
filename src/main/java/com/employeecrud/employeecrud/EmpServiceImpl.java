package com.employeecrud.employeecrud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

    List<Employee> employees  = new ArrayList<>();

    @Override
    public String createEmployee(Employee emp) {
        employees.add(emp);
        return "Created Successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return employees.remove(id);
    }



    @Override
    public String updateEmployee(Employee emp) {
        return "Updated Successfully";
    }
    
}
