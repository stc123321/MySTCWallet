package com.stc.db.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class WalletId implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private Long customerId;
	private String currencyType; // SAR and TRY
 
    public WalletId() {
    }
 
    public WalletId(Long customerId, String currencyType) {
        this.customerId = customerId;
        this.currencyType = currencyType;
    }
 
    public Long getCustomerId() {
		return customerId;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WalletId)) return false;
        WalletId that = (WalletId) o;
        return Objects.equals(getCustomerId(), that.getCustomerId()) &&
                Objects.equals(getCurrencyType(), that.getCurrencyType());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getCurrencyType());
    }
}