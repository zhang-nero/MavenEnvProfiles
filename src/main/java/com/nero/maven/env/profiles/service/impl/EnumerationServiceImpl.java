package com.nero.maven.env.profiles.service.impl;

import com.nero.maven.env.profiles.entities.enumeration.Enumeration;
import com.nero.maven.env.profiles.persistence.enumeration.EnumerationMapper;
import com.nero.maven.env.profiles.service.EnumerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nero
 * @since 2018-07-12 17:41
 */
@Service
public class EnumerationServiceImpl implements EnumerationService{

    @Autowired
    private EnumerationMapper enumerationMapper;

    @Override
    public List<Enumeration> getAll() {
        return enumerationMapper.getAll();
    }

    @Override
    public int add(Enumeration enumeration) {
        return enumerationMapper.add(enumeration);
    }
}
