package ru.evrika.pfr.autoprocessing.core.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by Timid on 12.12.2015.
 */
@Data
public class Archive {

    private String fileName;

    private Timestamp date;
}
