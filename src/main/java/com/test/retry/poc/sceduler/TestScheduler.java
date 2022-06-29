package com.test.retry.poc.sceduler;

import com.test.retry.poc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author shweta.tyagi
 * 2022-06-29 at 11:23 AM
 */
@Component
public class TestScheduler {

  TestService testService;

  public TestScheduler(TestService testService) {
    this.testService = testService;
  }

  @Scheduled(cron = "0 0/2 * * * ?")
  public void checkSpringRetry()
  {
    System.out.println("===============================");
    System.out.println("Inside RestController mathod..");
     testService.getResponse();
  }
}
