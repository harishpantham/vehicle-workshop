package com.vehicle.workshop.controller;

import com.vehicle.workshop.dto.ServiceDTO;
import com.vehicle.workshop.serviceI.ServiceI;
import com.vehicle.workshop.utils.YanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceController {

    @Autowired
    ServiceI serviceI;

    @GetMapping("/services")
    public YanResponse getAllServices() throws Exception {
        return serviceI.getAllServices();
    }

    @GetMapping("/services/{serviceId}")
    public YanResponse getServicesById(@PathVariable final Long serviceId) throws Exception {
        return serviceI.getServicesById(serviceId);
    }


    @PostMapping("/services")
    public YanResponse saveServices(@RequestBody ServiceDTO serviceDTO) throws Exception {
        return serviceI.saveServices(serviceDTO);
    }

    @PutMapping("/services")
    public YanResponse updateServices(@RequestBody ServiceDTO serviceDTO) throws Exception {
        return serviceI.updateServices(serviceDTO);
    }

    @DeleteMapping("/services/{serviceId}")
    public YanResponse deleteServices(@PathVariable final Long serviceId) throws Exception {
        return serviceI.deleteServices(serviceId);
    }

}
