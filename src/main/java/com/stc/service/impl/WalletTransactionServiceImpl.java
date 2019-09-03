package com.stc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stc.db.model.TransactionForm;
import com.stc.db.model.Wallet;
import com.stc.db.model.WalletTransaction;
import com.stc.db.repo.WalletRepo;
import com.stc.db.repo.WalletTransactionRepo;
import com.stc.service.WalletTransactionService;

@Service
public class WalletTransactionServiceImpl implements WalletTransactionService {

	private WalletTransaction walletTransaction;
	private Wallet wallet;
	private Wallet senderWallet;
	private Wallet recieverWallet;
	
	Long customerId;

	private double newBlance;

	@Autowired
	private WalletTransactionRepo walletTransactionRepo;

	@Autowired
	private WalletRepo walletRepo;

	@Transactional
	public TransactionForm topUpMoney(TransactionForm trans_form) {
		// add to walletTransaction
		walletTransaction = new WalletTransaction();
		walletTransaction.setCustomerId(trans_form.getCustomerId());
		walletTransaction.setTrans_from(trans_form.getTrans_from());
		walletTransaction.setTrans_to(trans_form.getTrans_to());
		walletTransaction.setTrans_type("deposit");
		walletTransaction.setTrans_amount(trans_form.getTrans_amount());
		walletTransaction.setTrans_time(new Date());
		walletTransactionRepo.save(walletTransaction);

		// increase balance in wallet
		wallet = walletRepo.findByWalletIdCustomerIdAndWalletIdCurrencyType(trans_form.getCustomerId(),
				trans_form.getCurrencyType());
		newBlance = trans_form.getTrans_amount() + wallet.getBalance();
		wallet.setBalance(newBlance);
		walletRepo.save(wallet);

		return trans_form;
	}

	@Transactional
	public boolean transfer(TransactionForm trans_form) {

		senderWallet = walletRepo.findByWalletIdCustomerIdAndWalletIdCurrencyType(trans_form.getCustomerId(),
				trans_form.getCurrencyType());
		
		customerId = Long.parseLong(trans_form.getTrans_to());
		recieverWallet = walletRepo.findByWalletIdCustomerIdAndWalletIdCurrencyType(customerId,
				trans_form.getCurrencyType());

		// check the balance
		if (hasEnoughBalance(wallet.getBalance(), trans_form.getTrans_amount())) {
			// if yes then transfer money
			
			// add to transaction table
			walletTransaction = new WalletTransaction();
			walletTransaction.setCustomerId(trans_form.getCustomerId());
			walletTransaction.setTrans_from(trans_form.getTrans_from());
			walletTransaction.setTrans_to(trans_form.getTrans_to());
			walletTransaction.setTrans_type("deposit");
			walletTransaction.setTrans_amount(trans_form.getTrans_amount());
			walletTransaction.setTrans_time(new Date());
			walletTransactionRepo.save(walletTransaction);

			// update the balance of the sender wallet
			newBlance = trans_form.getTrans_amount() - senderWallet.getBalance();
			senderWallet.setBalance(newBlance);
			walletRepo.save(senderWallet);
			
			// update the balance of the receiver wallet
			newBlance = trans_form.getTrans_amount() + recieverWallet.getBalance();
			recieverWallet.setBalance(newBlance);
			walletRepo.save(recieverWallet);
			
			return true;
		} else {
			// if balance is less than the transfered money
			System.out.print("There is no enough balance in the account.");

			return false;
		}

	}

	private boolean hasEnoughBalance(double balance, double moneyToTransfer) {
		return balance >= moneyToTransfer;
	}

}
