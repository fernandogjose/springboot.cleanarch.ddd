package com.cleanarch.ddd.application;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("CleanArch Java Spring Boot")
                        .version("v1")
                        .description("Aplicação Clean Architecture em Java Spring Boot")
                        .termsOfService("Minha URL com a licença")
                        .license(new License().name("Apache 2.0")));
    }
}
