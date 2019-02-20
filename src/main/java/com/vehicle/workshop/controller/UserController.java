package com.vehicle.workshop.controller;

import com.vehicle.workshop.dto.AppUserDTO;
import com.vehicle.workshop.serviceI.UserServiceI;
import com.vehicle.workshop.utils.YanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api")
public class UserController {

    @Autowired
    UserServiceI userServiceI;

    @GetMapping("/users")
    public YanResponse getAllUsers() {
        return userServiceI.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public YanResponse getUserById(@PathVariable Long userId) {
        return userServiceI.getUserById(userId);
    }

    @PostMapping("/users")
    public YanResponse saveUser(@RequestBody AppUserDTO appUserDTO) {
        return userServiceI.saveUser(appUserDTO);
    }

    @PutMapping("/users/{userId}")
    public YanResponse updateUser(@RequestBody AppUserDTO appUserDTO) {
        return userServiceI.updateUser(appUserDTO);
    }

    @DeleteMapping("/users/{userId}")
    public YanResponse deleteUser(@PathVariable Long userId) {
        return userServiceI.deleteUser(userId);
    }
}
