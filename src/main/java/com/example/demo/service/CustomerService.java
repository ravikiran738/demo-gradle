package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cassandra.model.Customer;
import com.example.demo.cassandra.model.CustomerRequest;
import com.example.demo.cassandra.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	/**
	 * 
	 * @param customerRequest
	 * @return
	 */
	public Customer save(CustomerRequest customerRequest) {
		Customer customer = new Customer();
		customer.setId((int) (Math.random() * ((99999999 - 1) + 1)) + 1);
		customer.setAge(customerRequest.getAge());
		customer.setFirstname(customerRequest.getFirstname());
		customer.setLastname(customerRequest.getLastname());
		customerRepository.save(customer);
		return customer;
	}
	
	/**
	 * 
	 * @param customerRequest
	 * @return
	 */
	public Customer update(CustomerRequest customerRequest) {
		Customer customer = new Customer();
		customer.setId(customerRequest.getId());
		customer.setAge(customerRequest.getAge());
		customer.setFirstname(customerRequest.getFirstname());
		customer.setLastname(customerRequest.getLastname());
		customerRepository.save(customer);
		return customer;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Customer get(int id) {
		return customerRepository.findById(id).orElse(new Customer());
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Customer> getAll(){
		return customerRepository.findAll();
	}
	
	

}
