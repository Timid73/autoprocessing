package ru.evrika.pfr.autoprocessing.storage.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Timid on 21.12.2015.
 */
@Entity
@Data
@Table(name = "transaction")
@EqualsAndHashCode(callSuper = true)
public class TransactionEntity extends BaseEntity {

    private String uid;

    private String type;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PackageEntity> packageEntityList;
}
