package com.example.bankingapi.infrastructure.persistance.repository.account;

import com.example.bankingapi.core.application.port.AccountRepositoryPort;
import com.example.bankingapi.infrastructure.persistance.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
}

