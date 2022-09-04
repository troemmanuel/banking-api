package com.example.bankingapi.presentation.dto.account.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequestDto {
    @NonNull
    String type = "current";
}
