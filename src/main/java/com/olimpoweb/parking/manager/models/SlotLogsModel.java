package com.olimpoweb.parking.manager.models;

import java.util.Date;
import java.util.UUID;

import com.olimpoweb.parking.manager.models.commons.BaseModel;
import com.olimpoweb.parking.manager.models.enums.SlotLogEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SlotLogsModel extends BaseModel {

    private UUID slotId;

    private String licensePlate;

    private SlotLogEnum slotLogType;

    private Date logDate;

}
