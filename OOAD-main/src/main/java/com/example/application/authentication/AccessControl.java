package com.example.application.authentication;

import java.io.Serializable;

/**
 * Simple interface for com.example.application.authentication and authorization checks.
 */
public interface AccessControl extends Serializable {

    String ADMIN_ROLE_NAME = "admin";
    String ADMIN_USERNAME = "admin";

    boolean signIn(String username, String password);

    boolean isUserSignedIn();

    boolean isUserInRole(String role);

    String getPrincipalName();

    void signOut();
}
