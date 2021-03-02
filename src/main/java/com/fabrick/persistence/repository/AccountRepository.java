package com.fabrick.persistence.repository;

import com.fabrick.persistence.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}