package com.web.customer.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.customer.entities.Customer;
import com.web.customer.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	private String UPLOAD_DIR = "/Users/726762/Desktop/Uploads";
	
	@Autowired
	CustomerRepository repository;
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping(value="/customer/", method=RequestMethod.GET)
	public List<Customer> getCustomerList()
	{
		return repository.findAll();
	}
	
	@RequestMapping(value="/customer/{cid}", method = RequestMethod.GET)
	public Customer getCustomerById(@PathVariable("cid") int cid)
	{
		LOGGER.info("Finding by ID " + cid);
		return repository.findById(cid).get();
	}
	
	
	@RequestMapping(value="/customer/", method=RequestMethod.POST)
	public Customer createCustomer(@Valid @RequestBody Customer customer)
	{
		return repository.save(customer);
	}
	
	@RequestMapping(value="/customer/", method = RequestMethod.PUT)
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		return repository.save(customer);
	}
	
	@RequestMapping(value="/customer/{cid}", method = RequestMethod.DELETE)
	public void deleteCustomerById(@PathVariable("cid")int cid)
	{
		System.out.println("http://localhost:2022/welcome/v3/api-docs");
		System.out.println("http://localhost:2022/welcome/swagger-ui/index.html#/");
		repository.deleteById(cid);
	}
	
	@PostMapping("/upload")
	public boolean upload(@RequestParam("file") 	MultipartFile file) throws IllegalStateException, IOException
	{
		file.transferTo(new File(UPLOAD_DIR + file.getOriginalFilename()));
		return true;
	}


}
