# spring-retry-poc
Spring Retry provides the ability to automatically re-invoke a failed operation. This application provides a quick implementation of spring retry functionality.

## Quick Start
This section provides a quick introduction to getting started with Spring Retry.

## Spring retry Annotations

@EnableRetry – to enable spring retry in spring boot project
@Retryable – to indicate any method to be a candidate of retry
@Recover – to specify fallback method!


## Maven dependencies

``` 
<dependency>
    <groupId>org.springframework.retry</groupId>
    <artifactId>spring-retry</artifactId>
    <version>${version}</version>
</dependency>
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-aspects</artifactId>
  <version>${version}</version>
</dependency> 
```

## Spring Retry Example

Now we will create one interface where we will simulate the retry scenarios.
```
 @Retryable( value = RuntimeException.class, maxAttemptsExpression = "3",
      backoff = @Backoff(delayExpression = "1000"))
  String getResponse();
  ```
  
@Retryable – This is the main annotation after @EnableRetry. This annotation tells that if we get RuntimeException from the method, then retry 3 number of times. Also, we are adding a maximum delay for each retry.

@Recover – This indicates after 3 retry, return the response from fallback method.
  
  
