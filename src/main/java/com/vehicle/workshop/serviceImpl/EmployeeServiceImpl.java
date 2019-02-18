package com.vehicle.workshop.serviceImpl;

import com.vehicle.workshop.component.Messages;
import com.vehicle.workshop.dto.EmployeeDTO;
import com.vehicle.workshop.model.Employee;
import com.vehicle.workshop.repo.EmployeeRepository;
import com.vehicle.workshop.serviceI.EmployeeServiceI;
import com.vehicle.workshop.utils.YanResponse;
import com.vehicle.workshop.dto.PartsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    Messages messageService;

    @Override
    public YanResponse getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        YanResponse yanResponse = new YanResponse();
        if (!StringUtils.isEmpty(employeeList) && employeeList.size() > 0) {
            List<PartsDTO> partsDTOList = getEmployeesToDtoMapping(employeeList);
            yanResponse.setMessage(messageService.getMessage("success.message"));
            yanResponse.setStatus(HttpStatus.OK.value());
            yanResponse.setPayLoad(partsDTOList);
            return yanResponse;
        }
        yanResponse.setMessage(messageService.getMessage("employee.no"));
        yanResponse.setStatus(HttpStatus.OK.value());
        return yanResponse;
    }

    private List<PartsDTO> getEmployeesToDtoMapping(List<Employee> employeeList) {

        if (employeeList != null && employeeList.size() > 0) {

        }


        return null;
    }

    @Override
    public YanResponse saveEmployees(EmployeeDTO partsDTO) {
        return null;
    }

    @Override
    public YanResponse updateEmployees(EmployeeDTO partsDTO) {
        return null;
    }

    @Override
    public YanResponse deleteEmployees(Long employeeId) {
        return null;
    }

    @Override
    public YanResponse getEmployeeById(Long employeeId) {
        return null;
    }
}
