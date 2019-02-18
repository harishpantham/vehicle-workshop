package com.vehicle.workshop.serviceI;

import com.vehicle.workshop.dto.LabourWorkDTO;
import com.vehicle.workshop.utils.YanResponse;

public interface LabourWorkServiceI {

    YanResponse getAllLabourWork();

    YanResponse getLabourWorkById(Long labourId);

    YanResponse saveLabourWork(LabourWorkDTO labourWorkDTO);

    YanResponse updateLabourWork(LabourWorkDTO labourWorkDTO);

    YanResponse deleteLabourWork(Long labourId);
}
