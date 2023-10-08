package ola.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinhaConfiguration {

    @Bean(name = "appNamw")
    public String appName(){
        return "Sitema IMD";
    }
}
