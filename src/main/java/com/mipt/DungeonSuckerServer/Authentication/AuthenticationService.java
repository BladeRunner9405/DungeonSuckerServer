package com.mipt.DungeonSuckerServer.Authentication;

import com.mipt.DungeonSuckerServer.ApiKeyAuthentication;
import com.mipt.DungeonSuckerServer.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationService {

    private static final String AUTH_TOKEN_HEADER_NAME = "API-KEY";
    private static final String AUTH_LOGIN_HEADER_NAME = "LOGIN";
    private static final String AUTH_PASSWORD_HEADER_NAME = "PASSWORD";
    private static final String AUTH_TOKEN = "super-secret-key";

    public static Authentication getAuthentication(HttpServletRequest request) {
        if (isApiRequest(request)) {
            String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
            if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
                throw new BadCredentialsException("Invalid API Key");
            }
            return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
        }
        if (isOfficeRequest(request)) {
//            String login = request.getHeader(AUTH_LOGIN_HEADER_NAME);
//            String password = request.getHeader(AUTH_PASSWORD_HEADER_NAME);
//            if (login == null || password == null || !password.equals(UserService.compareUserPassword(login))) {
//                throw new BadCredentialsException("Invalid login or password");
//            }
//            return new LoginPasswordAuthentication(login, password, AuthorityUtils.NO_AUTHORITIES);
            throw new BadCredentialsException("This service is under development...");
        }

        return new ApiKeyAuthentication(null, AuthorityUtils.NO_AUTHORITIES);
    }

    public static boolean isApiRequest(HttpServletRequest request) {
        return request.getServletPath().startsWith("/api");
    }

    public static boolean isOfficeRequest(HttpServletRequest request) {
        return request.getServletPath().startsWith("/office");
    }
}