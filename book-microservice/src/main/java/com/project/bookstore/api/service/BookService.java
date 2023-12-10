package com.project.bookstore.api.service;

import com.project.bookstore.api.dto.BookDto;

public interface BookService {
    BookDto getBook(int id);
}
