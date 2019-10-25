package com.iist.vse900.domain.dto;

import com.iist.vse900.domain.model.Token;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class TokenDTO {
    private int tokenId;
    private int userId;
    private String expriedDate;
    private String token;
    private String createdDate;


    public TokenDTO() {
    }

    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getExpriedDate() {
        return expriedDate;
    }

    public void setExpriedDate(String expriedDate) {
        this.expriedDate = expriedDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCreateDate() {
        return createdDate;
    }

    public void setCreateDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public TokenDTO(Token token){
        ModelMapper modelMapper = new ModelMapper();
        TokenDTO tokenDTO = modelMapper.map(token,TokenDTO.class);
    }
}
