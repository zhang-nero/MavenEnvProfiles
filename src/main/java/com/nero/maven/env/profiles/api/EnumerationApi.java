package com.nero.maven.env.profiles.api;

import com.nero.maven.env.profiles.entities.enumeration.Enumeration;
import com.nero.maven.env.profiles.entities.enumeration.Type;
import com.nero.maven.env.profiles.service.EnumerationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Nero
 * @since 2018-07-12 17:28
 */
@RestController
@RequestMapping(value = "/enumerationApi")
public class EnumerationApi {

    @Autowired
    private EnumerationService enumerationService;

    @ApiOperation(value = "测试枚举类型", httpMethod = "GET", notes = "测试枚举类型")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Enumeration> getEnumeration() {
        List<Enumeration> list = enumerationService.getAll();
        for (Enumeration enumeration: list){
            if (Type.type3.equals(enumeration.getType())){
                System.out.println(enumeration.toString());
            }
        }
        return list;
    }

    @ApiOperation(value = "测试枚举类型", httpMethod = "POST", notes = "测试枚举类型")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addEnumeration(@RequestBody Enumeration enumeration) {
        enumerationService.add(enumeration);
        return ;
    }
}
