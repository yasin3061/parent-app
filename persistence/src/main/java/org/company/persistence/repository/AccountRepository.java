package org.company.persistence.repository;

import org.company.persistence.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// This module is coupled with Spring. This can be refactotred further to avoid the coupling
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findAccountById(Long id);
}
