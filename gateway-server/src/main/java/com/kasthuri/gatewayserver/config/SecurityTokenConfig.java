package com.kasthuri.gatewayserver.config;

import com.kasthuri.gatewayserver.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity    // Enable security config. This annotation denotes config for spring security.
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtConfig jwtConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                // handle an authorized attempts
                .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(SC_UNAUTHORIZED))
                .and()
                // Add a filter to validate the tokens with every request
                .addFilterAfter(new JwtAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
                // authorization requests config
                .authorizeRequests()
                // allow all who are accessing "auth" service
                .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
                .antMatchers("/account/api/v1/stylists/search/**").permitAll()
                // must be an admin if trying to access admin area (authentication is also required here)
                .antMatchers("/gallery" + "/admin/**").hasRole("ADMIN")
                // Any other request must be authenticated
                .anyRequest().authenticated();
    }

    @Bean
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }
}
