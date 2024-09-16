package com.olimpoweb.parking.manager.entities;

import com.olimpoweb.parking.manager.entities.commons.BaseEntityAudit;

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
@Table(name = "parks")
public class Park extends BaseEntityAudit {

    @NotNull
    private String name;

    @NotNull
    private String address;

}
