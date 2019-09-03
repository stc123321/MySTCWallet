package com.stc.db.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Wallet {

	@EmbeddedId
	private WalletId walletId;

	private String accountNo;
	private String IBAN;
	private String walletType;
	private double balance;
	private String accountStatus;

	public Wallet(WalletId walletId, String accountNo, String IBAN, String walletType, double balance,
			String accountStatus) {
		super();
		this.walletId = walletId;
		this.accountNo = accountNo;
		this.IBAN = IBAN;
		this.walletType = walletType;
		this.balance = balance;
		this.accountStatus = accountStatus;
	}

	protected Wallet() {
		super();
	}

	public WalletId getWalletId() {
		return walletId;
	}

	public void setWalletId(WalletId walletId) {
		this.walletId = walletId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String IBAN) {
		this.IBAN = IBAN;
	}

	public String getWalletType() {
		return walletType;
	}

	public void setWalletType(String walletType) {
		this.walletType = walletType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", accountNo=" + accountNo + ", IBAN=" + IBAN + ", walletType="
				+ walletType + ", balance=" + balance + ", accountStatus=" + accountStatus + "]";
	}

}
