package ru.evrika.pfr.autoprocessing.storage.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by Timid on 12.12.2015.
 */
@Entity
@Data
@Table(name = "package")
@EqualsAndHashCode(callSuper = true)
public class PackageEntity extends BaseEntity {

    private String sender;

    private String recipient;

    private Timestamp date;

    private String type;

    private transient boolean positive;

    private String file;
}
