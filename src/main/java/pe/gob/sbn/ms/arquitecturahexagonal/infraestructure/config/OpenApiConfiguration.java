package pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI productOpenAPI() {

        return new OpenAPI()

                .info(
                        new Info()
                                .title("Product Management APIss2")
                                .description(
                                        "Enterprise Product Management System"
                                )
                                .version("v1.0.0")
                                .contact(
                                        new Contact()
                                                .name("Backend Team")
                                                .email("backend@company.com")
                                )
                                .license(
                                        new License()
                                                .name("Apache 2.0")
                                )
                )

                .externalDocs(
                        new ExternalDocumentation()
                                .description("Project Documentation")
                                .url("https://company.com/docs")
                );
    }

}
