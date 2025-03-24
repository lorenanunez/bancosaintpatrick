package com.idforideas.bancosaintpatrick.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@NoArgsConstructor
public class SwaggerUIConfiguration {

    @Bean
    OpenAPI openAPI() {
        Contact contact = new Contact();
        contact.setName("Lorena Nuñez");
        contact.email("lorenunez@vera.com.uy");
        contact.setUrl("https://github.com/lorenanunez");

        Info info = new Info();
        info.contact(contact);
        info.setTitle("Banco Saint Patrick API");
        info.setDescription("API for Banco Saint Patrick");
        info.setVersion("1.1");



        return new OpenAPI().info(info);
        // tryItOutEnabled = false
    }

}
