package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.entity.ProjectEntity;
import com.simbirsoft.belousov.enums.StatusPay;
import com.simbirsoft.belousov.feign.BankClient;
import com.simbirsoft.belousov.repository.ProjectRepository;
import com.simbirsoft.belousov.rest.dto.feign.AccountDetailsResponseDto;
import com.simbirsoft.belousov.rest.dto.feign.AccountHistoryResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import com.simbirsoft.belousov.servise.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    private final BankClient bankClient;
    private final ProjectRepository projectRepository;

    public BankServiceImpl(BankClient bankClient, ProjectRepository projectRepository) {
        this.bankClient = bankClient;
        this.projectRepository = projectRepository;
    }

    @Transactional
    @Override
    public AccountDetailsResponseDto payProject(String description) {//description-будет название проекта
        ProjectEntity projectEntity = projectRepository.findByName(description);
        if (projectEntity == null) {
            throw new NoSuchException("Не найден проект, который хотите оплатить");
        }
        ResponseEntity<AccountDetailsResponseDto> result = bankClient.paymentProject(description);
        projectEntity.setDescriptionProject(String.valueOf(StatusPay.PAID));
        return result.getBody();
    }

    @Transactional
    @Override
    public List<AccountHistoryResponseDto> getAllHistoryAccount() {
        ResponseEntity<List<AccountHistoryResponseDto>> allHistory = bankClient.getAllHistory();
        return bankClient.getAllHistory().getBody();
    }
}
