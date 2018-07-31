package com.realestate.properties.controller;

import com.realestate.properties.domain.User;
import com.realestate.properties.dto.OKResponse;
import com.realestate.properties.dto.RegisterUser;
import com.realestate.properties.helper.DTOConverter;
import com.realestate.properties.service.RoleService;
import com.realestate.properties.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseRestController {

    @Autowired UserService userService;

    @Autowired RoleService roleService;

    @Autowired DTOConverter dtoConverter;

    /**
     * Endpoint to register a new user
     * @param registerUser new user form bean
     * @return OKResponse object
     */
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUser registerUser) {
        User user = dtoConverter.convertRegister2User(registerUser);
        userService.checkNewUser(user);
        user = userService.insert(user);
        final Long userID = user.getId();
        if (user.getId() != null && !CollectionUtils.isEmpty(registerUser.getRoles())) {
            registerUser.getRoles().forEach(role -> roleService.insert2User(userID, role));
            user.setRoles(roleService.getUserRoles(user.getId()));
        }

        return ResponseEntity.ok(new OKResponse("No error"));
    }
}
