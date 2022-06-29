package com.test.retry.poc.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

/**
 * @author shweta.tyagi
 * 2022-06-29 at 11:20 AM
 */
public interface TestService {

  @Retryable( value = RuntimeException.class, maxAttemptsExpression = "${retry.maxAttempts}",
      backoff = @Backoff(delayExpression = "${retry.maxDelay}"))
  String getResponse();

  @Recover
  String getResponseFallback(RuntimeException e);
}
