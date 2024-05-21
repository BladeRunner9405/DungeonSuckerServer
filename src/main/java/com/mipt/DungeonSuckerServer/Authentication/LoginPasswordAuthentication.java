package com.mipt.DungeonSuckerServer.Authentication;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class LoginPasswordAuthentication extends AbstractAuthenticationToken {
    private final String login;
    private final String password;

    public LoginPasswordAuthentication(String login, String password, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.login = login;
        this.password = password;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return login;
    }
}