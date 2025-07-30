package com.library.repository;

import com.library.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, String> {
    
    // Öğrencinin tüm kayıtları
    List<BorrowRecord> findByStudentId(String studentId);
    
    // Kitabın tüm kayıtları
    List<BorrowRecord> findByBookIsbn(String bookIsbn);
    
    // Aktif kayıtlar (iade edilmemiş)
    @Query("SELECT br FROM BorrowRecord br WHERE br.isReturned = false")
    List<BorrowRecord> findActiveRecords();
    
    // Gecikmiş kayıtlar
    @Query("SELECT br FROM BorrowRecord br WHERE br.isReturned = false AND br.dueDate < :today")
    List<BorrowRecord> findOverdueRecords(@Param("today") LocalDate today);
    
    // Öğrencinin aktif kayıtları
    @Query("SELECT br FROM BorrowRecord br WHERE br.studentId = :studentId AND br.isReturned = false")
    List<BorrowRecord> findActiveRecordsByStudent(@Param("studentId") String studentId);
    
    // Toplam ödünç alma sayısı
    @Query("SELECT COUNT(br) FROM BorrowRecord br WHERE br.isReturned = false")
    long countActiveBorrows();
}