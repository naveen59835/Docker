/*
 * Author : Naveen Kumar
 * Date : 06-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.controller;

import com.niit.model.Customer;
import com.niit.service.CustomerService;
import com.niit.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    SecurityTokenGenerator securityTokenGenerator;
    CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }
    @PostMapping("/customer")
    public ResponseEntity<?> registerUser(@RequestBody Customer customer){
        Customer newCustomer = customerService.registerUser(customer);
        if(newCustomer!=null){
            return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<String>("Some Error",HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/checkauth")
    public ResponseEntity<?> checkAuth(@RequestBody Customer customer){
        Customer newCustomer1 = customerService.checkAuth(customer);
        if(newCustomer1!=null){
            return new ResponseEntity<>(securityTokenGenerator.generateToken(newCustomer1),HttpStatus.CREATED);

        }else {
            return new ResponseEntity<String>("Error Occured", HttpStatus.NOT_FOUND);
        }

    }
}
