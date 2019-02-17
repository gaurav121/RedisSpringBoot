package com.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Autowired
    private DemoConfig config;

    // documentation for this can be found at:
    // http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
    // https://github.com/swagger-api/swagger-core/wiki/annotations
    @Bean
    public Docket api() {

        // for global level response codes
        // ArrayList<ResponseMessage> responseMessages = new
        // ArrayList<ResponseMessage>();
        // responseMessages.add(new
        // ResponseMessageBuilder().code(500).message("500 message")
        // .responseModel(new ModelRef("Error")).build());
        // responseMessages.add(new
        // ResponseMessageBuilder().code(403).message("Forbidden!").build());

        return new Docket(DocumentationType.SWAGGER_2).enable(config.getSwaggerConfig().isEnable()).useDefaultResponseMessages(false).select().apis(
                RequestHandlerSelectors.basePackage("com.demo")).paths(PathSelectors.any()).build().pathProvider(new AbstractPathProvider() {

                    private final static String ROOT = "/";

                    @Override
                    protected String applicationPath() {
                        String applicationName = config.getSwaggerConfig().getBasePath();
                        return applicationName == null ? ROOT : applicationName;
                    }

                    @Override
                    protected String getDocumentationPath() {
                        return ROOT;
                    };
                }).globalOperationParameters(null);
//                        newArrayList(new ParameterBuilder().name(HttpHeaders.AUTHORIZATION).description("Token").defaultValue("Bearer {{session-token}}").modelRef(
//                                new ModelRef("String")).parameterType("header").required(true).build()));

        // .useDefaultResponseMessages(false)
        // .globalResponseMessage(RequestMethod.GET, responseMessages);

        // an alternative:
        // .apis(RequestHandlerSelectors.basePackage("org.baeldung.web.controller"))
        // .paths(PathSelectors.ant("/foos/*"))
        // .paths(PathSelectors.any())
        // .apis(RequestHandlerSelectors.any())
    }

}
