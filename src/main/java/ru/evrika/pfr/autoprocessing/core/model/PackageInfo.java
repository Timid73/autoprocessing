package ru.evrika.pfr.autoprocessing.core.model;

import lombok.Data;
import ru.evrika.pfr.autoprocessing.core.enums.TransactionType;

import java.time.LocalDateTime;

/**
 * Информация пакета
 */
@Data
public class PackageInfo {

    /**
     * Уникальный идентификатор
     */
    private String uid;

    /**
     * Регистрационный номер отправителя
     */
    private String regNumFrom;

    /**
     * Регистрационный номер получателя
     */
    private String regNumTo;

    /**
     * Дата пакета
     */
    private LocalDateTime date;

    /**
     * Тип транзакции
     */
    private TransactionType type;

    /**
     * Флаг позитивного результата
     */
    private boolean positive;

    /**
     * имя файла
     */
    private String fileName;
}
