package com.olimpoweb.parking.manager.entities;

import java.util.Date;

import com.olimpoweb.parking.manager.entities.commons.BaseEntityAudit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "slots")
public class Slot extends BaseEntityAudit{

    @NotNull
    @Column(length = 10)
    private String licensePlate;

    @NotNull
    private Date logDate;

}
