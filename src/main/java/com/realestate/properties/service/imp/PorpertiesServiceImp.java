package com.realestate.properties.service.imp;

import com.realestate.properties.dao.PropertiesDao;
import com.realestate.properties.domain.Properties;
import com.realestate.properties.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorpertiesServiceImp implements PropertiesService {

    @Autowired
    PropertiesDao propertiesDao;

    @Override
    public List<Properties> getFeaturedProperties() {
        return propertiesDao.getFeaturedProperties();
    }
}
