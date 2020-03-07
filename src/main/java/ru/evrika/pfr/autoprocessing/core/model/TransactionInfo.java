package ru.evrika.pfr.autoprocessing.core.model;

import lombok.Data;

/**
 * Created by Timid on 21.12.2015.
 */
@Data
public class TransactionInfo {

    private String uid;

    private String type;

    private PackageInfo pension;

    private PackageInfo reSign;

    private PackageInfo protocol;
}
