package ru.evrika.pfr.autoprocessing.storage.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Timid on 08.01.2016.
 */
@Entity
@Data
@Table(name = "settings")
public class PropertyEntity extends BaseEntity {

    private String key;

    private String value;
}
