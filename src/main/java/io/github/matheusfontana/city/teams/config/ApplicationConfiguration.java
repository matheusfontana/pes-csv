package io.github.matheusfontana.city.teams.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public ObjectMapper jsonMapper() {
        return new ObjectMapper();
    }
}
