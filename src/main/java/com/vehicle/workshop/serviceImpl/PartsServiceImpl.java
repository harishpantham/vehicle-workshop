package com.vehicle.workshop.serviceImpl;

import com.vehicle.workshop.component.Messages;
import com.vehicle.workshop.utils.Helper;
import com.vehicle.workshop.utils.YanResponse;
import com.vehicle.workshop.dto.PartsDTO;
import com.vehicle.workshop.model.Parts;
import com.vehicle.workshop.repo.PartsRepository;
import com.vehicle.workshop.serviceI.PartsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PartsServiceImpl implements PartsServiceI {

    @Autowired
    PartsRepository partsRepository;

    @Autowired
    Messages messageService;

    @Override
    public YanResponse getAllParts() {
        List<Parts> partsList = partsRepository.findAll();
        YanResponse yanResponse = new YanResponse();
        if (!StringUtils.isEmpty(partsList) && partsList.size() > 0) {
            List<PartsDTO> partsDTOList = getPartsToDtoMapping(partsList);
            yanResponse.setMessage(messageService.getMessage("success.message"));
            yanResponse.setStatus(HttpStatus.OK.value());
            yanResponse.setPayLoad(partsDTOList);
            return yanResponse;
        }
        yanResponse.setMessage(messageService.getMessage("part.no"));
        yanResponse.setStatus(HttpStatus.OK.value());
        return yanResponse;
    }

    @Override
    public YanResponse getPartsById(Long partId) {
        YanResponse yanResponse = new YanResponse();
        if (StringUtils.isEmpty(partId) && partId > 0) {
            Optional<Parts> optionalPart = partsRepository.findById(partId);
            if (optionalPart.isPresent()) {
                List<Parts> partsList = new ArrayList<>();
                Parts parts = optionalPart.get();
                partsList.add(parts);
                List<PartsDTO> partsDTOList = getPartsToDtoMapping(partsList);
                yanResponse.setMessage(messageService.getMessage("success.message"));
                yanResponse.setStatus(HttpStatus.OK.value());
                yanResponse.setPayLoad(partsDTOList);
            } else {
                yanResponse.setMessage(messageService.getMessage("part.no"));
                yanResponse.setStatus(HttpStatus.OK.value());
            }
        }
        return yanResponse;
    }

    @Override
    public YanResponse saveParts(PartsDTO partsDTO) {
        YanResponse yanResponse = new YanResponse();
        if (partsDTO != null) {
            if (!StringUtils.isEmpty(partsDTO.getId()) && partsDTO.getId() > 0) {
                return updateParts(partsDTO);
            } else {
                Parts parts = new Parts();
                parts = mapDtoToEntity(partsDTO, parts);
                partsRepository.save(parts);
                yanResponse.setStatus(HttpStatus.OK.value());
                yanResponse.setMessage(messageService.getMessage("part.save"));
            }
        } else {
            yanResponse.setMessage(messageService.getMessage("invalid.data"));
            yanResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return yanResponse;

    }

    @Override
    public YanResponse updateParts(PartsDTO partsDTO) {
        YanResponse yanResponse = new YanResponse();
        if (partsDTO != null) {
            if (!StringUtils.isEmpty(partsDTO.getId()) && partsDTO.getId() > 0) {
                Optional<Parts> optionalParts = partsRepository.findById(partsDTO.getId());
                if (optionalParts.isPresent()) {
                    Parts parts = optionalParts.get();
                    parts = mapDtoToEntity(partsDTO, parts);
                    partsRepository.save(parts);
                    yanResponse.setStatus(HttpStatus.OK.value());
                    yanResponse.setMessage(messageService.getMessage("part.update"));
                } else {
                    yanResponse.setStatus(HttpStatus.NOT_FOUND.value());
                    yanResponse.setMessage(messageService.getMessage("part.not.found"));
                }
            }
        } else {
            yanResponse.setMessage(messageService.getMessage("invalid.data"));
            yanResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return yanResponse;
    }

    @Override
    public YanResponse deleteParts(Long partId) {
        return null;
    }

    private List<PartsDTO> getPartsToDtoMapping(List<Parts> partsList) {
        List<PartsDTO> partsDTOList = new ArrayList<>();
        if (!ObjectUtils.isEmpty(partsDTOList)) {
            for (Parts parts : partsList) {
                PartsDTO partsDTO = new PartsDTO();
                partsDTO.setId(parts.getId());
                partsDTO.setPartCategory(parts.getPartCategory());
                partsDTO.setPartGroup(parts.getPartGroup());
                partsDTO.setPartMaker(parts.getPartMaker());
                partsDTO.setOtherMakersName(parts.getOtherMakersName());
                partsDTO.setName(parts.getName());
                partsDTO.setUOM(parts.getUOM());
                partsDTO.setHSNCode(parts.getHSNCode());
                partsDTO.setPacking(parts.getPacking());
                partsDTO.setTaxTypeEnum(parts.getTaxTypeEnum());
                partsDTO.setTaxPercentage(parts.getTaxPercentage());
                partsDTO.setSurChargePercentage(parts.getSurChargePercentage());
                partsDTO.setMrp(parts.getMrp());
                partsDTO.setSaleRate(parts.getSaleRate());
                partsDTO.setPurchaseRate(parts.getPurchaseRate());
                partsDTO.setItemExpiryDays(parts.getItemExpiryDays());
                partsDTO.setMaxOrderLevel(parts.getMaxOrderLevel());
                partsDTO.setMinOrderLevel(parts.getMinOrderLevel());
                partsDTO.setRemarks(parts.getRemarks());
                partsDTO.setCurrentStock(parts.getCurrentStock());
                partsDTO.setActive(parts.getActive());
                partsDTO.setCreatedOn(Helper.getLongFromTimestamp(parts.getCreatedOn()));
                partsDTOList.add(partsDTO);
            }
        }
        return partsDTOList;
    }

    private Parts mapDtoToEntity(PartsDTO partsDTO, Parts parts) {
        if (!StringUtils.isEmpty(partsDTO.getId())) {
            parts.setId(partsDTO.getId());
        }
        if (!StringUtils.isEmpty(partsDTO.getPartCategory())) {
            parts.setPartCategory(partsDTO.getPartCategory());
        }
        if (!StringUtils.isEmpty(partsDTO.getPartGroup())) {
            parts.setPartGroup(partsDTO.getPartGroup());
        }
        if (!StringUtils.isEmpty(partsDTO.getPartMaker())) {
            parts.setPartMaker(partsDTO.getPartMaker());
        }
        if (!StringUtils.isEmpty(partsDTO.getOtherMakersName())) {
            parts.setOtherMakersName(partsDTO.getOtherMakersName());
        }
        if (!StringUtils.isEmpty(partsDTO.getName())) {
            parts.setName(partsDTO.getName());
        }
        if (!StringUtils.isEmpty(partsDTO.getUOM())) {
            parts.setUOM(partsDTO.getUOM());
        }
        if (!StringUtils.isEmpty(partsDTO.getHSNCode())) {
            parts.setHSNCode(partsDTO.getHSNCode());
        }
        if (!StringUtils.isEmpty(partsDTO.getPacking())) {
            parts.setPacking(partsDTO.getPacking());
        }
        if (!StringUtils.isEmpty(partsDTO.getTaxTypeEnum())) {
            parts.setTaxTypeEnum(partsDTO.getTaxTypeEnum());
        }
        if (!StringUtils.isEmpty(partsDTO.getTaxPercentage())) {
            parts.setTaxPercentage(partsDTO.getTaxPercentage());
        }
        if (!StringUtils.isEmpty(partsDTO.getSurChargePercentage())) {
            parts.setSurChargePercentage(partsDTO.getSurChargePercentage());
        }
        if (!StringUtils.isEmpty(partsDTO.getMrp())) {
            parts.setMrp(partsDTO.getMrp());
        }
        if (!StringUtils.isEmpty(partsDTO.getSaleRate())) {
            parts.setSaleRate(partsDTO.getSaleRate());
        }
        if (!StringUtils.isEmpty(partsDTO.getPurchaseRate())) {
            parts.setPurchaseRate(partsDTO.getPurchaseRate());
        }
        if (!StringUtils.isEmpty(partsDTO.getMrp())) {
            parts.setMrp(partsDTO.getMrp());
        }
        if (!StringUtils.isEmpty(partsDTO.getMrp())) {
            parts.setMrp(partsDTO.getMrp());
        }
        if (!StringUtils.isEmpty(partsDTO.getPurchaseRate())) {
            parts.setPurchaseRate(partsDTO.getPurchaseRate());
        }
        if (!StringUtils.isEmpty(partsDTO.getItemExpiryDays())) {
            parts.setItemExpiryDays(partsDTO.getItemExpiryDays());
        }
        if (!StringUtils.isEmpty(partsDTO.getMaxOrderLevel())) {
            parts.setMaxOrderLevel(partsDTO.getMaxOrderLevel());
        }
        if (!StringUtils.isEmpty(partsDTO.getMinOrderLevel())) {
            parts.setMinOrderLevel(partsDTO.getMinOrderLevel());
        }
        if (!StringUtils.isEmpty(partsDTO.getBillNumber())) {
            parts.setBillNumber(partsDTO.getBillNumber());
        }
        if (!StringUtils.isEmpty(partsDTO.getRemarks())) {
            parts.setRemarks(partsDTO.getRemarks());
        }
        if (!StringUtils.isEmpty(partsDTO.getCurrentStock())) {
            parts.setCurrentStock(partsDTO.getCurrentStock());
        }
        if (!StringUtils.isEmpty(partsDTO.getActive())) {
            parts.setActive(partsDTO.getActive());
        }
        return parts;
    }
}
