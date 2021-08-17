package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.feign.BankClient;
import com.simbirsoft.belousov.rest.dto.feign.AccountDetailsResponseDto;
import com.simbirsoft.belousov.rest.dto.feign.AccountHistoryResponseDto;
import com.simbirsoft.belousov.servise.BankService;

import java.util.List;

public class BankServiceImpl implements BankService {
    private final BankClient bankClient;

    public BankServiceImpl(BankClient bankClient) {
        this.bankClient = bankClient;
    }

    @Override
    public AccountDetailsResponseDto payProject() {
        return bankClient.paymentProject("денежка на корм").getBody();
    }

    @Override
    public List<AccountHistoryResponseDto> getAllHistoryAccount() {
        return bankClient.getAllHistory().getBody();
    }
}
