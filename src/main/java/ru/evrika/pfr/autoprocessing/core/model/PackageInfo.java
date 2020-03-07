package ru.evrika.pfr.autoprocessing.core.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by Timid on 12.12.2015.
 */
@Data
public class PackageInfo {

    private String sender;

    private String recipient;

    private LocalDateTime date;

    private String type;

    private boolean positive;

    private String file;
}
