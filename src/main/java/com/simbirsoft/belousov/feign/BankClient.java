package com.simbirsoft.belousov.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name ="MicroBank")
public interface BankClient {

}
