package ru.evrika.pfr.autoprocessing.core.model;

import lombok.Data;
import ru.evrika.pfr.autoprocessing.core.enums.TransactionType;

import java.time.LocalDateTime;

/**
 * Created by Timid on 12.12.2015.
 */
@Data
public class PackageInfo {

    private String uid;

    private String regNumFrom;

    private String regNumTo;

    private LocalDateTime date;

    private TransactionType type;

    private boolean positive;

    private String fileName;
}
