package com.example.bankingapi.config;

import com.example.bankingapi.core.application.service.AccountService;
import com.example.bankingapi.infrastructure.persistance.mapper.AccountMapper;
import com.example.bankingapi.infrastructure.persistance.repository.account.AccountRepository;
import com.example.bankingapi.infrastructure.persistance.repository.account.AccountRepositoryAdapter;
import com.example.bankingapi.presentation.controller.AccountController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class BeanConfiguration {
    @Bean
    public AccountRepositoryAdapter accountRepositoryAdapter(AccountRepository accountRepository, AccountMapper accountMapper) {
        return new AccountRepositoryAdapter(accountRepository, accountMapper);
    }
    @Bean
    public AccountService accountService(AccountRepositoryAdapter accountRepositoryAdapter) {
        return new AccountService(accountRepositoryAdapter);
    }
}
