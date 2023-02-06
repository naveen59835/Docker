/*
 * Author : Naveen Kumar
 * Date : 06-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.controller;

import com.niit.model.Customer;
import com.niit.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class CustomerControllerV2 {
    CustomerService customerService;

    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("getallusers")
    public ResponseEntity<List<Customer>> getAllUsers() {
        return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
    }
    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId){
        if(customerService.deleteCustomer(customerId)){
            return new ResponseEntity<String>("Customer deleted successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Error Occured",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
