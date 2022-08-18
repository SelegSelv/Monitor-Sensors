package com.monitorsensors.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    Administrator,
    Viewer;

    @Override
    public String getAuthority() {
        return name();
    }
}