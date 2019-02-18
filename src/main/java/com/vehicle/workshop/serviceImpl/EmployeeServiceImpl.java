package com.vehicle.workshop.serviceImpl;

import com.vehicle.workshop.component.Messages;
import com.vehicle.workshop.dto.EmployeeDTO;
import com.vehicle.workshop.model.Employee;
import com.vehicle.workshop.repo.EmployeeRepository;
import com.vehicle.workshop.serviceI.EmployeeServiceI;
import com.vehicle.workshop.utils.Helper;
import com.vehicle.workshop.utils.YanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            List<EmployeeDTO> partsDTOList = getEmployeesToDtoMapping(employeeList);
            yanResponse.setMessage(messageService.getMessage("success.message"));
            yanResponse.setStatus(HttpStatus.OK.value());
            yanResponse.setPayLoad(partsDTOList);
            return yanResponse;
        }
        yanResponse.setMessage(messageService.getMessage("employee.no"));
        yanResponse.setStatus(HttpStatus.OK.value());
        return yanResponse;
    }

    @Override
    public YanResponse getEmployeeById(Long employeeId) {
        YanResponse yanResponse = new YanResponse();
        if (StringUtils.isEmpty(employeeId) && employeeId > 0) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
            if (optionalEmployee.isPresent()) {
                List<Employee> employeeList = new ArrayList<>();
                Employee employee = optionalEmployee.get();
                employeeList.add(employee);
                List<EmployeeDTO> employeeDTOList = getEmployeesToDtoMapping(employeeList);
                yanResponse.setMessage(messageService.getMessage("success.message"));
                yanResponse.setStatus(HttpStatus.OK.value());
                yanResponse.setPayLoad(employeeDTOList);
            } else {
                yanResponse.setMessage(messageService.getMessage("employee.no"));
                yanResponse.setStatus(HttpStatus.OK.value());
            }
        }
        return yanResponse;
    }

    private List<EmployeeDTO> getEmployeesToDtoMapping(List<Employee> employeeList) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setDateOfJoining(Helper.getLongFromTimestamp(employee.getDateOfJoining()));
            employeeDTO.setDepartmentEnum(employee.getDepartmentEnum());
            employeeDTO.setDesignation(employee.getDesignation());
            employeeDTO.setName(employee.getName());
            employeeDTO.setGenderEnum(employee.getGenderEnum());
            employeeDTO.setFatherOrHusbandName(employee.getFatherOrHusbandName());
            employeeDTO.setAddress(employee.getAddress());
            employeeDTO.setCity(employee.getCity());
            employeeDTO.setMobileNumber(employee.getMobileNumber());
            employeeDTO.setPin(employee.getPin());
            employeeDTO.setLandLineNumber(employee.getLandLineNumber());
            employeeDTO.setState(employee.getState());
            employeeDTO.setPanNumber(employee.getPanNumber());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setEmployeeStatusEnum(employee.getEmployeeStatusEnum());
            employeeDTO.setFranchiseId(employee.getFranchiseId());
            employeeDTO.setCreatedOn(Helper.getLongFromTimestamp(employee.getCreatedOn()));
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    @Override
    public YanResponse saveEmployees(EmployeeDTO employeeDTO) {
        YanResponse yanResponse = new YanResponse();
        if (employeeDTO != null) {
            if (!StringUtils.isEmpty(employeeDTO.getId()) && employeeDTO.getId() > 0) {
                return updateEmployees(employeeDTO);
            } else {
                Employee employee = new Employee();
                employee = mapDtoToEntity(employeeDTO, employee);
                employeeRepository.save(employee);
                yanResponse.setStatus(HttpStatus.OK.value());
                yanResponse.setMessage(messageService.getMessage("employee.save"));
            }
        } else {
            yanResponse.setMessage(messageService.getMessage("invalid.data"));
            yanResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return yanResponse;
    }

    @Override
    public YanResponse updateEmployees(EmployeeDTO employeeDTO) {
        YanResponse yanResponse = new YanResponse();
        if (employeeDTO != null) {
            if (!StringUtils.isEmpty(employeeDTO.getId()) && employeeDTO.getId() > 0) {
                Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDTO.getId());
                if (optionalEmployee.isPresent()) {
                    Employee employee = optionalEmployee.get();
                    employee = mapDtoToEntity(employeeDTO, employee);
                    employeeRepository.save(employee);
                    yanResponse.setStatus(HttpStatus.OK.value());
                    yanResponse.setMessage(messageService.getMessage("employee.update"));
                } else {
                    yanResponse.setStatus(HttpStatus.NOT_FOUND.value());
                    yanResponse.setMessage(messageService.getMessage("employee.not.found"));
                }
            }
        } else {
            yanResponse.setMessage(messageService.getMessage("invalid.data"));
            yanResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return yanResponse;
    }

    @Override
    public YanResponse deleteEmployees(Long employeeId) {
        return null;
    }

    private Employee mapDtoToEntity(EmployeeDTO employeeDTO, Employee employee) {

        if (!StringUtils.isEmpty(employeeDTO.getId())) {
            employee.setId(employee.getId());
        }
        if (!StringUtils.isEmpty(employeeDTO.getDateOfJoining())) {
            employee.setDateOfJoining(Helper.getTimestampFromLong(employee.getId()));
        }
        if (!StringUtils.isEmpty(employeeDTO.getDepartmentEnum())) {
            employee.setDepartmentEnum(employee.getDepartmentEnum());
        }
        if (!StringUtils.isEmpty(employeeDTO.getDesignation())) {
            employee.setDesignation(employee.getDesignation());
        }
        if (!StringUtils.isEmpty(employeeDTO.getName())) {
            employee.setName(employee.getName());
        }
        if (!StringUtils.isEmpty(employeeDTO.getGenderEnum())) {
            employee.setGenderEnum(employee.getGenderEnum());
        }
        if (!StringUtils.isEmpty(employeeDTO.getFatherOrHusbandName())) {
            employee.setFatherOrHusbandName(employee.getFatherOrHusbandName());
        }
        if (!StringUtils.isEmpty(employeeDTO.getAddress())) {
            employee.setAddress(employee.getAddress());
        }
        if (!StringUtils.isEmpty(employeeDTO.getCity())) {
            employee.setCity(employee.getCity());
        }
        if (!StringUtils.isEmpty(employeeDTO.getMobileNumber())) {
            employee.setMobileNumber(employee.getMobileNumber());
        }
        if (!StringUtils.isEmpty(employeeDTO.getPin())) {
            employee.setPin(employee.getPin());
        }
        if (!StringUtils.isEmpty(employeeDTO.getLandLineNumber())) {
            employee.setLandLineNumber(employee.getLandLineNumber());
        }
        if (!StringUtils.isEmpty(employeeDTO.getState())) {
            employee.setState(employee.getState());
        }
        if (!StringUtils.isEmpty(employeeDTO.getPanNumber())) {
            employee.setPanNumber(employee.getPanNumber());
        }
        if (!StringUtils.isEmpty(employeeDTO.getEmail())) {
            employee.setEmail(employee.getEmail());
        }
        if (!StringUtils.isEmpty(employeeDTO.getEmployeeStatusEnum())) {
            employee.setEmployeeStatusEnum(employee.getEmployeeStatusEnum());
        }
        if (!StringUtils.isEmpty(employeeDTO.getFranchiseId())) {
            employee.setFranchiseId(employee.getFranchiseId());
        }
        return employee;
    }
}
