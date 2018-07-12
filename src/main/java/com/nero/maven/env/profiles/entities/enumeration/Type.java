package com.nero.maven.env.profiles.entities.enumeration;

/**
 * @author Nero
 * @since 2018-07-12 17:36
 */
public enum Type {

    type1("type1"),
    type2("type2"),
    type3("type3"),
    type4("type4");

    private String type;

    public boolean equals(Type type){
        return this.type.equals(type.toString());
    }

    Type(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
