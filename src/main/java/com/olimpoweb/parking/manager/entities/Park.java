package com.olimpoweb.parking.manager.entities;

import com.olimpoweb.parking.manager.entities.commons.BaseEntityAudit;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "parks")
public class Park extends BaseEntityAudit {

    @NotNull
    private String name;

    @NotNull
    private String address;

}
