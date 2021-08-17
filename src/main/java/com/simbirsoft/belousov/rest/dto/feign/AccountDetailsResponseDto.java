package com.simbirsoft.belousov.rest.dto.feign;

public class AccountDetailsResponseDto {

    private String fullName;

    private float balance;

    public AccountDetailsResponseDto() {
    }

    public AccountDetailsResponseDto(String fullName, float balance) {
        this.fullName = fullName;
        this.balance = balance;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
