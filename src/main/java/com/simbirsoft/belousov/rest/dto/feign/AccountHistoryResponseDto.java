package com.simbirsoft.belousov.rest.dto.feign;

import java.time.LocalDateTime;

public class AccountHistoryResponseDto {
    private long id;

    private long account;

    private String typeOperation;

    private float amountMoney;

    private LocalDateTime timeOperation;

    private String description;

    public AccountHistoryResponseDto() {
    }

    public AccountHistoryResponseDto(long id, long account, String typeOperation, float amountMoney, LocalDateTime timeOperation, String description) {
        this.id = id;
        this.account = account;
        this.typeOperation = typeOperation;
        this.amountMoney = amountMoney;
        this.timeOperation = timeOperation;
        this.description = description;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public float getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(float amountMoney) {
        this.amountMoney = amountMoney;
    }

    public LocalDateTime getTimeOperation() {
        return timeOperation;
    }

    public void setTimeOperation(LocalDateTime timeOperation) {
        this.timeOperation = timeOperation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
