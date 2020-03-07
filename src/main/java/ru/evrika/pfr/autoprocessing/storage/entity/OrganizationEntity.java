package ru.evrika.pfr.autoprocessing.storage.entity;

import lombok.Data;
import ru.evrika.pfr.autoprocessing.core.enums.OrganizationType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.security.cert.Certificate;
import java.time.LocalDateTime;

/**
 * Created by Timid on 12.12.2015.
 */
@Entity
@Data
@Table(name = "organization")
public class OrganizationEntity extends BaseEntity {

    private String name;

    private String inn;

    private String pfrRegNum;

    private Certificate certificate;

    private LocalDateTime certRegDate;

    private String email;

    private OrganizationType type;
}
