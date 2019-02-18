package com.vehicle.workshop.repo;

import com.vehicle.workshop.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {


}


