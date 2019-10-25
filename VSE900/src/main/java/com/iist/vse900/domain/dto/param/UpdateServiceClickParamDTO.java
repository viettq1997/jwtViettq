package com.iist.vse900.domain.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "")
public class UpdateServiceClickParamDTO {

    @ApiModelProperty(notes = "userId của người dùng hiện tại")
    private Long userId;
    @ApiModelProperty(notes = "serviceId của Service mà người dùng click")
    private Long serviceId;

    public Long getServiceId() {
        return serviceId;
    }

    public Long getUserId() {
        return userId;
    }
}
