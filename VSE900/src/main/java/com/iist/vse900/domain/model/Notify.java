package com.iist.vse900.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Notify")
public class Notify implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notify_id")
    private int notifyId;
    @Column(name = "notify_code")
    private String notifyCode;
    @Column(name = "type")
    private int type;
    @Column(name = "icon")
    private String icon;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "status")
    private String status;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "is_active")
    private String isActive;
    @Column(name = "created_date")
    private Date createDate;
    @Column(name = "created_by")
    private int createBy;
    @Column(name = "modified_date")
    private Date modifiedDate;
    @Column(name = "modified_by")
    private int modifiedBy;

    public Notify() {
    }

    public Notify(String notifyCode, int type, String icon, String title, String content, String status, Date startDate, Date endDate, String isActive, Date createDate, int createBy, Date modifiedDate, int modifiedBy) {
        this.notifyCode = notifyCode;
        this.type = type;
        this.icon = icon;
        this.title = title;
        this.content = content;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.createDate = createDate;
        this.createBy = createBy;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
    }

    public int getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(int notifyId) {
        this.notifyId = notifyId;
    }

    public String getNotifyCode() {
        return notifyCode;
    }

    public void setNotifyCode(String notifyCode) {
        this.notifyCode = notifyCode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
