package org.hejin.springboot.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;
    @Autowired
    private AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler;
    @Autowired
    private AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler;
    @Autowired
    private Http401UnauthorizedEntryPoint authenticationEntryPoint;
    @Autowired
    private AuthProviderService authProvider;
    @Autowired
    private SecurityProperties security;
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider);
    }

    protected void configure(HttpSecurity http) throws Exception {
        String[] permited = new String[security.getIgnored().size];
        security.getIgnored().toArray(permited);

        http
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                    .antMatchers("/api/authenticate").permitAll()
                    .antMatchers("/api/user").permitAll()
                    .antMatchers("/").permitAll()
                    .antMatchers("/favicon.ico").permitAll()
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginProcessingUrl("/api/authentication")
                    .successHandler(ajaxAuthenticationSuccessHandler)
                    .failureForwardUrl(ajaxAuthenticationFailureHandler)
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and()
                .logout()
                    .logoutUrl("/api/logout")
                        .logoutSuccessHandler(ajaxLogoutSuccessHandler)
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID");
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();
    }

    @Bean
    public ShaPasswordEncoder sha() {
        ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder(256);
        return shaPasswordEncoder;
    }
}
