package ru.evrika.pfr.autoprocessing.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация для дирикторий приложений
 * incoming - директория для входящих файлов для обработки
 * vipnet - директория для исходящих файлов для vipnet БТИ
 * dipost - директория для писем в Дипост
 * archive - директория для хранения архивов
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "path")
public class PathProperty {

    private String incoming;

    private String vipnet;

    private String dipost;

    private String archive;
}
