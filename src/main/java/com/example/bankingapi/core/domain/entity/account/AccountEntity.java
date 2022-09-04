package com.example.bankingapi.core.domain.entity.account;

import java.util.UUID;

public class AccountEntity {
    final private UUID _id;
    private Integer balance;
    private final Boolean isActive;
    private final String type;

    AccountEntity(UUID id, Integer balance, String type, Boolean isActive) {
        this._id = id;
        this.balance = balance;
        this.type = type;
        this.isActive = isActive;
    }

    void validate() {
        // if (!this._id.getClass().getName().equals("UUID") ) throw new IllegalArgumentException();
    }

    public UUID getId() {
        return this._id;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public String getType() {
        return this.type;
    }

    public static AccountEntity createAccount(UUID id, String type){
     return new AccountEntity(id,0, type, true);
    }

    public void addMoney(Integer amount) {
        this.balance = + amount;
    }

    public void withdrawMoney(Integer amount) {
        if (balance < amount) {
            throw new RuntimeException("Balance cannot be lesser than amount to withdraw");
        }
        this.balance = - amount ;
    }

}
