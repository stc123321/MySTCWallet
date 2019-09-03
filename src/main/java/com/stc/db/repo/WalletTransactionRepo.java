package com.stc.db.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stc.db.model.WalletTransaction;

@Repository
@Transactional
public interface WalletTransactionRepo extends CrudRepository<WalletTransaction, Long> {
	
	public List<WalletTransaction> findByCustomerId(Long id);

}
