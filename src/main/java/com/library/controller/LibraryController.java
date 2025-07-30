package com.library.controller;

import com.library.model.*;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid; // Bu satırı ekleyin
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@Controller
public class LibraryController {
    
    @Autowired
    private LibraryService libraryService;
    
    // Ana sayfa
    @GetMapping("/")
    public String home(Model model) {
        Map<String, Object> stats = libraryService.getLibraryStatistics();
        model.addAttribute("stats", stats);
        return "index";
    }
    
    // Kitaplar sayfası
    @GetMapping("/books")
    public String books(Model model) {
        List<Book> books = libraryService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }
    
    // Kitap arama
    @GetMapping("/books/search")
    public String searchBooks(
            @RequestParam(required = false, defaultValue = "") String query,
            @RequestParam(required = false, defaultValue = "title") String type,
            Model model) {
        List<Book> results = new ArrayList<>();
        
        switch (type) {
            case "title":
                results = libraryService.searchBooksByTitle(query);
                break;
            case "author":
                results = libraryService.searchBooksByAuthor(query);
                break;
            case "category":
                results = libraryService.searchBooksByCategory(query);
                break;
            default:
                results = libraryService.getAllBooks();
        }
        
        model.addAttribute("books", results);
        model.addAttribute("query", query);
        model.addAttribute("type", type);
        return "books";
    }
    
    // Kitap ekleme formu
    @GetMapping("/books/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }
    
    // Kitap ekleme
    @PostMapping("/books/add")
    public String addBook(@Valid @ModelAttribute Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("Form hataları: " + result.getAllErrors());
            return "add-book";
        }
        
        try {
            // availableCopies'i totalCopies ile aynı yap
            book.setAvailableCopies(book.getTotalCopies());
            
            Book savedBook = libraryService.addBook(book);
            System.out.println("Kitap kaydedildi: " + savedBook);
            return "redirect:/books?success=true";
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
            model.addAttribute("error", "Kitap eklenirken hata oluştu: " + e.getMessage());
            return "add-book";
        }
    }
    
    // Öğrenciler sayfası
    @GetMapping("/students")
    public String students(Model model) {
        List<Student> students = libraryService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }
    
    // Öğrenci arama
    @GetMapping("/students/search")
    public String searchStudents(@RequestParam String query, Model model) {
        List<Student> results = libraryService.searchStudentsByName(query);
        model.addAttribute("students", results);
        model.addAttribute("query", query);
        return "students";
    }
    
    // Öğrenci ekleme formu
    @GetMapping("/students/add")
    public String addStudentForm(Model model) {
        Student student = new Student();
        student.setStudentId(libraryService.generateStudentId()); // Otomatik ID
        model.addAttribute("student", student);
        return "add-student";
    }
    
    // Öğrenci ekleme
    @PostMapping("/students/add")
    public String addStudent(@ModelAttribute Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "add-student";
        }
        
        try {
            libraryService.addStudent(student);
            return "redirect:/students";
        } catch (Exception e) {
            return "add-student";
        }
    }
    
    // Kitap ödünç alma formu
    @GetMapping("/borrow")
    public String borrowForm(Model model) {
        List<Book> availableBooks = libraryService.getAvailableBooks();
        List<Student> students = libraryService.getAllStudents();
        model.addAttribute("books", availableBooks);
        model.addAttribute("students", students);
        return "borrow";
    }
    
    // Kitap ödünç alma
    @PostMapping("/borrow")
    public String borrowBook(@RequestParam String studentId, 
                           @RequestParam String bookIsbn, 
                           Model model) {
        boolean success = libraryService.borrowBook(studentId, bookIsbn);
        if (success) {
            model.addAttribute("message", "Kitap başarıyla ödünç alındı!");
            model.addAttribute("success", true);
        } else {
            model.addAttribute("message", "Kitap ödünç alınamadı!");
            model.addAttribute("success", false);
        }
        return "redirect:/borrow";
    }
    
    // Kitap iade formu
    @GetMapping("/return")
    public String returnForm(Model model) {
        List<BorrowRecord> activeRecords = libraryService.getActiveBorrowRecords();
        model.addAttribute("records", activeRecords);
        return "return";
    }
    
    // Kitap iade etme
    @PostMapping("/return")
    public String returnBook(@RequestParam String recordId, Model model) {
        boolean success = libraryService.returnBook(recordId);
        if (success) {
            model.addAttribute("message", "Kitap başarıyla iade edildi!");
            model.addAttribute("success", true);
        } else {
            model.addAttribute("message", "Kitap iade edilemedi!");
            model.addAttribute("success", false);
        }
        return "redirect:/return";
    }
    
    // Gecikmiş kitaplar
    @GetMapping("/overdue")
    public String overdueBooks(Model model) {
        List<BorrowRecord> overdueRecords = libraryService.getOverdueBooks();
        model.addAttribute("records", overdueRecords);
        return "overdue";
    }
    
    // İstatistikler
    @GetMapping("/statistics")
    public String statistics(Model model) {
        Map<String, Object> stats = libraryService.getLibraryStatistics();
        model.addAttribute("stats", stats);
        return "statistics";
    }
}