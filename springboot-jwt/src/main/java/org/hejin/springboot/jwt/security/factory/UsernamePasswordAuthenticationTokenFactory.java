package org.hejin.springboot.jwt.security.factory;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UsernamePasswordAuthenticationTokenFactory {

    public UsernamePasswordAuthenticationToken create(User user) {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), Arrays.asList(simpleGrantedAuthority));
        return authenticationToken;
    }
}
