package com.vehicle.workshop.controller;

import com.vehicle.workshop.dto.PartsDTO;
import com.vehicle.workshop.serviceI.PartsServiceI;
import com.vehicle.workshop.utils.YanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class PartsController {

    @Autowired
    PartsServiceI partsServiceI;

    @GetMapping("/parts")
    public YanResponse getAllParts() throws Exception {
        return partsServiceI.getAllParts();
    }

    @PostMapping("/parts")
    public YanResponse saveParts(@RequestBody PartsDTO partsDTO) throws Exception {
        return partsServiceI.saveParts(partsDTO);
    }

    @PutMapping("/parts")
    public YanResponse updateParts(@RequestBody PartsDTO partsDTO) throws Exception {
        return partsServiceI.updateParts(partsDTO);
    }

    @DeleteMapping("/parts/{partId}")
    public YanResponse deleteParts(@PathVariable final Long partId) throws Exception {
        return partsServiceI.deleteParts(partId);
    }

    @GetMapping("/parts/{partId}")
    public YanResponse getPartsById(@PathVariable final Long partId) throws Exception {
        return partsServiceI.getPartsById(partId);
    }

}
