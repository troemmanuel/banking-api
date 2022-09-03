package com.example.bankingapi.service;

import com.example.bankingapi.model.Account;
import com.example.bankingapi.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account){
        return this.accountRepository.save(account);
    }

    public Optional<Account> findById(UUID id){
        return this.accountRepository.findById(id);
    }

    public List<Account> findAll() {
        return this.accountRepository.findAll();
    }

    public UUID delete(UUID id) {
        this.accountRepository.deleteById(id);
        return id;
    }
}
