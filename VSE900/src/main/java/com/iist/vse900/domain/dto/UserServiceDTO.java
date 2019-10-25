package com.iist.vse900.domain.dto;

public class UserServiceDTO {
    private Long id;

    private Long userId;

    private Long serviceId;

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
