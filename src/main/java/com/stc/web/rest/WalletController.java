package com.stc.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.db.model.Wallet;
import com.stc.db.repo.WalletRepo;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/wallet")
@CrossOrigin(origins = "*")
@Api(value = "Wallet Controller", description = "customer can add wallet to system via this api controller")
public class WalletController {

	@Autowired
	private WalletRepo walletRepo;

	@PostMapping(value = "/add")
	public ResponseEntity<String> create(@RequestBody Wallet obj) {
		// check if the wallet is exist or not
		Wallet wallet = walletRepo.findByWalletIdCustomerIdAndWalletIdCurrencyType(obj.getWalletId().getCustomerId(),
				obj.getWalletId().getCurrencyType());
		if (wallet !=null) {
			// if it is exist you can not create it.
			return new ResponseEntity<String>("can not created", HttpStatus.BAD_REQUEST);
		} else {
			// it will save the new wallet
			walletRepo.save(obj);
			return new ResponseEntity<String>("created", HttpStatus.OK);
		}
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/id={customerId}/{currencyType}")
	public List<Wallet> getById(@PathVariable Long customerId, String currencyType) {
		return (List<Wallet>) walletRepo.findByWalletIdCustomerIdAndWalletIdCurrencyType(customerId, currencyType);
	}

	@GetMapping(value = "/all")
	public List<Wallet> getAll() {
		return (List<Wallet>) walletRepo.findAll();
	}
}
