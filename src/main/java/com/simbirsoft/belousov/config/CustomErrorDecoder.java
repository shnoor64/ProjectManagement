package com.simbirsoft.belousov.config;

import com.simbirsoft.belousov.rest.exeption_handing.LowBalanceException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class CustomErrorDecoder implements ErrorDecoder {

  @Override
  public Exception decode(String s, Response response) {
    int status = response.status();

    if (status == 400) {
      return new LowBalanceException("Недостаточно денег");
    }
    return new RuntimeException();
  }
}
