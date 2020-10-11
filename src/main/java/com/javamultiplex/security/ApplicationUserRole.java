package com.javamultiplex.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.javamultiplex.security.ApplicationUserPermission.*;

/**
 * @author Rohit Agarwal on 10/10/20 11:36 pm
 * @copyright www.javamultiplex.com
 */
public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(STUDENT_READ, COURSE_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
