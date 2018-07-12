package com.nero.maven.env.profiles.entities.enumeration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Nero
 * @since 2018-07-12 17:35
 */
@Setter
@Getter
@ToString
public class Enumeration {
    private Integer id;
    private Type type;
}
