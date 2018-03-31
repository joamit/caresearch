package io.joamit.caresearch.car.service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String CONTROLLER_BASE_PACKAGE = "io.joamit.caresearch.car.service.controller";

    /**
     * Enables swagger only for the controllers created in defined package
     *
     * @return Docket instance for swagger initialization
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(or(RequestHandlerSelectors.withClassAnnotation(RestController.class),
                        basePackage(CONTROLLER_BASE_PACKAGE)))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Add custom api information to be displayed on Swagger page
     *
     * @return ApiInformation for the swagger page
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Car Service REST API",
                "This API can be used to perform Car Domain related CRUD operations",
                "0.0.1-SNAPSHOT",
                "ToBeDefined",
                new Contact("Amit Joshi", "https://github.com/joamit/caresearch", "joamit13@gmail.com"),
                "MIT Open source", "API license URL", Collections.emptyList());
    }
}
