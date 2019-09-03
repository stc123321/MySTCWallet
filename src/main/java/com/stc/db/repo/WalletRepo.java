package com.stc.db.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stc.db.model.Wallet;

@Repository
public interface WalletRepo extends CrudRepository<Wallet, Long> {
	
	public Wallet findByWalletIdCustomerIdAndWalletIdCurrencyType(Long customerId, String currencyType);

}
