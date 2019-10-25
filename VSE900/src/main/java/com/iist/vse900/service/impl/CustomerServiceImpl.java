package com.iist.vse900.service.impl;

import com.iist.vse900.domain.dto.CustomerDTO;
import com.iist.vse900.domain.dto.UserBodyDTO;
import com.iist.vse900.repository.impl.CustomerRepo;
import com.iist.vse900.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<CustomerDTO> getById(int id) {
        return customerRepo.getById(id);
    }

}
