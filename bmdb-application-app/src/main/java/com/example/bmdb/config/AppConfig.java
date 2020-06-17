package com.example.bmdb.config;

import com.example.bmdb.app.App;
import com.example.bmdb.service.Service;
import com.example.bmdb.view.View;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Import(MessageConfig.class)
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public App app() {
        return new App(createService(), createView());
    }

    @Bean
    public View createView() {
        return new View();
    }

    @Bean
    public Service createService() {
        return new Service();
    }

}
