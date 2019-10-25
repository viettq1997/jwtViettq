package com.iist.vse900.repository.impl;

import com.iist.vse900.domain.model.UserServices;
import com.iist.vse900.repository.jpa.UserServiceJpaRepository;
import com.iist.vse900.repository.UserServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserServicesRepositoryImpl implements UserServicesRepository {

    @Autowired
    UserServiceJpaRepository userServiceJpaRepository;

    @Override
    public List<UserServices> getAll() {
        return userServiceJpaRepository.findAll();
    }

    @Override
    public List<UserServices> findByUserId(Long id) {
        return userServiceJpaRepository.findByUserId(id);
    }

    @Override
    public UserServices findFirstByUserIdAndServiceId(Long userId, Long serviceId) {
        return userServiceJpaRepository.findFirstByUserIdAndServiceId(userId, serviceId);
    }

    @Override
    public boolean save(UserServices userServices) {
        userServiceJpaRepository.save(userServices);
        return true;
    }
}
