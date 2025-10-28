package com.example.demo_6.user;

public enum UserPermission {
    GET_TODO("GET_TODO"),
    POST_TODO("POST_TODO"),
    PUT_TODO("PUT_TODO"),
    DELETE_TODO("DELETE_TODO"),
    MANAGE_USERS("MANAGER_USERS");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
