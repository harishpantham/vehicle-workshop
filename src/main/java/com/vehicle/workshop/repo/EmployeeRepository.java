package com.vehicle.workshop.repo;

import com.vehicle.workshop.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
