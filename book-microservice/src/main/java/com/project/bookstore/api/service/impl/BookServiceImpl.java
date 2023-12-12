package com.project.bookstore.api.service.impl;

import com.project.bookstore.api.dto.BookDto;
import com.project.bookstore.api.entity.Book;
import com.project.bookstore.api.service.BookService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public BookDto getBook(int id) {
        BookDto bookDto = new BookDto();
        bookDto.setId(1);
        bookDto.setTitle("The Lord of the Rings");
        bookDto.setSummary("The Lord of the Rings is an epic high-fantasy novel written by English author and scholar J. R. R. Tolkien.");
        bookDto.setIsbn("978-3-16-148410-0");
        bookDto.setLanguage("English");
        bookDto.setPages(1178);
        bookDto.setPublisher("George Allen & Unwin");
        bookDto.setPublishedDate(LocalDate.of(1954, 7, 29));
        bookDto.setImageUrl("https://upload.wikimedia.org/wikipedia/en/8/8e/The_Lord_of_the_Rings_1954_cover.jpg");
        bookDto.setPdfUrl("https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwjR9ZqJ7Z7uAhXQ4zgGHYK3DZMQFjAAegQIBhAC&url=https%3A%2F%2Fwww.planetebook.com%2Febooks%2FThe-Lord-of-the-Rings.pdf&usg=AOvVaw0QZ4Z4Z4Z4Z4Z4Z4Z4Z4Z4");
        bookDto.getAuthors().add("J. R. R. Tolkien");
        bookDto.getGenres().add("Fantasy");

        return bookDto;
    }
}
