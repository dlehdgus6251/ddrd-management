package com.ddrd.management.user;

public enum UserRoleType {
    USER("USER"),
    ADMIN("ADMIN"),
    MANAGER("MANAGER");

    private final String role;
    UserRoleType(String role) {
        this.role = role;
    }

    public String roleName() {
        return role;
    }


}
