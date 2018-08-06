package org.hejin.springboot.jwt.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthProviderService implements AuthenticationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthProviderService.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UsernamePasswordAuthenticationTokenFactory usernamePasswordAuthenticationTokenFactory;

    public Authentication authenticate(Authentication authentication) {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        LOGGER.info("doing login:" + login);
        User user = userService.isLoginValid(login, password);
        if (user != null) {
            return usernamePasswordAuthenticationTokenFactory.create(user);
        }
        throw new UsernameNotFoundException("not valid login/password");
    }

    @Override
    public boolean supports(Class<?> classz) {
        return classz.equals(UsernamePasswordAuthenticationToken.class);
    }
}
