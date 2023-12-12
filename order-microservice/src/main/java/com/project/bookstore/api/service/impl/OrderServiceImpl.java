package com.project.bookstore.api.service.impl;

import com.project.bookstore.api.dto.BookDto;
import com.project.bookstore.api.dto.OrderDto;
import com.project.bookstore.api.resttemplate.BookClient;
import com.project.bookstore.api.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.ws.rs.core.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.TimeoutException;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BookClient bookClient;

    private int randomlyRunLong() {
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;
        if (randomNumber == 3) {
            sleep();
        }
        return randomNumber;
    }

    private void sleep() {
        try {
            log.info("Sleep");
            Thread.sleep(5000);
            throw new TimeoutException("Service failed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            log.info("Timeout exception");
        }
    }

    @CircuitBreaker(name = "orderService")
//    @Retry(name  = "retryOrderService")
    @Retryable(value = { TimeoutException.class }, exclude = {
            HttpStatusCodeException.class }, maxAttemptsExpression = "3", backoff = @Backoff(delayExpression = "60000"))
    @Override
    public OrderDto getOrder(int id) {



        int randomNumber = randomlyRunLong();
        log.info("Random number: {}", randomNumber);
//        System.out.println("test");
        BookDto bookDto = bookClient.getBook(id);
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        orderDto.setOrderDate(LocalDate.now());
        orderDto.getBooks().add(bookDto);

        return orderDto;
    }

    public OrderDto getOrderFallback(int id, Exception e) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        orderDto.setOrderDate(LocalDate.of(2021, 1, 1));

        return orderDto;
    }
}
