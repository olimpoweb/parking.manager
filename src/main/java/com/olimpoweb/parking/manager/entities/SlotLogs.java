package com.olimpoweb.parking.manager.entities;

import java.util.Date;
import java.util.UUID;

import com.olimpoweb.parking.manager.entities.commons.BaseEntityAudit;
import com.olimpoweb.parking.manager.models.enums.SlotLogEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "slot_logs")
public class SlotLogs extends BaseEntityAudit {

    @Column(nullable = false, length = 36)
    private UUID slotId;

    @NotNull
    @Column(length = 10)
    private String licensePlate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SlotLogEnum slotLogType;

    @NotNull
    private Date logDate;

}
