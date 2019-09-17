package com.stc.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.db.model.TransactionForm;
import com.stc.db.model.WalletTransaction;
import com.stc.db.repo.WalletTransactionRepo;
import com.stc.service.WalletTransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value = "Wallet Transaction Controller", description = "customer can be transfer, top-up and list all the transactions through this Controller. ")
public class WalletTransactionController {

	@Autowired
	WalletTransactionService service;

	@Autowired
	WalletTransactionRepo repo;

	@ApiOperation(value = "View a list of available transaction for specefic customer", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/trans/{customerId}")
	public List<WalletTransaction> getById(@PathVariable Long customerId) {
		return repo.findByCustomerId(customerId);
	}

	@PostMapping(value = "/top_up_trans")
	public void create(@RequestBody WalletTransaction obj) {
		repo.save(obj);
	}

	@PutMapping(value = "/top_up_tran")
	public int topUpMoney(@RequestBody TransactionForm obj) {
		service.topUpMoney(obj);
		return 1;
	}

	@PutMapping(value = "/transfer_to")
	public void transferTo(@RequestBody TransactionForm obj) {
		service.transfer(obj);
	}

}
