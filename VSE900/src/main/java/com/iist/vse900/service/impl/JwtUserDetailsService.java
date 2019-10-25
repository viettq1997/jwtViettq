package com.iist.vse900.service.impl;

import com.iist.vse900.repository.impl.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Transactional
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepo.loadUserByUsername(username);
    }
}

