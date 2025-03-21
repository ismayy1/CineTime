package com.project.entity.enums;

import java.util.Arrays;

public enum RoleType {
    ROLE_ADMIN,
    ROLE_STAFF,
    ROLE_USER;

    public static RoleType fromString(String role){
        return Arrays.stream(values())
                .filter(r ->r.name().equalsIgnoreCase(role))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("Invalid role type: " + role));
    }

}
