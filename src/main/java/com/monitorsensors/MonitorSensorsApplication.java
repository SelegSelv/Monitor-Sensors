package com.monitorsensors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@SpringBootApplication

public class MonitorSensorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorSensorsApplication.class, args);
    }

    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver r = new InternalResourceViewResolver();
        r.setViewClass(JstlView.class);
        r.setPrefix("/WEB-INF/jsp/");
        r.setSuffix(".jsp");
        r.setContentType("text/html");
        return r;
    }


}
