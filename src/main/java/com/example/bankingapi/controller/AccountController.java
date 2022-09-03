package com.example.bankingapi.controller;

import com.example.bankingapi.model.Account;
import com.example.bankingapi.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public List<Account> findAllAccount() {
        return this.accountService.findAll();
    }

    @GetMapping("/one/{id}")
    public Optional<Account> findOneAccount(@PathVariable UUID id) {
        return this.accountService.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Account>  createAccount(@RequestBody Account account) {
        try {
            this.accountService.createAccount(account);
            return new ResponseEntity<>(account, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable UUID id) {
        try {
            this.accountService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
