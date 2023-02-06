package com.niit.service;

import com.niit.model.Customer;
import org.apache.catalina.User;

import java.util.List;

public interface CustomerService {
    public Customer registerUser(Customer customer);
    public Customer checkAuth(Customer customer);
    public List<Customer> getAllCustomers();
    public boolean deleteCustomer(int customerId);

}
