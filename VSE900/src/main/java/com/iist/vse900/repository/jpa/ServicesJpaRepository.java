package com.iist.vse900.repository.jpa;

import com.iist.vse900.domain.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicesJpaRepository extends JpaRepository<Services, Long> {
    List<Services> findByIsActive(char isActive);
}
