package com.stc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.stc.db.model.Wallet;
import com.stc.db.model.WalletId;
import com.stc.db.model.WalletTransaction;
import com.stc.db.repo.WalletRepo;
import com.stc.db.repo.WalletTransactionRepo;

@SpringBootApplication
public class MyStcWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyStcWalletApplication.class, args);
	}
}
// to insert temporary data
@Component
class DemoCommandLineRunner implements CommandLineRunner {

	@Autowired
	private WalletTransactionRepo walletTransactionRepo;
	@Autowired
	private WalletRepo walletRepo;

	private WalletTransaction walletTransaction;
	private WalletId walletId;
	private Wallet wallet;

	private Long id = 12L;
	private Long customerId = 32311L;
	public String trans_type = "withdraw";
	public String trans_from = "Personal Account";
	public String trans_to = "";
	public int trans_amount = 200;
	@SuppressWarnings("deprecation")
	public Date trans_time = new Date(2000, 11, 21);

	public void run(String... args) throws Exception {

		walletTransaction = new WalletTransaction(id, customerId, trans_type, trans_from, trans_to, trans_amount, trans_time);
		walletTransactionRepo.save(walletTransaction);
		
		walletTransaction = new WalletTransaction(14L, customerId, "transfer", trans_from, trans_to, trans_amount, trans_time);
		walletTransactionRepo.save(walletTransaction);
		
		walletTransaction = new WalletTransaction(13L,81728L ,"deposit", trans_from, trans_to, 350, trans_time);
		walletTransactionRepo.save(walletTransaction);
		
		walletId = new WalletId(32311L, "SAR"); 
		wallet = new Wallet(walletId, "43434","SA323232", "Checking Account", 1212.43,
				"Active");
		walletRepo.save(wallet);
	}
}
