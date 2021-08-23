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
import java.util.ResourceBundle;

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
    public AccountDetailsResponseDto payProject(String paymentStatus) {
        ProjectEntity projectEntity = projectRepository.findByName(paymentStatus);
        if (projectEntity == null) {
            throw new NoSuchException(ResourceBundle.getBundle("messages").getString("no.such.project"));
        }
        ResponseEntity<AccountDetailsResponseDto> result = bankClient.paymentProject(paymentStatus);
        projectEntity.setPaymentStatus(StatusPay.PAID);
        return result.getBody();
    }

    @Transactional
    @Override
    public List<AccountHistoryResponseDto> getAllHistoryAccount() {
        ResponseEntity<List<AccountHistoryResponseDto>> allHistory = bankClient.getAllHistory();
        return bankClient.getAllHistory().getBody();
    }
}
