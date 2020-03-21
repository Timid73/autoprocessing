package ru.evrika.pfr.autoprocessing.core.model;

import lombok.Data;

import java.util.List;

/**
 * Created by Timid on 21.12.2015.
 */
@Data
public class TransactionInfo {

    private String uid;

    private String type;

    private String mailBox;

    private List<PackageInfo> packageInfoList;
}
