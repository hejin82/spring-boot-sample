package org.hejin.springboot.jwt.security.filter;

import org.hejin.springboot.jwt.security.SecurityAppContext;
import org.hejin.springboot.jwt.security.factory.UsernamePasswordAuthenticationTokenFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationTokenFilter {

    private static final String AUTHORIZATION = "Authorization";
    private static final String UTF_8 = "UTF-8";
    private static final int BEGIN_INDEX = 7;
    private final Logger logger = LoggerFactory.getLog(this.getClass());

    @Autowired
    private UserService userService;
    @Autowired
    private UsernamePasswordAuthenticationTokenFactory usernamePasswordAuthenticationTokenFactory;
    @Autowired
    private SecurityAppContext securityAppContext;

}
