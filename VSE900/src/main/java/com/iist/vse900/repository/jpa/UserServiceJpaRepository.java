package com.iist.vse900.repository.jpa;

import com.iist.vse900.domain.model.UserServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserServiceJpaRepository extends JpaRepository<UserServices, Long> {
    List<UserServices> findByUserId(Long userId);
    UserServices findFirstByUserIdAndServiceId(Long userId, Long serviceId);
}
