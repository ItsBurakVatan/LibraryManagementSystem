package com.library.model;

import javax.persistence.*;
import java.time.LocalDate;
// Kullanılmayan import'ları kaldırın
// import java.util.HashMap;
// import java.util.Map;

@Entity
@Table(name = "library")
public class Library {
    @Id
    @Column(name = "library_id")
    private String libraryId;
    
    @Column(nullable = false)
    private String name;
    
    private String address;
    
    private String phone;
    
    private String email;
    
    @Column(name = "max_borrow_days")
    private int maxBorrowDays = 14;
    
    @Column(name = "max_borrow_limit")
    private int maxBorrowLimit = 5;
    
    @Column(name = "created_at")
    private LocalDate createdAt;
    
    // Constructor
    public Library() {
        this.createdAt = LocalDate.now();
    }
    
    public Library(String libraryId, String name, String address, String phone, String email) {
        this();
        this.libraryId = libraryId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    
    // Getter ve Setter metodları
    public String getLibraryId() { return libraryId; }
    public void setLibraryId(String libraryId) { this.libraryId = libraryId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public int getMaxBorrowDays() { return maxBorrowDays; }
    public void setMaxBorrowDays(int maxBorrowDays) { this.maxBorrowDays = maxBorrowDays; }
    
    public int getMaxBorrowLimit() { return maxBorrowLimit; }
    public void setMaxBorrowLimit(int maxBorrowLimit) { this.maxBorrowLimit = maxBorrowLimit; }
    
    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
    
    @Override
    public String toString() {
        return "Library{" +
                "libraryId='" + libraryId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", maxBorrowDays=" + maxBorrowDays +
                ", maxBorrowLimit=" + maxBorrowLimit +
                '}';
    }
}