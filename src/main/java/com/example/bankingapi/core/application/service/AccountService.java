package com.example.bankingapi.core.application.service;

import com.example.bankingapi.core.application.port.AccountRepositoryPort;
import com.example.bankingapi.core.domain.entity.account.AccountEntity;
import com.example.bankingapi.presentation.dto.account.request.CreateAccountRequestDto;
import com.example.bankingapi.presentation.dto.account.response.GetAllAccountResponseDto;
import com.example.bankingapi.presentation.usecases.AccountUseCases;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AccountService implements AccountUseCases {
    private final AccountRepositoryPort accountRepositoryPort;

    public AccountService(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public List<GetAllAccountResponseDto> findAllAccount() {
       List<AccountEntity> accounts  = this.accountRepositoryPort.findAllAccount();
       return accounts.stream().map(account -> new GetAllAccountResponseDto(account.getId(), account.getBalance(), account.getType())).collect(Collectors.toList());
    }

    @Override
    public UUID createAccount( CreateAccountRequestDto account) {
        AccountEntity accountEntity = AccountEntity.createAccount(UUID.randomUUID(), account.getType());
        this.accountRepositoryPort.saveAccount(accountEntity);
        return accountEntity.getId();
    }
}
