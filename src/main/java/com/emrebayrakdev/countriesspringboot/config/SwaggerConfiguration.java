package com.emrebayrakdev.countriesspringboot.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080/api");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Emre Bayrak");
        myContact.setEmail("eemmrree0@outlook.com");

        Info information = new Info()
                .title("Swagger With Spring Boot")
                .version("1.0.0")
                .description("Spring Boot Learning..")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
