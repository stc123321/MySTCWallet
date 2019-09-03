package com.stc.db.model;

public class TransactionForm {

	public String trans_type; // deposit or withdrow or transfer

	public String trans_from;

	public String trans_to;

	public double trans_amount;

	private Long customerId;

	private String currencyType;

	public TransactionForm(String trans_type, String trans_from, String trans_to, double trans_amount, Long customerId,
			String currencyType) {
		super();
		this.trans_type = trans_type;
		this.trans_from = trans_from;
		this.trans_to = trans_to;
		this.trans_amount = trans_amount;
		this.customerId = customerId;
		this.currencyType = currencyType;
	}

	protected TransactionForm() {
		super();
	}

	public String getTrans_type() {
		return trans_type;
	}

	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}

	public String getTrans_from() {
		return trans_from;
	}

	public void setTrans_from(String trans_from) {
		this.trans_from = trans_from;
	}

	public String getTrans_to() {
		return trans_to;
	}

	public void setTrans_to(String trans_to) {
		this.trans_to = trans_to;
	}

	public double getTrans_amount() {
		return trans_amount;
	}

	public void setTrans_amount(double trans_amount) {
		this.trans_amount = trans_amount;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	@Override
	public String toString() {
		return "TransactionForm [trans_type=" + trans_type + ", trans_from=" + trans_from + ", trans_to=" + trans_to
				+ ", trans_amount=" + trans_amount + ", customerId=" + customerId + ", currencyType=" + currencyType
				+ "]";
	}

}
