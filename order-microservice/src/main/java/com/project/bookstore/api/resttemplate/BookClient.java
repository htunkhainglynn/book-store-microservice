package com.project.bookstore.api.resttemplate;

import com.project.bookstore.api.dto.BookDto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:application.yml")
public class BookClient {

    @Autowired
    private RestTemplate bookTemplate;

    @Value("${book.service.url}")
    private String url;

    @PostConstruct
    private void getBookUrl() {
        this.url = url + "/api/v1/books";
    }

    public BookDto getBook(int id) {
        return bookTemplate.getForObject(url + "/" + id, BookDto.class);
    }

}
