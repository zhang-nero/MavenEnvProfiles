package com.nero.maven.env.profiles.utils;

import org.springframework.context.ApplicationContext;

/**
 * @author Nero
 * @since 2018-06-26 14:53
 */
public class ContextHelper {

    private static ApplicationContext ac;

    public static void setAc(ApplicationContext ac) {
        ContextHelper.ac = ac;
    }

    public static Object getBeanByName(String beanName) {
        return ac.getBean(beanName);
    }

    public static <T> T getBeanByType(Class<T> clazz) {
        return ac.getBean(clazz);
    }

    public static String getPropertyValue(String key) {
        return ac.getEnvironment().getProperty(key);
    }
}
