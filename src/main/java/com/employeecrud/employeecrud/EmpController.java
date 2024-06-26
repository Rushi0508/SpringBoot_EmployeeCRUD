package com.employeecrud.employeecrud;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class EmpController {

    private final EmpService employeeService;

    // DI using constructor (Good Practice)
    // When only one constructor no need for @Autowired, by default it will be used for DI
    // @Autowired
    public EmpController(EmpService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.readEmployeeById(id);
    }
    
    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee emp) {
        return employeeService.createEmployee(emp);
    }

    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
        if(employeeService.updateEmployee(id, emp)){
            return "Updated Successfully";
        }
        return "Something went wrong";
    }
    
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleteEmployee(id)){
            return "Delete Successfully";
        }
        return "Something went wrong";
    }
}
