#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
🎮 Basit Pygame Örneği: Hareket Eden Kare
Bu örnek, pygame ile basit bir oyun nasıl yapılır gösterir.

Kurulum için: pip install pygame
"""

try:
    import pygame
    import sys
    PYGAME_AVAILABLE = True
except ImportError:
    PYGAME_AVAILABLE = False
    print("❌ Pygame kurulu değil!")
    print("💡 Kurmak için: pip install pygame")

if PYGAME_AVAILABLE:
    # Pygame'i başlat
    pygame.init()
    
    # Renkler (RGB)
    BEYAZ = (255, 255, 255)
    SIYAH = (0, 0, 0)
    KIRMIZI = (255, 0, 0)
    MAVI = (0, 0, 255)
    YESIL = (0, 255, 0)
    
    # Ekran ayarları
    GENISLIK = 800
    YUKSEKLIK = 600
    FPS = 60
    
    # Ekranı oluştur
    ekran = pygame.display.set_mode((GENISLIK, YUKSEKLIK))
    pygame.display.set_caption("🎮 İlk Pygame Oyunum - Hareket Eden Kare")
    saat = pygame.time.Clock()
    
    # Oyuncu ayarları
    oyuncu_x = GENISLIK // 2
    oyuncu_y = YUKSEKLIK // 2
    oyuncu_boyut = 50
    oyuncu_hiz = 5
    
    # Ana oyun döngüsü
    calisir = True
    print("🎮 Oyun başladı!")
    print("📋 Kontroller:")
    print("   ⬆️ W veya ↑ - Yukarı")
    print("   ⬇️ S veya ↓ - Aşağı") 
    print("   ⬅️ A veya ← - Sol")
    print("   ➡️ D veya → - Sağ")
    print("   ❌ ESC veya X - Çıkış")
    
    while calisir:
        # Olayları kontrol et
        for olay in pygame.event.get():
            if olay.type == pygame.QUIT:
                calisir = False
            elif olay.type == pygame.KEYDOWN:
                if olay.key == pygame.K_ESCAPE:
                    calisir = False
        
        # Tuş basılı tutma kontrolü
        tuslar = pygame.key.get_pressed()
        
        # Hareket kontrolü
        if tuslar[pygame.K_LEFT] or tuslar[pygame.K_a]:
            oyuncu_x -= oyuncu_hiz
        if tuslar[pygame.K_RIGHT] or tuslar[pygame.K_d]:
            oyuncu_x += oyuncu_hiz
        if tuslar[pygame.K_UP] or tuslar[pygame.K_w]:
            oyuncu_y -= oyuncu_hiz
        if tuslar[pygame.K_DOWN] or tuslar[pygame.K_s]:
            oyuncu_y += oyuncu_hiz
        
        # Sınır kontrolü
        if oyuncu_x < 0:
            oyuncu_x = 0
        elif oyuncu_x > GENISLIK - oyuncu_boyut:
            oyuncu_x = GENISLIK - oyuncu_boyut
            
        if oyuncu_y < 0:
            oyuncu_y = 0
        elif oyuncu_y > YUKSEKLIK - oyuncu_boyut:
            oyuncu_y = YUKSEKLIK - oyuncu_boyut
        
        # Ekranı temizle
        ekran.fill(SIYAH)
        
        # Oyuncuyu çiz
        pygame.draw.rect(ekran, MAVI, (oyuncu_x, oyuncu_y, oyuncu_boyut, oyuncu_boyut))
        
        # Çerçeve çiz
        pygame.draw.rect(ekran, BEYAZ, (0, 0, GENISLIK, YUKSEKLIK), 2)
        
        # Orta çizgileri çiz
        pygame.draw.line(ekran, YESIL, (GENISLIK//2, 0), (GENISLIK//2, YUKSEKLIK), 1)
        pygame.draw.line(ekran, YESIL, (0, YUKSEKLIK//2), (GENISLIK, YUKSEKLIK//2), 1)
        
        # Ekranı güncelle
        pygame.display.flip()
        saat.tick(FPS)
    
    # Pygame'i kapat
    pygame.quit()
    print("👋 Oyun bitti! Teşekkürler!")

else:
    # Pygame yoksa basit konsol oyunu
    print("🎮 Pygame Kurulu Değil - Basit Konsol Oyunu")
    print("=" * 40)
    
    import random
    
    def basit_oyun():
        print("🎯 Basit Sayı Bulma Oyunu")
        sayi = random.randint(1, 10)
        tahmin = 0
        
        while tahmin != sayi:
            try:
                tahmin = int(input("1-10 arası sayı tahmin edin: "))
                if tahmin < sayi:
                    print("📈 Daha büyük!")
                elif tahmin > sayi:
                    print("📉 Daha küçük!")
                else:
                    print("🎉 Doğru! Tebrikler!")
            except ValueError:
                print("❌ Lütfen geçerli bir sayı girin!")
    
    basit_oyun()