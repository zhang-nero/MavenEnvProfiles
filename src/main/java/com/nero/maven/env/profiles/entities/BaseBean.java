package com.nero.maven.env.profiles.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Nero
 * @since 2018-06-26 11:52
 */
@Setter
@Getter
public class BaseBean {
    private Integer id;
    private String createdBy;
    private String updatedBy;
    private Date createTime;
    private Date updateTime;
    private int version;
}
