package com.simbirsoft.belousov.feign;

import com.simbirsoft.belousov.rest.dto.feign.AccountDetailsResponseDto;
import com.simbirsoft.belousov.rest.dto.feign.AccountHistoryResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(name = "MicroBank", url = "${micro-bank.url}", configuration = FeignClient.class)
public interface BankClient {

    @RequestMapping(method = RequestMethod.POST, value = "/{description}")
    public ResponseEntity<AccountDetailsResponseDto> paymentProject(@PathVariable String description);

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AccountHistoryResponseDto>> getAllHistory();
}
