package com.iist.vse900.service;

import com.iist.vse900.domain.dto.ServiceDTO;
import com.iist.vse900.domain.dto.UserServiceDTO;
import com.iist.vse900.domain.dto.param.UpdateServiceClickParamDTO;
import com.iist.vse900.domain.model.UserServices;

import java.util.List;

public interface ServicesService {
    List<ServiceDTO> getListService(Long userId);

    boolean addServiceClick(UpdateServiceClickParamDTO updateServiceClickParamDTO);
}
