package com.brody.ebankingbackend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.brody.ebankingbackend.entities.AccountOperation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountOperationRepository extends PagingAndSortingRepository<AccountOperation, Long> {
	List<AccountOperation> findByBankAccountId(String accountId);
	
	Page<AccountOperation> findByBankAccountIdOrderByOperationDateDesc(String accountId, Pageable pageable);
}
