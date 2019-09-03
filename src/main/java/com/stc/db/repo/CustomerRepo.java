package com.stc.db.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stc.db.model.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {
	

}
