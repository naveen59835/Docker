/*
 * Author : Naveen Kumar
 * Date : 06-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.service;

import com.niit.model.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(Customer customer) {
        Map<String, String> tokenmap = new HashMap<String, String>();
        customer.setCustomerPassword("");
        Map<String, Object> userData=new HashMap<>();
        userData.put("customerId",customer.getCustomerId());
        String jwtTokenString= Jwts.builder().setClaims(userData).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS512,"hello").compact();
        tokenmap.put("token",jwtTokenString);
        tokenmap.put("message","Login Successful");
        return tokenmap;

    }
}
