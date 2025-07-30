package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    
    // Başlığa göre arama
    List<Book> findByTitleContainingIgnoreCase(String title);
    
    // Yazara göre arama
    List<Book> findByAuthorContainingIgnoreCase(String author);
    
    // Kategoriye göre arama
    List<Book> findByCategory(String category);
    
    // Mevcut kitapları getir
    @Query("SELECT b FROM Book b WHERE b.availableCopies > 0")
    List<Book> findAvailableBooks();
    
    // Toplam kitap sayısı
    @Query("SELECT COUNT(b) FROM Book b")
    long countTotalBooks();
    
    // Mevcut kitap sayısı
    @Query("SELECT SUM(b.availableCopies) FROM Book b")
    Long countAvailableBooks();
}