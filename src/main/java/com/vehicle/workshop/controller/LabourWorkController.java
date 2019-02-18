package com.vehicle.workshop.controller;

import com.vehicle.workshop.dto.LabourWorkDTO;
import com.vehicle.workshop.serviceI.LabourWorkServiceI;
import com.vehicle.workshop.utils.YanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class LabourWorkController {

    @Autowired
    LabourWorkServiceI labourWorkServiceI;

    @GetMapping("/labour-work")
    public YanResponse getAllLabourWork() throws Exception {
        return labourWorkServiceI.getAllLabourWork();
    }

    @GetMapping("/labour-work/{labourId}")
    public YanResponse getLabourWorkById(@PathVariable final Long labourId) throws Exception {
        return labourWorkServiceI.getLabourWorkById(labourId);
    }

    @PostMapping("/labour-work")
    public YanResponse saveLabourWork(@RequestBody LabourWorkDTO labourWorkDTO) throws Exception {
        return labourWorkServiceI.saveLabourWork(labourWorkDTO);
    }

    @PutMapping("/labour-work")
    public YanResponse updateLabourWork(@RequestBody LabourWorkDTO labourWorkDTO) throws Exception {
        return labourWorkServiceI.updateLabourWork(labourWorkDTO);
    }

    @DeleteMapping("/labour-work/{labourId}")
    public YanResponse deleteLabourWork(@PathVariable final Long labourId) throws Exception {
        return labourWorkServiceI.deleteLabourWork(labourId);
    }

}
