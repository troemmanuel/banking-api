package com.example.bankingapi.presentation.usecases;

import com.example.bankingapi.presentation.dto.account.request.CreateAccountRequestDto;
import com.example.bankingapi.presentation.dto.account.response.GetAllAccountResponseDto;

import java.util.List;
import java.util.UUID;

public interface AccountUseCases {
      List<GetAllAccountResponseDto> findAllAccount();
//    Account findAccountById(UUID id);
      UUID createAccount(CreateAccountRequestDto account);
}
