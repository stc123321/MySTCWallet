package com.stc.db.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WalletTransaction")
public class WalletTransaction {

	@Id
	@GeneratedValue
	private Long id;

	private Long customerId;

	public String trans_type;

	public String trans_from;

	public String trans_to;

	public double trans_amount;

	public Date trans_time;

	public WalletTransaction() {
		super();
	}

	public WalletTransaction(Long id, Long customerId, String trans_type, String trans_from, String trans_to,
			double trans_amount, Date trans_time) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.trans_type = trans_type;
		this.trans_from = trans_from;
		this.trans_to = trans_to;
		this.trans_amount = trans_amount;
		this.trans_time = trans_time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public Date getTrans_time() {
		return trans_time;
	}

	public void setTrans_time(Date trans_time) {
		this.trans_time = trans_time;
	}

	@Override
	public String toString() {
		return "WalletTransaction [id=" + id + ", customerId=" + customerId + ", trans_type=" + trans_type
				+ ", trans_from=" + trans_from + ", trans_to=" + trans_to + ", trans_amount=" + trans_amount
				+ ", trans_time=" + trans_time + "]";
	}

}
