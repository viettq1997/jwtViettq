package com.iist.vse900.domain.dto;

import com.iist.vse900.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class UserDTO {

    private int userId;
    private String password;
    private String typeEncodedPass;
    private String saltEncodedPass;
    private int totalWrongLogins;
    private int logonPauseTime;
    private int passwordValidityPeriod;
    private String historyPassword;
    private String lastTimeChangedPass;
    private String isChangeFirst;
    private String lastTimeLogin;
    private String isMultiLogin;
    private String ipAddress;
    private String isBlock;
    private String reason4locking;
    private int unlockBy;
    private String isActive;
    private String createdDate;
    private int createBy;
    private String modifiedDate;
    private int modifiedBy;

    public UserDTO(User user){
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user,UserDTO.class);
    }
}
