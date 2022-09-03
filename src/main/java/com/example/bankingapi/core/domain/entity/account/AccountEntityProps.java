package com.example.bankingapi.core.domain.entity.account;

public interface AccountEntityProps {
    Integer balance = 0;
    Boolean isActive = true;
    String type = "current";

    Integer getBalance();

    void setBalance(Integer balance);

    Boolean getIsActive();

    void setIsActive(Boolean isActive);

    String getType();

    void setType(String type);

}
