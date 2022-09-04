package com.example.bankingapi.infrastructure.persistance.mapper;

import com.example.bankingapi.core.domain.entity.account.AccountEntity;
import com.example.bankingapi.infrastructure.persistance.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountEntity toDomain(Account account) {
        return AccountEntity.createAccount(account.getId(), account.getType());
    }

    public Account toModel(AccountEntity accountEntity) {
        return new Account(
                accountEntity.getBalance(),
                accountEntity.getIsActive(),
                accountEntity.getType()
                );
    }
}
