package ru.evrika.pfr.autoprocessing.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sergei Balashov on 07.03.2020.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "file")
public class FileProperty {

    private String maskPattern;
}