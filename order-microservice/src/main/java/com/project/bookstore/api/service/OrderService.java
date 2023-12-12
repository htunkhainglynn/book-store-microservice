package com.project.bookstore.api.service;

import com.project.bookstore.api.dto.OrderDto;

public interface OrderService {
    OrderDto getOrder(int id);
}
