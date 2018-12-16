package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cassandra.model.Customer;
import com.example.demo.cassandra.model.CustomerRequest;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping(value = "api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping
	public Customer add(@RequestBody CustomerRequest customerRequest) {
		return customerService.save(customerRequest);

	}

	@PutMapping("/{customerId}")
	public Customer update(@PathVariable(name = "customerId") int customerId, @RequestBody CustomerRequest customerRequest) {
		customerRequest.setId(customerId);
		return customerService.update(customerRequest);

	}

	@GetMapping("/{customerId}")
	public Customer get(@PathVariable(name = "customerId") int customerId) {
		return customerService.get(customerId);

	}

	@GetMapping
	public List<Customer> getAll() {
		return customerService.getAll();

	}

}
