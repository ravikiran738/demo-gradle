package com.example.demo.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.demo.cassandra.model.Customer;

public interface CustomerRepository extends CassandraRepository<Customer, String> {
	 
	@AllowFiltering
	public List<Customer> findByFirstname(String firstname);
 
}
