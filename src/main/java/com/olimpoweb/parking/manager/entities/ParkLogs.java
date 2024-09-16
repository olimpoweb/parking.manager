package com.olimpoweb.parking.manager.entities;

import java.util.Date;

import org.hibernate.validator.constraints.UUID;

import com.olimpoweb.parking.manager.entities.commons.BaseEntityAudit;
import com.olimpoweb.parking.manager.models.enums.SlotLogEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "park_logs")
public class ParkLogs extends BaseEntityAudit {

    @Column(nullable = false, length = 36)
    private UUID parkId;

    @NotNull
    @Column(length = 10)
    private String licensePlate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SlotLogEnum slotLogType;

    @NotNull
    private Date logDate;

}
