package com.employeecrud.employeecrud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

    private final EmpRepository empRepo;

    public EmpServiceImpl(EmpRepository empRepo){
        this.empRepo = empRepo;
    }

    @Override
    public String createEmployee(Employee emp) {
        EmpEntity empEntity = new EmpEntity();
        BeanUtils.copyProperties(emp, empEntity);
        empRepo.save(empEntity);
        return "Created Successfully";
    } 

    @Override
    public List<Employee> readEmployees() {
        List<EmpEntity> employeesList = empRepo.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmpEntity employee : employeesList) {
            Employee e = new Employee();
            e.setId(employee.getId());
            e.setName(employee.getName());
            e.setAge(employee.getAge());
            e.setEmail(employee.getEmail());
            e.setSalary(employee.getSalary());

            employees.add(e);
        }
        return employees;
    }

    @Override 
    public Employee readEmployeeById(Long id){
        EmpEntity e = empRepo.findById(id).get();
        Employee emp = new Employee();
        BeanUtils.copyProperties(e, emp);
        return emp;
    }

    @Override
    public boolean deleteEmployee(Long id){
        EmpEntity e = empRepo.findById(id).get();
        empRepo.delete(e);
        return true;
    }

    @Override
    public boolean updateEmployee(Long id, Employee e){
        EmpEntity existingEmp = empRepo.findById(id).get();
        existingEmp.setAge(e.getAge());
        existingEmp.setName(e.getName());
        existingEmp.setEmail(e.getEmail());
        existingEmp.setSalary(e.getSalary());

        empRepo.save(existingEmp);
        return true;
    }
    
}
