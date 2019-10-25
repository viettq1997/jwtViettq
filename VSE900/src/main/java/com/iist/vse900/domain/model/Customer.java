package com.iist.vse900.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_code")
    private String userCode;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private BigInteger phoneNumber;
    @Column(name = "is_active")
    private String isActive;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "created_by")
    private int createBy;
    @Column(name = "modified_date")
    private Date modifiedDate;
    @Column(name = "modified_by")
    private int modifiedBy;

    public Customer() {
    }

    public Customer(String userCode, String userName, String email, BigInteger phoneNumber, String isActive, Date createdDate, int createBy, Date modifiedDate, int modifiedBy) {
        this.userCode = userCode;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.createBy = createBy;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
