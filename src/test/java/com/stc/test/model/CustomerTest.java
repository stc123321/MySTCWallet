package com.stc.test.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.stc.db.model.Customer;

public class CustomerTest {

	private Customer customer;

	private long customer_id;
	private String first_name;
	private String last_name;
	private String password;
	private String national_id;
	private String phone_number;

	@Before
	public void setup() {
		customer = new Customer(customer_id, first_name, last_name, password, national_id, phone_number);
	}

	@Test
	public void testGetCustomer_id() {
		assertThat(customer_id, equalTo(customer.getCustomer_id()));
	}

	@Test
	public void testGetFirst_name() {
		assertThat(first_name, equalTo(customer.getFirst_name()));
	}

	@Test
	public void testGetLast_name() {
		assertThat(last_name, equalTo(customer.getLast_name()));
	}

	@Test
	public void testGetPassword() {
		assertThat(password, equalTo(customer.getPassword()));
	}

	@Test
	public void testGetNational_id() {
		assertThat(national_id, equalTo(customer.getNational_id()));
	}

	@Test
	public void testGetPhone_number() {
		assertThat(phone_number, equalTo(customer.getPhone_number()));
	}

}
