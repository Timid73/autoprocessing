package ru.evrika.pfr.autoprocessing.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация для файлов
 * maskPattern - маска обрабатываемых файлов
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "file")
public class FileProperty {

    private String maskPattern;
}
