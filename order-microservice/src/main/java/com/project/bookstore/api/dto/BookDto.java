package com.project.bookstore.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class BookDto {

    private Integer id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Summary is required")
    private String summary;

    @NotNull(message = "ISBN is required")
    private String isbn;

    @NotNull(message = "Language is required")
    private String language;

    @NotNull(message = "Pages is required")
    private int pages;

    @NotNull(message = "Publisher is required")
    private String publisher;

    @NotNull(message = "Published Date is required")
    private LocalDate publishedDate;

    private MultipartFile image;

    private String imageUrl;

    private String pdfUrl;

    private List<String> authors = new ArrayList<>();

    @NotNull(message = "Genre is required")
    private List<String> genres = new ArrayList<>();
}


