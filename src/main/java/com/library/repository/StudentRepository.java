package com.library.repository;

import com.library.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    
    // İsme göre arama
    List<Student> findByNameContainingIgnoreCase(String name);
    
    // Email'e göre arama
    Student findByEmail(String email);
    
    // Toplam öğrenci sayısı
    @Query("SELECT COUNT(s) FROM Student s")
    long countTotalStudents();
    
    // En son kullanılan ID'yi bul (LIMIT yerine TOP 1 kullanıyoruz)
    @Query("SELECT s.studentId FROM Student s ORDER BY s.studentId DESC")
    List<String> findLastStudentId();
}