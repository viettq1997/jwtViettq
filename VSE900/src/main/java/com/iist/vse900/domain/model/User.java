package com.iist.vse900.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
//import java.util.Date;

@Entity
@Table(name = "User")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    public User() {
    }

    @Id
    @Column(name = "user_id")
    private int userId;
    @Column(name = "password")
    private String password;
    @Column(name = "type_encoded_pass")
    private String typeEncodedPass;
    @Column(name = "salt_encoded_pass")
    private String saltEncodedPass;
    @Column(name = "total_wrong_logins")
    private int totalWrongLogins;
    @Column(name = "logon_pause_time")
    private int logonPauseTime;
    @Column(name = "password_validity_period")
    private int passwordValidityPeriod;
    @Column(name = "history_password")
    private String historyPassword;
    @Column(name = "last_time_changed_pass")
    private Date lastTimeChangedPass;
    @Column(name = "is_change_first")
    private String isChangeFirst;
    @Column(name = "last_time_login")
    private Date lastTimeLogin;
    @Column(name = "is_multi_login")
    private String isMultiLogin;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "is_block")
    private String isBlock;
    @Column(name = "reason_4locking")
    private String reason4locking;
    @Column(name = "unlock_by")
    private int unlockBy;
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

    public User(int userId, String password, String typeEncodedPass, String saltEncodedPass, int totalWrongLogins, int logonPauseTime, int passwordValidityPeriod, String historyPassword, Date lastTimeChangedPass, String isChangeFirst, Date lastTimeLogin, String isMultiLogin, String ipAddress, String isBlock, String reason4locking, int unlockBy, String isActive, Date createdDate, int createBy, Date modifiedDate, int modifiedBy) {
        this.userId = userId;
        this.password = password;
        this.typeEncodedPass = typeEncodedPass;
        this.saltEncodedPass = saltEncodedPass;
        this.totalWrongLogins = totalWrongLogins;
        this.logonPauseTime = logonPauseTime;
        this.passwordValidityPeriod = passwordValidityPeriod;
        this.historyPassword = historyPassword;
        this.lastTimeChangedPass = lastTimeChangedPass;
        this.isChangeFirst = isChangeFirst;
        this.lastTimeLogin = lastTimeLogin;
        this.isMultiLogin = isMultiLogin;
        this.ipAddress = ipAddress;
        this.isBlock = isBlock;
        this.reason4locking = reason4locking;
        this.unlockBy = unlockBy;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeEncodedPass() {
        return typeEncodedPass;
    }

    public void setTypeEncodedPass(String typeEncodedPass) {
        this.typeEncodedPass = typeEncodedPass;
    }

    public String getSaltEncodedPass() {
        return saltEncodedPass;
    }

    public void setSaltEncodedPass(String saltEncodedPass) {
        this.saltEncodedPass = saltEncodedPass;
    }

    public int getTotalWrongLogins() {
        return totalWrongLogins;
    }

    public void setTotalWrongLogins(int totalWrongLogins) {
        this.totalWrongLogins = totalWrongLogins;
    }

    public int getLogonPauseTime() {
        return logonPauseTime;
    }

    public void setLogonPauseTime(int logonPauseTime) {
        this.logonPauseTime = logonPauseTime;
    }

    public int getPasswordValidityPeriod() {
        return passwordValidityPeriod;
    }

    public void setPasswordValidityPeriod(int passwordValidityPeriod) {
        this.passwordValidityPeriod = passwordValidityPeriod;
    }

    public String getHistoryPassword() {
        return historyPassword;
    }

    public void setHistoryPassword(String historyPassword) {
        this.historyPassword = historyPassword;
    }

    public Date getLastTimeChangedPass() {
        return lastTimeChangedPass;
    }

    public void setLastTimeChangedPass(Date lastTimeChangedPass) {
        this.lastTimeChangedPass = lastTimeChangedPass;
    }

    public String getIsChangeFirst() {
        return isChangeFirst;
    }

    public void setIsChangeFirst(String isChangeFirst) {
        this.isChangeFirst = isChangeFirst;
    }

    public Date getLastTimeLogin() {
        return lastTimeLogin;
    }

    public void setLastTimeLogin(Date lastTimeLogin) {
        this.lastTimeLogin = lastTimeLogin;
    }

    public String getIsMultiLogin() {
        return isMultiLogin;
    }

    public void setIsMultiLogin(String isMultiLogin) {
        this.isMultiLogin = isMultiLogin;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIsBlock() {
        return isBlock;
    }

    public void setIsBlock(String isBlock) {
        this.isBlock = isBlock;
    }

    public String getReason4locking() {
        return reason4locking;
    }

    public void setReason4locking(String reason4locking) {
        this.reason4locking = reason4locking;
    }

    public int getUnlockBy() {
        return unlockBy;
    }

    public void setUnlockBy(int unlockBy) {
        this.unlockBy = unlockBy;
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
