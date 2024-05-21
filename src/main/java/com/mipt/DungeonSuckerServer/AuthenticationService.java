package com.mipt.DungeonSuckerServer;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationService {

    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
    private static final String AUTH_TOKEN = "Baeldung";

    public static Authentication getAuthentication(HttpServletRequest request) {
        if (isAuthenticationNeeded(request)) {
            String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
            if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
                throw new BadCredentialsException("Invalid API Key");
            }
            return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
        }

        return new ApiKeyAuthentication(null, AuthorityUtils.NO_AUTHORITIES);
    }

    public static boolean isAuthenticationNeeded(HttpServletRequest request) {
        return request.getServletPath().startsWith("/api");
    }
}