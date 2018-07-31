package com.realestate.properties.controller;

import com.realestate.properties.domain.Properties;
import com.realestate.properties.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/properties/")
public class PorpertiesController {

    @Autowired
    PropertiesService propertiesService;

    @RequestMapping(value = "/featured", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<Properties> getFeaturedProperties (SecurityContextHolderAwareRequestWrapper request){
        return propertiesService.getFeaturedProperties();
    }

    @GetMapping("/")
    public List<Properties> getProperties (){
        return propertiesService.getFeaturedProperties();
    }

    @GetMapping("/secured")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Properties> getPropertiesSecured (){
        return propertiesService.getFeaturedProperties();
    }

    @GetMapping("/secured/insert")
    @PreAuthorize("hasAuthority('INSERT')")
    public List<Properties> getPropertiesSecuredInsert (){
        return propertiesService.getFeaturedProperties();
    }

    @GetMapping("/secured/update")
    @PreAuthorize("hasAuthority('UPDATE')")
    public List<Properties> getPropertiesSecuredUpdate (){
        return propertiesService.getFeaturedProperties();
    }

}
