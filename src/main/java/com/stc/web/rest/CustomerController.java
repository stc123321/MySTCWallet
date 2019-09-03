package com.stc.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.db.model.Customer;
import com.stc.db.repo.CustomerRepo;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "*")
@Api(value="Customer Controller", description="customers can be added to system via this api controller")
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepo;
	
	@PostMapping(value = "/add")
	public void create(@RequestBody Customer obj) {
		customerRepo.save(obj);
	}
}
