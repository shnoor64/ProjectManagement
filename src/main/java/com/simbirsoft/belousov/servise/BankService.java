package com.simbirsoft.belousov.servise;

import com.simbirsoft.belousov.rest.dto.feign.AccountDetailsResponseDto;
import com.simbirsoft.belousov.rest.dto.feign.AccountHistoryResponseDto;

import java.util.List;

public interface BankService {
    /**
     * Метод позволяет оплатить старт проекта
     *
     * @return AccountDetailsResponseDto - детали аккаунта
     */
    AccountDetailsResponseDto payProject();

    /**
     * Метод позволяет полкчить историю аккаунта
     *
     * @return List<AccountHistoryResponseDto> - лист истории
     */
    List<AccountHistoryResponseDto> getAllHistoryAccount();
}
