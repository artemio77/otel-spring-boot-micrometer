package com.example.otelspringbootmicrometer;

import io.micrometer.core.instrument.Metrics;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class OtelSpringBootMicrometerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OtelSpringBootMicrometerApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        Metrics.globalRegistry.getRegistries().forEach(System.out::println);
    }
}
