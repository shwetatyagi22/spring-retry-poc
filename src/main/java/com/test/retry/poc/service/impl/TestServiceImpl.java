package com.test.retry.poc.service.impl;

import com.test.retry.poc.service.TestService;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author shweta.tyagi
 * 2022-06-29 at 11:21 AM
 */


@Service
@Slf4j
public class TestServiceImpl implements TestService {

  @Value("${retry.enabled}")
  private boolean retryEnabled;

  @Value("${retry.fallback.enabled}")
  private boolean fallbackEnabled;

  @Override
  public String getResponse() {

    if (retryEnabled) {
      log.info("retryEnabled is {}, so try to simulate exception scenario.", retryEnabled);

      if (fallbackEnabled) {
        throw new RuntimeException("Simulating spring retry..Must fallback as all retry will get exception!!!");
      }

      int random = new Random().nextInt(4);

      System.out.println("Random Number : " + random);
      if (random % 2 == 0) {
        throw new RuntimeException("Simulation for Spring-retry..");
      }
    }

    return "Hello from Remote Backend!!!";
  }

  @Override
  public String getResponseFallback(RuntimeException e) {
    System.out.println("All retries exausted, so Fallback method called!!!");
    return "All retries exausted, so Fallback method called!!!";
  }
}
