package com.iist.vse900.controller;

import com.iist.vse900.controller.base.BaseController;
import com.iist.vse900.domain.dto.CustomerDTO;
import com.iist.vse900.domain.model.Customer;
import com.iist.vse900.repository.impl.CustomerRepo;
import com.iist.vse900.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/custommer")
public class CustomerController extends BaseController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(name = "/getCustomerById", method = RequestMethod.GET)
    public ResponseEntity getById(@RequestParam("id") int id) {
        List<CustomerDTO> customer = customerService.getById(id);
        if (customer == null) {
            return buildResultJson(204, "Customer not exist!", null);
        }
        return buildResultJson(200, "OK", customer);
    }
}
