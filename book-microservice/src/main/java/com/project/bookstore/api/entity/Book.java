package com.project.bookstore.api.entity;

import com.project.bookstore.api.dto.BookDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Slf4j
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String title;

    private String summary;

    @Column(unique = true)
    private String isbn;

    private String language;

    private int pages;

    private String publisher;

    private LocalDate publishedDate;

    @NotNull
    private String coverPhotoURL;

    private String pdfURL;

    public Book(BookDto bookDto) {
        this.title = bookDto.getTitle();
        this.summary = bookDto.getSummary();
        this.isbn = bookDto.getIsbn();
        this.coverPhotoURL = bookDto.getImageUrl();
        this.language = bookDto.getLanguage();
        this.pages = bookDto.getPages();
        this.publisher = bookDto.getPublisher();
        this.publishedDate = bookDto.getPublishedDate();
        this.pdfURL = bookDto.getPdfUrl();
    }
}

