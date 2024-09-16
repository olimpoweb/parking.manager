package com.olimpoweb.parking.manager.entities;

import java.util.UUID;

import com.olimpoweb.parking.manager.entities.commons.BaseEntityAudit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "slots")
public class Slot extends BaseEntityAudit{

    @Column(nullable = false, length = 36)
    private UUID parkId;

    @Column(length = 10)
    private String licensePlate;

    @NotNull
    @Column(length = 10)
    private String place;

}
