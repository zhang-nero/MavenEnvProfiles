package com.nero.maven.env.profiles.service;

import com.nero.maven.env.profiles.entities.enumeration.Enumeration;

import java.util.List;

/**
 * @author Nero
 * @since 2018-07-12 17:40
 */
public interface EnumerationService {
    List<Enumeration> getAll();
}
