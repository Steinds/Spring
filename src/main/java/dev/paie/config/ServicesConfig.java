package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import dev.paie.spring.JpaConfig;

@Configuration
@ComponentScan("dev.paie.service, dev.paie.config")
@Import({JpaConfig.class,DataSourceMySQLConfig.class})
public class ServicesConfig {
}