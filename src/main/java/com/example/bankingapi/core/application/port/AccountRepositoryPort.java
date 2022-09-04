package com.example.bankingapi.core.application.port;

import com.example.bankingapi.core.domain.entity.account.AccountEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepositoryPort {
    AccountEntity saveAccount(AccountEntity accountEntity);
    Optional<AccountEntity> findAccountById(UUID id);
    List<AccountEntity> findAllAccount();
}
