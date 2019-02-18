package com.vehicle.workshop.serviceImpl;

import com.vehicle.workshop.dto.ServiceDTO;
import com.vehicle.workshop.repo.ServiceRepository;
import com.vehicle.workshop.serviceI.ServiceI;
import com.vehicle.workshop.utils.YanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements ServiceI {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public YanResponse getAllServices() {
        return null;
    }

    @Override
    public YanResponse saveServices(ServiceDTO serviceDTO) {
        return null;
    }

    @Override
    public YanResponse updateServices(ServiceDTO serviceDTO) {
        return null;
    }

    @Override
    public YanResponse deleteServices(Long serviceId) {
        return null;
    }

    @Override
    public YanResponse getServicesById(Long serviceId) {
        return null;
    }
}
