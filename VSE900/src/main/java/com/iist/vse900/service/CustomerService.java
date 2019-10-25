package com.iist.vse900.service;

import com.iist.vse900.domain.dto.CustomerDTO;
import com.iist.vse900.domain.dto.UserBodyDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getById(int id);
}
