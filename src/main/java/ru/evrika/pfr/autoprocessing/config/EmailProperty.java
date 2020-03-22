package ru.evrika.pfr.autoprocessing.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация для электронных ящиков
 * bti - электронный ящик для взяимодействия с БТИ
 * monitor - электронный ящик для взимодействия с taxcom МониторМ
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "email")
public class EmailProperty {

    private String bti;

    private String monitor;
}
