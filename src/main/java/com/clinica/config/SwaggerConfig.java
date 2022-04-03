package com.clinica.config;

import com.clinica.core.constants.ApplicationInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;
import static  springfox.documentation.builders.RequestHandlerSelectors.basePackage;


@Configuration
//@EnableSwagger2 : Deprecado con swagger 3.0
public class SwaggerConfig {

   // http://localhost:8090/clinica-backend/swagger-ui/index.html : 3.0
   // http://localhost:8090/clinica-backend/swagger-ui.html : 2..
    @Bean
    public Docket api(){
        return new Docket(SWAGGER_2).select()
                .apis(basePackage("com.clinica"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title(ApplicationInfo.TITLE.getInfo()).description(ApplicationInfo.DESCRIPTION.getInfo())
                .version(ApplicationInfo.VERSION.getInfo()).termsOfServiceUrl(ApplicationInfo.TERMS_URL.getInfo())
                .contact(new Contact(ApplicationInfo.CONTACT_NAME.getInfo(), ApplicationInfo.CONTACT_URL.getInfo(),
                        ApplicationInfo.CONTACT_EMAIL.getInfo()))
                .license(ApplicationInfo.LICENSE.getInfo()).licenseUrl(ApplicationInfo.LICENCE_URL.getInfo())
                .build();

//        return new ApiInfo(ApplicationInfo.TITLE.getInfo(), )
    }

}
