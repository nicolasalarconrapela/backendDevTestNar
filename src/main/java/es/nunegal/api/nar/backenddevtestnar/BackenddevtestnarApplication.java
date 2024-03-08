package es.nunegal.api.nar.backenddevtestnar;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackenddevtestnarApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackenddevtestnarApplication.class, args);
    }

    /**
     * Customización de Swagger API
     *
     * @return OpenApiInfo
     */
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(
                new Info()
                        .title("API backenddevtestnar")
                        .version("0.0.1")
                        .summary("API REST Nunegal NAR")
                        .description("En esta API podremos realizar la gestión de productos")

        );
    }

}
