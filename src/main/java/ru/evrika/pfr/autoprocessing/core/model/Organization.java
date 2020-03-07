package ru.evrika.pfr.autoprocessing.core.model;

import lombok.Data;
import ru.evrika.pfr.autoprocessing.core.enums.OrganizationType;

import java.security.cert.Certificate;
import java.time.LocalDateTime;

/**
 * Created by Timid on 12.12.2015.
 */
@Data
public class Organization {

    private String name;

    private String inn;

    private String pfrRegNum;

    private Certificate certificate;

    private LocalDateTime certRegDate;

    private String email;

    private OrganizationType type;
}
