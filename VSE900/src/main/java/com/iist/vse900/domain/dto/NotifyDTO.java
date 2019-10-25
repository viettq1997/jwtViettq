package com.iist.vse900.domain.dto;

import com.iist.vse900.domain.model.Notify;
import org.modelmapper.ModelMapper;

import java.util.Date;

public class NotifyDTO {
    private int notifyId;
    private String notifyCode;
    private int type;
    private String icon;
    private String title;
    private String content;
    private String status;
    private String startDate;
    private String endDate;
    private String isActive;
    private String createDate;
    private int createBy;
    private String modifiedDate;
    private int modifiedBy;

    public NotifyDTO(Notify notify){
        ModelMapper modelMapper = new ModelMapper();
        NotifyDTO notifyDTO = modelMapper.map(notify,NotifyDTO.class);
    }
}
