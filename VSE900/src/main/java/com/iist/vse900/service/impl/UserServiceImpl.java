package com.iist.vse900.service.impl;

import com.iist.vse900.repository.impl.UserRepo;
import com.iist.vse900.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        return userRepo.changePassword(username, oldPassword, newPassword);
    }

    @Override
    public boolean resetPassword(String username) {
        return userRepo.resetPassword(username);
    }
}
