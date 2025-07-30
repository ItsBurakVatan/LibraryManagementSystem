package com.library.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Min;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @NotBlank(message = "ISBN boş olamaz")
    private String isbn;
    
    @Column(nullable = false)
    @NotBlank(message = "Başlık boş olamaz")
    private String title;
    
    @Column(nullable = false)
    @NotBlank(message = "Yazar boş olamaz")
    private String author;
    
    @Column
    private String category;
    
    @Column(name = "total_copies")
    @Min(value = 1, message = "Toplam kopya sayısı en az 1 olmalıdır")
    private int totalCopies = 1;
    
    @Column(name = "available_copies")
    @Min(value = 0, message = "Mevcut kopya sayısı 0'dan küçük olamaz")
    private int availableCopies = 1;
    
    @Column(name = "publish_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;
    
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();
    
    // Constructors
    public Book() {}
    
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    
    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public int getTotalCopies() {
        return totalCopies;
    }
    
    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }
    
    public int getAvailableCopies() {
        return availableCopies;
    }
    
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
    
    public LocalDate getPublishDate() {
        return publishDate;
    }
    
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
    
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}