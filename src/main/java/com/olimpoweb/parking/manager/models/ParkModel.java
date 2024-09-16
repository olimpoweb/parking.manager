package com.olimpoweb.parking.manager.models;

import com.olimpoweb.parking.manager.models.commons.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ParkModel extends BaseModel{

    private String name;

    private String address;

}
