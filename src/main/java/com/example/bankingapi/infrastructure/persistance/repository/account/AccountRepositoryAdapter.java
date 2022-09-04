package com.example.bankingapi.infrastructure.persistance.repository.account;

import com.example.bankingapi.core.application.port.AccountRepositoryPort;
import com.example.bankingapi.core.domain.entity.account.AccountEntity;
import com.example.bankingapi.infrastructure.persistance.mapper.AccountMapper;
import com.example.bankingapi.infrastructure.persistance.model.Account;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepositoryPort {

    final AccountRepository accountRepository;
    final AccountMapper accountMapper;

    @Override
    public AccountEntity saveAccount(AccountEntity accountEntity) {
        Account account = accountMapper.toModel(accountEntity);
        Account savedAccount = accountRepository.save(account);
        return this.accountMapper.toDomain(savedAccount);
    }

    @Override
    public Optional<AccountEntity> findAccountById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<AccountEntity> findAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(this.accountMapper::toDomain).collect(Collectors.toList());
    }
}
