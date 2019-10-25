package com.iist.vse900.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "User_Service")
public class UserServices {

    public UserServices() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "number_click")
    private Long numberClick;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getNumberClick() {
        return numberClick;
    }

    public void setNumberClick(Long numberClick) {
        this.numberClick = numberClick;
    }
}
