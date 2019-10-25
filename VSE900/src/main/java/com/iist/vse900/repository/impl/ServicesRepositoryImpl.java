package com.iist.vse900.repository.impl;

import com.iist.vse900.domain.model.Services;
import com.iist.vse900.repository.ServicesRepository;
import com.iist.vse900.repository.jpa.ServicesJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServicesRepositoryImpl implements ServicesRepository {

    @Autowired
    ServicesJpaRepository servicesJpaRepository;

    @Override
    public List<Services> getAll() {
        return servicesJpaRepository.findByIsActive('Y');
    }
}
