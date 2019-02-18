package com.vehicle.workshop.serviceI;

import com.vehicle.workshop.dto.ServiceDTO;
import com.vehicle.workshop.utils.YanResponse;

public interface ServiceI {


    YanResponse getAllServices();

    YanResponse saveServices(ServiceDTO serviceDTO);

    YanResponse updateServices(ServiceDTO serviceDTO);

    YanResponse deleteServices(Long serviceId);

    YanResponse getServicesById(Long serviceId);
}
