package com.vehicle.workshop.serviceImpl;

import com.vehicle.workshop.component.Messages;
import com.vehicle.workshop.dto.AppUserDTO;
import com.vehicle.workshop.model.AppUser;
import com.vehicle.workshop.repo.UserRepository;
import com.vehicle.workshop.serviceI.UserServiceI;
import com.vehicle.workshop.utils.YanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Messages messageService;

    @Override
    public YanResponse getAllUsers() {
        List<AppUser> userList = userRepository.findAll();
        YanResponse yanResponse = new YanResponse();
        if (!StringUtils.isEmpty(userList) && userList.size() > 0) {
            List<AppUserDTO> userDTOList = getAppUserToDtoMapping(userList);
            yanResponse.setMessage(messageService.getMessage("success.message"));
            yanResponse.setStatus(HttpStatus.OK.value());
            yanResponse.setPayLoad(userDTOList);
            return yanResponse;
        } else {
            yanResponse.setMessage(messageService.getMessage("appuser.no"));
            yanResponse.setStatus(HttpStatus.OK.value());
            return yanResponse;
        }
    }

    @Override
    public YanResponse getUserById(Long id) {
        YanResponse yanResponse = new YanResponse();
        if (!StringUtils.isEmpty(id) && id > 0) {
            Optional<AppUser> optionalAppUser = userRepository.findById(id);
            if (optionalAppUser.isPresent()) {
                List<AppUser> userList = new ArrayList<>();
                AppUser user = optionalAppUser.get();
                userList.add(user);
                List<AppUserDTO> userDTOList = getAppUserToDtoMapping(userList);
                yanResponse.setMessage(messageService.getMessage("success.message"));
                yanResponse.setStatus(HttpStatus.OK.value());
                yanResponse.setPayLoad(userDTOList);
            } else {
                yanResponse.setMessage(messageService.getMessage("appuser.no"));
                yanResponse.setStatus(HttpStatus.OK.value());
            }
        } else {
            yanResponse.setMessage(messageService.getMessage("invalid.data"));
            yanResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return yanResponse;
    }

    @Override
    public YanResponse saveUser(AppUserDTO appUserDTO) {
        YanResponse yanResponse = new YanResponse();
        if (appUserDTO != null) {
            if (!StringUtils.isEmpty(appUserDTO.getId()) && appUserDTO.getId() > 0) {
                return updateUser(appUserDTO);
            } else {
                AppUser user = new AppUser();
                user = mapDtoToEntity(appUserDTO, user);
                userRepository.save(user);
                yanResponse.setStatus(HttpStatus.OK.value());
                yanResponse.setMessage(messageService.getMessage("appuser.save"));
            }
        } else {
            yanResponse.setMessage(messageService.getMessage("invalid.data"));
            yanResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return yanResponse;
    }

    @Override
    public YanResponse updateUser(AppUserDTO appUserDTO) {
        YanResponse yanResponse = new YanResponse();
        if (appUserDTO != null) {
            if (!StringUtils.isEmpty(appUserDTO.getId()) && appUserDTO.getId() > 0) {
                Optional<AppUser> optionalAppUser = userRepository.findById(appUserDTO.getId());
                if (optionalAppUser.isPresent()) {
                    AppUser user = optionalAppUser.get();
                    user = mapDtoToEntity(appUserDTO, user);
                    userRepository.save(user);
                    yanResponse.setStatus(HttpStatus.OK.value());
                    yanResponse.setMessage(messageService.getMessage("appuser.update"));
                } else {
                    yanResponse.setStatus(HttpStatus.NOT_FOUND.value());
                    yanResponse.setMessage(messageService.getMessage("appuser.not.found"));
                }
            }
        } else {
            yanResponse.setMessage(messageService.getMessage("invalid.data"));
            yanResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return yanResponse;
    }

    @Override
    public YanResponse deleteUser(Long id) {
        YanResponse yanResponse = new YanResponse();
        userRepository.deleteById(id);
        yanResponse.setMessage(messageService.getMessage("appuser.update"));
        return yanResponse;
    }

    private AppUser mapDtoToEntity(AppUserDTO appUserDTO, AppUser user) {

        if (!StringUtils.isEmpty(appUserDTO.getId())) {
            user.setId(appUserDTO.getId());
        }
        if (!StringUtils.isEmpty(appUserDTO.getUserId())) {
            user.setUserId(appUserDTO.getUserId());
        }
        if (!StringUtils.isEmpty(appUserDTO.getPassword())) {
            user.setPassword(appUserDTO.getPassword());
        }
        if (!StringUtils.isEmpty(appUserDTO.getRole())) {
            user.setRole(appUserDTO.getRole());
        }
        if (!StringUtils.isEmpty(appUserDTO.getFranchiseId())) {
            user.setFranchiseId(appUserDTO.getFranchiseId());
        }
        if (!StringUtils.isEmpty(appUserDTO.isActive())) {
            user.setActive(appUserDTO.isActive());
        }
        if (!StringUtils.isEmpty(appUserDTO.getInvalidLoginAttempts())) {
            user.setInvalidLoginAttempts(appUserDTO.getInvalidLoginAttempts());
        }

        return user;
    }

    private List<AppUserDTO> getAppUserToDtoMapping(List<AppUser> userList) {
        List<AppUserDTO> userDTOList = new ArrayList<>();
        for (AppUser user : userList) {
            AppUserDTO appUserDTO = new AppUserDTO();
            appUserDTO.setId(user.getId());
            appUserDTO.setUserId(user.getUserId());
            appUserDTO.setPassword(user.getPassword());
            appUserDTO.setRole(user.getRole());
            appUserDTO.setFranchiseId(user.getFranchiseId());
            appUserDTO.setActive(user.isActive());
            appUserDTO.setInvalidLoginAttempts(user.getInvalidLoginAttempts());
            userDTOList.add(appUserDTO);
        }
        return userDTOList;
    }
}