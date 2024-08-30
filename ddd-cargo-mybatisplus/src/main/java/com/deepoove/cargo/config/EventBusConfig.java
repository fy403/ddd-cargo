package com.deepoove.cargo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.eventbus.EventBus;
@Configuration
public class EventBusConfig {
    @Bean
    public EventBus configEvent() {
        EventBus eventBus = new EventBus();
        return eventBus;
    }
}
