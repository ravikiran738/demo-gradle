package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.cassandra.model.Customer;
import com.example.demo.cassandra.model.CustomerRequest;
import com.example.demo.service.CustomerService;

@Controller
@RequestMapping(path = "customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "", method = RequestMethod.POST, produces = { "application/json" })
	public Customer add(@RequestBody CustomerRequest customerRequest) {
		return customerService.save(customerRequest);

	}

	@RequestMapping(path = "{customerId}", method = RequestMethod.PUT, produces = { "application/json" })
	public Customer update(@PathVariable(name = "customerId") int customerId, @RequestBody CustomerRequest customerRequest) {
		customerRequest.setId(customerId);
		return customerService.update(customerRequest);

	}

	@RequestMapping(path = "{customerId}", method = RequestMethod.GET, produces = { "application/json" })
	public Customer get(@PathVariable(name = "customerId") int customerId) {
		return customerService.get(customerId);

	}

	@RequestMapping(path = "", method = RequestMethod.GET, produces = { "application/json" })
	public List<Customer> getAll() {
		return customerService.getAll();

	}

}
