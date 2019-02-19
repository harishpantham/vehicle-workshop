package com.vehicle.workshop.serviceI;

import com.vehicle.workshop.dto.EmployeeDTO;
import com.vehicle.workshop.utils.YanResponse;

public interface EmployeeServiceI {

    YanResponse getAllEmployees();

    YanResponse saveEmployees(EmployeeDTO employeeDTO);

    YanResponse updateEmployees(EmployeeDTO employeeDTO);

    YanResponse deleteEmployees(Long employeeId);

    YanResponse getEmployeeById(Long employeeId);
}
