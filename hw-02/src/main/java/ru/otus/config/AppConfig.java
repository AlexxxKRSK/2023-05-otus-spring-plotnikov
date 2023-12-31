package ru.otus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.service.IOService;
import ru.otus.service.IOServiceStreams;

@PropertySource("classpath:application.properties")
@Configuration
public class AppConfig {
    @Bean
    public IOService ioService() {
        return new IOServiceStreams(System.out, System.in);
    }
}