package com.example.bankingapi.presentation.dto.account.response;

import com.example.bankingapi.core.domain.entity.account.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAccountResponseDto {
    private UUID id;
    private Integer balance;
    private String type;
}
