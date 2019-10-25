package com.iist.vse900.service.impl;

import com.iist.vse900.domain.dto.ServiceDTO;
import com.iist.vse900.domain.dto.param.UpdateServiceClickParamDTO;
import com.iist.vse900.domain.model.Services;
import com.iist.vse900.domain.model.UserServices;
import com.iist.vse900.repository.ServicesRepository;
import com.iist.vse900.repository.UserServicesRepository;
import com.iist.vse900.repository.jpa.ServicesJpaRepository;
import com.iist.vse900.repository.jpa.UserServiceJpaRepository;
import com.iist.vse900.service.ServicesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
@Transactional
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    ServicesRepository servicesRepository;

    @Autowired
    UserServicesRepository userServiceRepository;

    @Override
    public List<ServiceDTO> getListService(Long userId) {
        List<UserServices> listUserServices = userServiceRepository.findByUserId(userId);
        List<Services> listService = servicesRepository.getAll();

        List<ServiceDTO> listServiceDto = new ArrayList<>();

        // Check data in table User_Service has serviceId
        boolean checkExistsServiceId;

        // Get List Service
        for (Services services : listService) {
            checkExistsServiceId = false;
            for(UserServices userServices : listUserServices) {
                if (services.getServiceId() == userServices.getServiceId()) {
                    addToList(listServiceDto, services, userServices.getNumberClick());
                    checkExistsServiceId = true;
                    break;
                }
            }

            if (!checkExistsServiceId) {
                addToList(listServiceDto, services, 0L);
            }
        }

        // Sort DESC
        Collections.sort(listServiceDto, new Comparator<ServiceDTO>() {
            @Override
            public int compare(ServiceDTO o1, ServiceDTO o2) {
                if (o1.getNumberClick() < o2.getNumberClick()) {
                    return 1;
                }
                if (o1.getNumberClick() > o2.getNumberClick()) {
                    return -1;
                }
                return 0;
            }
        });
        return listServiceDto;
    }

    @Override
    public boolean addServiceClick(UpdateServiceClickParamDTO updateServiceClickParamDTO) {
        UserServices userServices = new UserServices();
        userServices.setServiceId(updateServiceClickParamDTO.getServiceId());
        userServices.setUserId(updateServiceClickParamDTO.getUserId());

        UserServices resultUserService = userServiceRepository.findFirstByUserIdAndServiceId(userServices.getUserId(), userServices.getServiceId());
        if (resultUserService != null) {
            userServices.setId(resultUserService.getId());
            userServices.setNumberClick(resultUserService.getNumberClick() + 1);
        } else {
            userServices.setNumberClick(1L);
        }
        userServiceRepository.save(userServices);
        return true;

    }

    /**
     * Add services to listServiceDto
     * @param listServiceDto
     * @param services
     * @param numberClick
     */
    private void addToList(List<ServiceDTO> listServiceDto, Services services, Long numberClick) {
        ServiceDTO serviceDTO = new ServiceDTO();
        BeanUtils.copyProperties(services, serviceDTO);
        serviceDTO.setNumberClick(numberClick);
        listServiceDto.add(serviceDTO);
    }
}
