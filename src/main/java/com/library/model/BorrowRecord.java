package com.library.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "borrow_records")
public class BorrowRecord {
    @Id
    @Column(name = "record_id")
    private String recordId;
    
    @Column(name = "student_id")
    private String studentId;
    
    @Column(name = "book_isbn")
    private String bookIsbn;
    
    @Column(name = "borrow_date", nullable = false)
    private LocalDate borrowDate;
    
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;
    
    @Column(name = "return_date")
    private LocalDate returnDate;
    
    @Column(name = "is_returned")
    private boolean isReturned = false;
    
    @Column(name = "fine_amount")
    private BigDecimal fineAmount = BigDecimal.ZERO;
    
    @Column(name = "created_at")
    private LocalDate createdAt;
    
    // Constructor
    public BorrowRecord() {
        this.createdAt = LocalDate.now();
    }
    
    public BorrowRecord(String recordId, String studentId, String bookIsbn, 
                       LocalDate borrowDate, LocalDate dueDate) {
        this();
        this.recordId = recordId;
        this.studentId = studentId;
        this.bookIsbn = bookIsbn;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }
    
    // Getter ve Setter metodları
    public String getRecordId() { return recordId; }
    public void setRecordId(String recordId) { this.recordId = recordId; }
    
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    
    public String getBookIsbn() { return bookIsbn; }
    public void setBookIsbn(String bookIsbn) { this.bookIsbn = bookIsbn; }
    
    public LocalDate getBorrowDate() { return borrowDate; }
    public void setBorrowDate(LocalDate borrowDate) { this.borrowDate = borrowDate; }
    
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    
    public boolean isReturned() { return isReturned; }
    public void setReturned(boolean returned) { isReturned = returned; }
    
    public BigDecimal getFineAmount() { return fineAmount; }
    public void setFineAmount(BigDecimal fineAmount) { this.fineAmount = fineAmount; }
    
    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
    
    public boolean isOverdue() {
        return !isReturned && LocalDate.now().isAfter(dueDate);
    }
    
    @Override
    public String toString() {
        return "BorrowRecord{" +
                "recordId='" + recordId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                ", isReturned=" + isReturned +
                '}';
    }
}