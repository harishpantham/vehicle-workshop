package com.vehicle.workshop.serviceImpl;

import com.vehicle.workshop.component.Messages;
import com.vehicle.workshop.dto.LabourWorkDTO;
import com.vehicle.workshop.model.LabourWork;
import com.vehicle.workshop.repo.LabourWorkRepository;
import com.vehicle.workshop.serviceI.LabourWorkServiceI;
import com.vehicle.workshop.utils.Helper;
import com.vehicle.workshop.utils.YanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LabourWorkServiceImpl implements LabourWorkServiceI {

    @Autowired
    LabourWorkRepository labourWorkRepository;

    @Autowired
    Messages messageService;

    @Override
    public YanResponse getAllLabourWork() {
        List<LabourWork> labourWorkList = labourWorkRepository.findAll();
        YanResponse yanResponse = new YanResponse();
        if (!StringUtils.isEmpty(labourWorkList) && labourWorkList.size() > 0) {
            List<LabourWorkDTO> labourWorkDTOList = getLabourWorkToDtoMapping(labourWorkList);
            yanResponse.setMessage(messageService.getMessage("success.message"));
            yanResponse.setStatus(HttpStatus.OK.value());
            yanResponse.setPayLoad(labourWorkDTOList);
            return yanResponse;
        }
        yanResponse.setMessage(messageService.getMessage("labour.no"));
        yanResponse.setStatus(HttpStatus.OK.value());
        return yanResponse;
    }

    @Override
    public YanResponse getLabourWorkById(Long labourId) {
        YanResponse yanResponse = new YanResponse();
        if (StringUtils.isEmpty(labourId) && labourId > 0) {
            Optional<LabourWork> optionalLabourWork = labourWorkRepository.findById(labourId);
            if (optionalLabourWork.isPresent()) {
                List<LabourWork> labourWorkList = new ArrayList<>();
                LabourWork labourWork = optionalLabourWork.get();
                labourWorkList.add(labourWork);
                List<LabourWorkDTO> labourWorkDTOList = getLabourWorkToDtoMapping(labourWorkList);
                yanResponse.setMessage(messageService.getMessage("success.message"));
                yanResponse.setStatus(HttpStatus.OK.value());
                yanResponse.setPayLoad(labourWorkDTOList);
            } else {
                yanResponse.setMessage(messageService.getMessage("labour.no"));
                yanResponse.setStatus(HttpStatus.OK.value());
            }
        }
        return yanResponse;
    }

    @Override
    public YanResponse saveLabourWork(LabourWorkDTO labourWorkDTO) {
        YanResponse yanResponse = new YanResponse();
        if (labourWorkDTO != null) {
            if (!StringUtils.isEmpty(labourWorkDTO.getId()) && labourWorkDTO.getId() > 0) {
                return updateLabourWork(labourWorkDTO);
            } else {
                LabourWork labourWork = new LabourWork();
                labourWork = mapDtoToEntity(labourWorkDTO, labourWork);
                labourWorkRepository.save(labourWork);
                yanResponse.setStatus(HttpStatus.OK.value());
                yanResponse.setMessage(messageService.getMessage("labour.save"));
            }
        } else {
            yanResponse.setMessage(messageService.getMessage("invalid.data"));
            yanResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return yanResponse;
    }

    @Override
    public YanResponse updateLabourWork(LabourWorkDTO labourWorkDTO) {
        YanResponse yanResponse = new YanResponse();
        if (labourWorkDTO != null) {
            if (!StringUtils.isEmpty(labourWorkDTO.getId()) && labourWorkDTO.getId() > 0) {
                Optional<LabourWork> optionalLabourWork = labourWorkRepository.findById(labourWorkDTO.getId());
                if (optionalLabourWork.isPresent()) {
                    LabourWork labourWork = optionalLabourWork.get();
                    labourWork = mapDtoToEntity(labourWorkDTO, labourWork);
                    labourWorkRepository.save(labourWork);
                    yanResponse.setStatus(HttpStatus.OK.value());
                    yanResponse.setMessage(messageService.getMessage("labour.update"));
                } else {
                    yanResponse.setStatus(HttpStatus.NOT_FOUND.value());
                    yanResponse.setMessage(messageService.getMessage("labour.not.found"));
                }
            }
        } else {
            yanResponse.setMessage(messageService.getMessage("invalid.data"));
            yanResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return yanResponse;
    }

    @Override
    public YanResponse deleteLabourWork(Long labourId) {
        return null;
    }

    private List<LabourWorkDTO> getLabourWorkToDtoMapping(List<LabourWork> labourWorkList) {
        List<LabourWorkDTO> labourWorkDTOList = new ArrayList<>();
        for (LabourWork labourWork : labourWorkList) {
            LabourWorkDTO labourWorkDTO = new LabourWorkDTO();
            labourWorkDTO.setId(labourWork.getId());
            labourWorkDTO.setWorkStatus(labourWork.getWorkStatus());
            labourWorkDTO.setCreatedOn(Helper.getLongFromTimestamp(labourWork.getCreatedOn()));
            labourWorkDTOList.add(labourWorkDTO);
        }
        return labourWorkDTOList;
    }

    private LabourWork mapDtoToEntity(LabourWorkDTO labourWorkDTO, LabourWork labourWork) {
        if (!StringUtils.isEmpty(labourWorkDTO.getId())) {
            labourWork.setId(labourWorkDTO.getId());
        }
        if (!StringUtils.isEmpty(labourWorkDTO.getWorkStatus())) {
            labourWork.setWorkStatus(labourWorkDTO.getWorkStatus());
        }
        return labourWork;
    }
}
