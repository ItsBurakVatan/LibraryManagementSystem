# Dinamik Kütüphane Yönetim Sistemi

## Proje Açıklaması
Bu proje, veri yapıları ve algoritmalar dersi için geliştirilmiş bir kütüphane yönetim sistemidir. Temel veri yapıları (Array, LinkedList, Stack, Queue, HashMap, Tree) kullanılarak geliştirilmiştir.

## Kullanılan Veri Yapıları
- **HashMap**: Hızlı kitap ve öğrenci arama için
- **ArrayList**: Sıralı liste tutma için
- **LinkedList**: Kuyruk sistemi için
- **PriorityQueue**: Öncelikli sıra sistemi için
- **Stack**: Geçici veri saklama için

## Kullanılan Algoritmalar
- **Linear Search**: Kitap arama
- **Hash Search**: ISBN ile hızlı arama
- **Queue Operations**: Sıra yönetimi
- **Tree Traversal**: Kategori bazlı gruplama

## Özellikler
- Kitap ekleme, silme, arama
- Öğrenci kayıt sistemi
- Kitap ödünç alma/iade
- Kuyruk sistemi (sıra bekleme)
- Gecikmiş kitap takibi
- İstatistik raporlama

## Kurulum
1. Java 11 veya üzeri yükleyin
2. Maven yükleyin
3. Projeyi klonlayın
4. `mvn compile` komutu ile derleyin
5. `mvn exec:java -Dexec.mainClass="com.library.Main"` ile çalıştırın

## Test
`mvn test` komutu ile testleri çalıştırın.

## Lisans
MIT License