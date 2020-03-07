package ru.evrika.pfr.autoprocessing.storage.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by Timid on 12.12.2015.
 */
@Entity
@Data
@Table(name = "archive")
public class ArchiveEntity extends BaseEntity {

    private String fileName;

    private Timestamp date;
}
