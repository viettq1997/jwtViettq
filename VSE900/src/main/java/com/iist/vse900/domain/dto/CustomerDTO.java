package com.iist.vse900.domain.dto;

import com.iist.vse900.domain.model.Customer;
import org.modelmapper.ModelMapper;

import java.util.Date;

public class CustomerDTO {

    private int userId;
    private String userCode;
    private String userName;
    private String email;
    private int phoneNumber;
    private String isActive;
    private Date createdDate;
    private int createBy;
    private int modifiedDate;
    private int modifiedBy;


    public CustomerDTO(Customer customer) {
        ModelMapper modelMapper = new ModelMapper();
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
    }
}
