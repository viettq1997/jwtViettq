package com.iist.vse900.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Token")
public class Token implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private int tokenId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "expried_date")
    private Date expriedDate;
    @Column(name = "token")
    private String token;
    @Column(name = "created_date")
    private Date createdDate;

    public Token() {
    }

    public Token(int userId, Date expriedDate, String token, Date createdDate) {
        this.userId = userId;
        this.expriedDate = expriedDate;
        this.token = token;
        this.createdDate = createdDate;
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

    public Date getExpriedDate() {
        return expriedDate;
    }

    public void setExpriedDate(Date expriedDate) {
        this.expriedDate = expriedDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
