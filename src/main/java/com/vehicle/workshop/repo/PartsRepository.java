package com.vehicle.workshop.repo;

import com.vehicle.workshop.model.Parts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartsRepository extends JpaRepository<Parts,Long> {



}
