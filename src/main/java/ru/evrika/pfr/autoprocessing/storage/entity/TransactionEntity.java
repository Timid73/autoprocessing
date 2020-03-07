package ru.evrika.pfr.autoprocessing.storage.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Timid on 21.12.2015.
 */
@Entity
@Data
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity {

    private String uid;

    private String type;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pension_id", nullable = true)
    private PackageEntity pension;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "resign_id", nullable = true)
    private PackageEntity reSign;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "protocol_id", nullable = true)
    private PackageEntity protocol;
}
