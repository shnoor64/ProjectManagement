package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.feign.BankClient;
import com.simbirsoft.belousov.rest.dto.feign.AccountDetailsResponseDto;
import com.simbirsoft.belousov.rest.dto.feign.AccountHistoryResponseDto;
import com.simbirsoft.belousov.servise.BankService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    private final BankClient bankClient;

    public BankServiceImpl(BankClient bankClient) {
        this.bankClient = bankClient;
    }
    @Transactional
    @Override
    public AccountDetailsResponseDto payProject(String description) {
        return bankClient.paymentProject(description).getBody();
    }
    @Transactional
    @Override
    public List<AccountHistoryResponseDto> getAllHistoryAccount() {
        return bankClient.getAllHistory().getBody();
    }
}
