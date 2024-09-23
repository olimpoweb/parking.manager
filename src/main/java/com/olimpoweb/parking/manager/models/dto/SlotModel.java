package com.olimpoweb.parking.manager.models.dto;

import com.olimpoweb.parking.manager.models.commons.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SlotModel extends BaseModel {

    private String licensePlate;

}
