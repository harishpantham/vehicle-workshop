package com.vehicle.workshop.serviceI;

import com.vehicle.workshop.dto.AppUserDTO;
import com.vehicle.workshop.utils.YanResponse;

public interface UserServiceI {

    YanResponse getAllUsers();

    YanResponse getUserById(Long id);

    YanResponse saveUser(AppUserDTO appUserDTO);

    YanResponse updateUser(AppUserDTO appUserDTO);

    YanResponse deleteUser(Long id);

}
