package com.example.demo.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Manga")
                        .version("1.0")
                        .description("Backend quản lý truyện tranh")
                        .contact(new Contact()
                                .name("Kien")
                                .email("thieukien24@gmail.com")));
    }
}