package com.library.service;

import com.library.model.Book;
import com.library.model.Student;
import com.library.model.BorrowRecord;
import com.library.repository.BookRepository;
import com.library.repository.StudentRepository;
import com.library.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class LibraryService {
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;
    
    // Kitap işlemleri
    public Book addBook(Book book) {
        System.out.println("Kitap ekleme çağrıldı: " + book);
        
        // Validasyon
        if (book.getIsbn() == null || book.getIsbn().trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN boş olamaz");
        }
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Başlık boş olamaz");
        }
        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("Yazar boş olamaz");
        }
        if (book.getTotalCopies() <= 0) {
            throw new IllegalArgumentException("Toplam kopya 0'dan büyük olmalı");
        }
        
        // availableCopies'i totalCopies ile aynı yap
        book.setAvailableCopies(book.getTotalCopies());
        
        Book savedBook = bookRepository.save(book);
        System.out.println("Kitap veritabanına kaydedildi: " + savedBook);
        return savedBook;
    }
    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }
    
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
    
    public List<Book> searchBooksByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }
    
    public List<Book> searchBooksByCategory(String category) {
        return bookRepository.findByCategory(category);
    }
    
    public List<Book> getAvailableBooks() {
        return bookRepository.findAvailableBooks();
    }
    
    public boolean deleteBook(String isbn) {
        if (bookRepository.existsById(isbn)) {
            bookRepository.deleteById(isbn);
            return true;
        }
        return false;
    }
    
    // Öğrenci işlemleri
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Student getStudentById(String studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }
    
    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
    
    public boolean deleteStudent(String studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }
    
    // Otomatik öğrenci ID oluştur
    public String generateStudentId() {
        List<String> lastIds = studentRepository.findLastStudentId();
        if (lastIds == null || lastIds.isEmpty()) {
            return "S001";
        }
        
        String lastId = lastIds.get(0); // İlk elemanı al
        if (lastId == null) {
            return "S001";
        }
        
        // S001 formatından sonraki sayıyı al
        String numberStr = lastId.substring(1); // "001" kısmını al
        int nextNumber = Integer.parseInt(numberStr) + 1;
        return String.format("S%03d", nextNumber); // S002, S003, vs.
    }
    
    // Kitap ödünç alma
    public boolean borrowBook(String studentId, String bookIsbn) {
        Student student = getStudentById(studentId);
        Book book = getBookByIsbn(bookIsbn);
        
        if (student == null || book == null) {
            return false;
        }
        
        // Öğrencinin ödünç alma limitini kontrol et
        long activeBorrows = borrowRecordRepository.findActiveRecordsByStudent(studentId).size();
        if (activeBorrows >= student.getMaxBorrowLimit()) {
            return false; // Limit dolu
        }
        
        // Kitabın mevcut olup olmadığını kontrol et
        if (book.getAvailableCopies() <= 0) {
            return false; // Kitap mevcut değil
        }
        
        // Kitap ödünç alma işlemi
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
        
        // Kayıt oluştur
        String recordId = generateRecordId();
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(14); // 2 hafta
        
        BorrowRecord record = new BorrowRecord(recordId, studentId, bookIsbn, borrowDate, dueDate);
        borrowRecordRepository.save(record);
        
        return true;
    }
    
    // Kitap iade etme
    public boolean returnBook(String recordId) {
        BorrowRecord record = borrowRecordRepository.findById(recordId).orElse(null);
        
        if (record == null || record.isReturned()) {
            return false;
        }
        
        // Kitabı bul ve güncelle
        Book book = getBookByIsbn(record.getBookIsbn());
        if (book != null) {
            book.setAvailableCopies(book.getAvailableCopies() + 1);
            bookRepository.save(book);
        }
        
        // Kaydı güncelle
        record.setReturned(true);
        record.setReturnDate(LocalDate.now());
        
        // Gecikme cezası hesapla
        if (record.isOverdue()) {
            long overdueDays = LocalDate.now().toEpochDay() - record.getDueDate().toEpochDay();
            BigDecimal fine = BigDecimal.valueOf(overdueDays * 0.50); // Günlük 0.50 TL
            record.setFineAmount(fine);
        }
        
        borrowRecordRepository.save(record);
        return true;
    }
    
    // Gecikmiş kitapları getir
    public List<BorrowRecord> getOverdueBooks() {
        return borrowRecordRepository.findOverdueRecords(LocalDate.now());
    }
    
    // Öğrencinin ödünç aldığı kitapları getir
    public List<BorrowRecord> getStudentBorrowRecords(String studentId) {
        return borrowRecordRepository.findByStudentId(studentId);
    }
    
    // Aktif ödünç alma kayıtlarını getir
    public List<BorrowRecord> getActiveBorrowRecords() {
        return borrowRecordRepository.findActiveRecords();
    }
    
    // İstatistikler
    public Map<String, Object> getLibraryStatistics() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalBooks", bookRepository.countTotalBooks());
        stats.put("availableBooks", bookRepository.countAvailableBooks());
        stats.put("totalStudents", studentRepository.countTotalStudents());
        stats.put("activeBorrows", borrowRecordRepository.countActiveBorrows());
        stats.put("overdueBooks", borrowRecordRepository.findOverdueRecords(LocalDate.now()).size());
        return stats;
    }
    
    // Kayıt ID'si oluştur
    private String generateRecordId() {
        return "REC" + System.currentTimeMillis();
    }
}