package com.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import javax.annotation.PostConstruct;

@ConfigurationProperties(prefix = "demo")
public class DemoConfig {

    private SwaggerConfig        swaggerConfig;

   @PostConstruct
    public void init() {
    }

    public SwaggerConfig getSwaggerConfig() {
        return swaggerConfig;
    }

    public void setSwaggerConfig(SwaggerConfig swaggerConfig) {
        this.swaggerConfig = swaggerConfig;
    }

    /**
     * Swagger COnfig
     */
    public static class SwaggerConfig {

        //no need to define @value , it will also pick it up based on qualified name.
        @Value("${demo.swaggerConfig.enable}")
        private boolean enable;
        @Value("${demo.swaggerConfig.basePath}")
        private String  basePath;

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public String getBasePath() {
            return basePath;
        }

        public void setBasePath(String basePath) {
            this.basePath = basePath;
        }

        @Override
        public String toString() {
            return "SwaggerConfig{" +
                    "enable=" + enable +
                    ", basePath='" + basePath + '\'' +
                    '}';
        }
    }


}
