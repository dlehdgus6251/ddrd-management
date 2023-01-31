package com.ddrd.management.user;

public enum UserRoleType {
    USER("USER"),
    MANAGER("MANAGER"),
    MASTER("MASTER"),
    ADMIN("ADMIN"),
    DEVELOPER("DEVELOPER");

    private final String role;
    UserRoleType(String role) {
        this.role = role;
    }

    public String roleName() {
        return role;
    }


}
