package com.example.bmd.config;

import com.example.bmdb.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity(debug = true)
@Import(AppConfig.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    public UserDetailsService userDetailsService;


    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/home").authenticated()
                .antMatchers("/media").authenticated()
                .anyRequest().permitAll()
                .and()
                    .formLogin().loginPage("/login")
                    .defaultSuccessUrl("/home")
                    //.failureUrl("/media")
                    .usernameParameter("email")
                    .passwordParameter("passWord");

    }

    //@Autowired
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }
}
