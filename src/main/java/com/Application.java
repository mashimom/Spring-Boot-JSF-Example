package com;

import com.sun.faces.config.ConfigureListener;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import scope.ViewScope;

import javax.faces.webapp.FacesServlet;
import java.util.HashMap;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        //noinspection unused
        ConfigurableApplicationContext context = SpringApplication
                .run(Application.class, args);
    }

    @SuppressWarnings("WeakerAccess")
    @Bean
    public static ViewScope viewScope() {
        return new ViewScope();
    }

    @Bean
    public static CustomScopeConfigurer scopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("view", viewScope());
        configurer.setScopes(hashMap);
        return configurer;
    }

    @SuppressWarnings("unused")
    @Bean
    public ServletContextInitializer initializer() {
        return servletContext -> servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
    }

    @SuppressWarnings("WeakerAccess")
    @Bean
    public FacesServlet facesServlet() {
        return new FacesServlet();
    }

    @SuppressWarnings("unused")
    @Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean<FacesServlet> registration =
                new ServletRegistrationBean<>(facesServlet(), "*.xhtml");
        registration.setName("FacesServlet");
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(
                new ConfigureListener());
    }

}
