package com.javamultiplex.security;

/**
 * @author Rohit Agarwal on 10/10/20 11:37 pm
 * @copyright www.javamultiplex.com
 */
public enum  ApplicationUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
