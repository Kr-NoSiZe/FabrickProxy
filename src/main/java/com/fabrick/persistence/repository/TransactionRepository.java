package com.fabrick.persistence.repository;

import com.fabrick.persistence.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}