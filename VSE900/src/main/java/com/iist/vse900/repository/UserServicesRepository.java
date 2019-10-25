package com.iist.vse900.repository;

import com.iist.vse900.domain.model.UserServices;

import java.util.List;

public interface UserServicesRepository {
    List<UserServices> getAll();
    List<UserServices> findByUserId(Long id);
    UserServices findFirstByUserIdAndServiceId(Long userId, Long serviceId);
    boolean save(UserServices userServices);

}
