package com.nero.maven.env.profiles.persistence.enumeration;

import com.nero.maven.env.profiles.entities.enumeration.Enumeration;

import java.util.List;

/**
 * @author Nero
 * @since 2018-07-12 17:43
 */
public interface EnumerationMapper {
    List<Enumeration> getAll();
}
