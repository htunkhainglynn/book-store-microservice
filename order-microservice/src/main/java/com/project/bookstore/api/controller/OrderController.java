package com.project.bookstore.api.controller;

import com.project.bookstore.api.dto.OrderDto;
import com.project.bookstore.api.service.OrderService;
import com.project.bookstore.utils.UserContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable int id) {
        log.info("LicenseServiceController Correlation id: {}",
                UserContextHolder.getContext().getCorrelationId());
        return ResponseEntity.ok(orderService.getOrder(id));
    }

}
