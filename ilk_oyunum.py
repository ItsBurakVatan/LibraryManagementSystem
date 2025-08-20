#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
🎮 İLK OYUNUNUZ: Sayı Tahmin Oyunu
Bu basit oyunla programlama ve oyun mantığının temellerini öğreneceksiniz!
"""

import random
import os

def temizle_ekran():
    """Ekranı temizler (Windows ve Linux/Mac uyumlu)"""
    os.system('cls' if os.name == 'nt' else 'clear')

def oyun_basligi():
    """Oyunun başlık ekranını gösterir"""
    print("=" * 50)
    print("🎮  SAYI TAHMİN OYUNU  🎮")
    print("=" * 50)
    print("📝 Kurallar:")
    print("   • 1 ile 100 arasında bir sayı tuttum")
    print("   • Size ipucu vereceğim")
    print("   • 7 hakkınız var")
    print("   • Hadi bakalım bulabilecek misiniz?")
    print("=" * 50)

def zorluk_secimi():
    """Oyuncudan zorluk seviyesi seçmesini ister"""
    print("\n🎯 Zorluk seviyesi seçin:")
    print("1. Kolay (1-50 arası, 10 hak)")
    print("2. Orta (1-100 arası, 7 hak)")
    print("3. Zor (1-200 arası, 5 hak)")
    
    while True:
        try:
            secim = int(input("\nSeçiminiz (1-3): "))
            if secim == 1:
                return 50, 10
            elif secim == 2:
                return 100, 7
            elif secim == 3:
                return 200, 5
            else:
                print("❌ Lütfen 1, 2 veya 3 seçin!")
        except ValueError:
            print("❌ Lütfen geçerli bir sayı girin!")

def tahmin_al(tahmin_sayisi, max_tahmin, max_sayi):
    """Oyuncudan tahmin alır ve doğrular"""
    while True:
        try:
            print(f"\n📊 Kalan hakkınız: {max_tahmin - tahmin_sayisi}")
            tahmin = int(input(f"Tahmininiz (1-{max_sayi}): "))
            
            if 1 <= tahmin <= max_sayi:
                return tahmin
            else:
                print(f"❌ Lütfen 1 ile {max_sayi} arasında bir sayı girin!")
        except ValueError:
            print("❌ Lütfen geçerli bir sayı girin!")

def ipucu_ver(tahmin, gizli_sayi, tahmin_sayisi):
    """Tahminin doğruluğuna göre ipucu verir"""
    fark = abs(tahmin - gizli_sayi)
    
    if tahmin == gizli_sayi:
        return "doğru"
    elif fark <= 5:
        if tahmin < gizli_sayi:
            print("🔥 Çok yaklaştınız! Biraz daha büyük!")
        else:
            print("🔥 Çok yaklaştınız! Biraz daha küçük!")
    elif fark <= 15:
        if tahmin < gizli_sayi:
            print("📈 Yakınsınız ama daha büyük bir sayı deneyin!")
        else:
            print("📉 Yakınsınız ama daha küçük bir sayı deneyin!")
    else:
        if tahmin < gizli_sayi:
            print("🚀 Çok küçük! Daha büyük bir sayı deneyin!")
        else:
            print("🐌 Çok büyük! Daha küçük bir sayı deneyin!")
    
    # Özel mesajlar
    if tahmin_sayisi == 1:
        print("💡 İpucu: Ortalama bir sayı düşünün!")
    elif tahmin_sayisi == 3:
        print("💡 İpucu: Şimdiye kadarki ipuçlarını birleştirin!")
    
    return "devam"

def oyun_sonu_istatistik(tahmin_sayisi, kazandi, gizli_sayi):
    """Oyun sonunda istatistikleri gösterir"""
    print("\n" + "=" * 40)
    print("📊 OYUN İSTATİSTİKLERİ")
    print("=" * 40)
    print(f"🎯 Doğru sayı: {gizli_sayi}")
    print(f"🎲 Toplam tahmin: {tahmin_sayisi}")
    
    if kazandi:
        if tahmin_sayisi == 1:
            print("🏆 MÜKEMMEL! İlk tahminde buldunuz!")
            puan = 1000
        elif tahmin_sayisi <= 3:
            print("🥇 HARİKA! Çok az tahminde buldunuz!")
            puan = 800
        elif tahmin_sayisi <= 5:
            print("🥈 İYİ! Makul sayıda tahminde buldunuz!")
            puan = 500
        else:
            print("🥉 BAŞARILI! Sonunda buldunuz!")
            puan = 200
        
        print(f"⭐ Puanınız: {puan}")
    else:
        print("😔 Bu sefer olmadı, ama vazgeçmeyin!")
        print("💪 Bir dahaki sefere daha iyi olacaksınız!")

def tekrar_oyna():
    """Oyuncuya tekrar oynamak isteyip istemediğini sorar"""
    while True:
        cevap = input("\n🔄 Tekrar oynamak ister misiniz? (e/h): ").lower()
        if cevap in ['e', 'evet', 'y', 'yes']:
            return True
        elif cevap in ['h', 'hayır', 'n', 'no']:
            return False
        else:
            print("❌ Lütfen 'e' (evet) veya 'h' (hayır) yazın!")

def ana_oyun():
    """Ana oyun döngüsü"""
    # Zorluk seçimi
    max_sayi, max_tahmin = zorluk_secimi()
    
    # Gizli sayıyı seç
    gizli_sayi = random.randint(1, max_sayi)
    tahmin_sayisi = 0
    
    print(f"\n🎲 1 ile {max_sayi} arasında bir sayı tuttum!")
    print("🤔 Hadi bakalım bulabilecek misiniz?\n")
    
    # Ana oyun döngüsü
    while tahmin_sayisi < max_tahmin:
        # Tahmin al
        tahmin = tahmin_al(tahmin_sayisi, max_tahmin, max_sayi)
        tahmin_sayisi += 1
        
        # İpucu ver
        sonuc = ipucu_ver(tahmin, gizli_sayi, tahmin_sayisi)
        
        if sonuc == "doğru":
            print(f"\n🎉 TEBRIKLER! {tahmin_sayisi} tahminde buldunuz!")
            oyun_sonu_istatistik(tahmin_sayisi, True, gizli_sayi)
            return
    
    # Oyun bitti, bulamadı
    print(f"\n💔 Maalesef hakkınız bitti!")
    oyun_sonu_istatistik(tahmin_sayisi, False, gizli_sayi)

def main():
    """Ana program"""
    print("🌟 Python ile İlk Oyun Geliştirme Deneyiminize Hoş Geldiniz! 🌟")
    
    while True:
        temizle_ekran()
        oyun_basligi()
        
        try:
            ana_oyun()
        except KeyboardInterrupt:
            print("\n\n👋 Oyundan çıkılıyor... Görüşürüz!")
            break
        
        if not tekrar_oyna():
            print("\n👋 Oynadığınız için teşekkürler!")
            print("💡 Bu sadece başlangıç! Daha büyük oyunlar sizi bekliyor!")
            break

if __name__ == "__main__":
    main()