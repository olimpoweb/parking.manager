package com.olimpoweb.parking.manager.entities;

import com.olimpoweb.parking.manager.entities.commons.BaseEntityAudit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "slots", uniqueConstraints= {
    @UniqueConstraint(name = "uniquelicensePlate", columnNames={"licensePlate"})
})
public class Slot extends BaseEntityAudit{

    @Column(length = 10)
    private String licensePlate;

}
