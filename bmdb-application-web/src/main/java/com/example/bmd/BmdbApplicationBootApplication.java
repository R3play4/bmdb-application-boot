package com.example.bmd;

import com.example.bmdb.config.AppConfig;
import com.example.bmdb.config.RepositoryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import({AppConfig.class, RepositoryConfig.class})
@EnableJpaRepositories
public class BmdbApplicationBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmdbApplicationBootApplication.class, args);
    }

}
