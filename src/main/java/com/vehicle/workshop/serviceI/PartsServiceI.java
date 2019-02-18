package com.vehicle.workshop.serviceI;

import com.vehicle.workshop.utils.YanResponse;
import com.vehicle.workshop.dto.PartsDTO;

public interface PartsServiceI {

    YanResponse getAllParts();

    YanResponse saveParts(PartsDTO partsDTO);

    YanResponse getPartsById(Long partId);

    YanResponse deleteParts(Long partId);

    YanResponse updateParts(PartsDTO partsDTO);
}
