/*
 * Author : Naveen Kumar
 * Date : 06-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.service;

import com.niit.model.Customer;
import com.niit.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements  CustomerService{
     CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer registerUser(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer checkAuth(Customer customer) {
        Customer customer1=customerRepo.findById(customer.getCustomerId()).get();
        if(customer1!=null){
        if(customer1.getCustomerPassword().equals(customer.getCustomerPassword())) {
    return customer;
        }else{
    return null;
    }
    }else{
        return null;
    }
}


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public boolean deleteCustomer(int customerId) {
       if(customerRepo.findById(customerId).isPresent()){
           Customer customer = customerRepo.findById(customerId).get();
           customerRepo.delete(customer);
           return true;
       }
       return false;
    }
}
