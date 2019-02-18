package com.vehicle.workshop.controller;

import com.vehicle.workshop.serviceI.EmployeeServiceI;
import com.vehicle.workshop.utils.YanResponse;
import com.vehicle.workshop.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class EmployeeController {

    @Autowired
    EmployeeServiceI employeeServiceI;

    @GetMapping("/employees")
    public YanResponse getAllEmployees() throws Exception {
        return employeeServiceI.getAllEmployees();
    }

    @PostMapping("/employees")
    public YanResponse saveEmployees(@RequestBody EmployeeDTO employeeDTO) throws Exception {
        return employeeServiceI.saveEmployees(employeeDTO);
    }

    @PutMapping("/employees")
    public YanResponse updateEmployees(@RequestBody EmployeeDTO employeeDTO) throws Exception {
        return employeeServiceI.updateEmployees(employeeDTO);
    }

    @DeleteMapping("/employees/{employeeId}")
    public YanResponse deleteEmployees(@PathVariable final Long employeeId) throws Exception {
        return employeeServiceI.deleteEmployees(employeeId);
    }

    @GetMapping("/employees/{employeeId}")
    public YanResponse getEmployeesById(@PathVariable final Long employeeId) throws Exception {
        return employeeServiceI.getEmployeeById(employeeId);
    }


}
