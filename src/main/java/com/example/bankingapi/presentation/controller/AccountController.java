package com.example.bankingapi.presentation.controller;

import com.example.bankingapi.presentation.dto.account.request.CreateAccountRequestDto;
import com.example.bankingapi.presentation.dto.account.response.GetAllAccountResponseDto;
import com.example.bankingapi.presentation.usecases.AccountUseCases;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountUseCases accountUseCases;

    public AccountController(AccountUseCases accountUseCases){
        this.accountUseCases = accountUseCases;
    }

    @GetMapping("/all")
    public ResponseEntity<List<GetAllAccountResponseDto>> findAllAccount() {
        List<GetAllAccountResponseDto> accounts = this.accountUseCases.findAllAccount();
        return new ResponseEntity<> (accounts, HttpStatus.ACCEPTED);
    }

//    @GetMapping("/one/{id}")
//    public Optional<Account> findOneAccount(@PathVariable UUID id) {
//        return Optional.ofNullable(this.accountUseCases.findAccountById(id));
//    }

    @PostMapping("/create")
    public ResponseEntity<HashMap<String, UUID>> createAccount(@RequestBody CreateAccountRequestDto account) {
        try {
            UUID id = this.accountUseCases.createAccount(account);
            HashMap<String, UUID> response = new HashMap<String, UUID>();
            response.put("id", id);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
