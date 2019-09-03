package com.stc.service;

import org.springframework.stereotype.Service;

import com.stc.db.model.TransactionForm;

@Service
public interface WalletTransactionService {
	
	public TransactionForm topUpMoney(TransactionForm obj);
	
	public boolean transfer(TransactionForm trans_form);

}
