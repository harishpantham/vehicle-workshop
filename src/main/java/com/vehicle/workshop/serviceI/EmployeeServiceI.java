package com.vehicle.workshop.serviceI;

import com.vehicle.workshop.utils.YanResponse;
import com.vehicle.workshop.dto.EmployeeDTO;

public interface EmployeeServiceI {
    YanResponse getAllEmployees();

    YanResponse saveEmployees(EmployeeDTO partsDTO);

    YanResponse updateEmployees(EmployeeDTO partsDTO);

    YanResponse deleteEmployees(Long employeeId);

    YanResponse getEmployeeById(Long employeeId);
}
