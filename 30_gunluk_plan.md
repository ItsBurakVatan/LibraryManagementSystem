# 🗓️ 30 Günlük Oyun Geliştirme Planı

Bu plan, oyun geliştirme alanında hiçbir bilgisi olmayan kişiler için hazırlanmıştır. Her gün 1-2 saat çalışarak 30 günde temel bilgileri öğrenip ilk oyununuzu bitireceksiniz!

## 📊 Haftalık Hedefler

### 🎯 1. Hafta: Temeller ve Hazırlık
**Hedef**: Programlama temellerini öğren ve araçları kur

### 🎯 2. Hafta: İlk Adımlar
**Hedef**: Godot'u öğren ve basit projeler yap

### 🎯 3. Hafta: İlk Oyun
**Hedef**: Basit ama tamamlanmış bir oyun bitir

### 🎯 4. Hafta: Geliştirme ve Gelecek
**Hedef**: Oyunu geliştir ve gelecek planlarını yap

---

## 📅 HAFTA 1: TEMELLER (Gün 1-7)

### 🌅 Gün 1: Başlangıç
**⏰ Süre**: 2 saat  
**🎯 Hedef**: Oyun geliştirme dünyasına giriş

**📋 Yapılacaklar:**
- [ ] Bu rehberi tamamen okuyun (30 dk)
- [ ] Oyun türlerini araştırın (30 dk)
  - Platform oyunları (Mario, Sonic)
  - Bulmaca oyunları (Tetris, Candy Crush)
  - Aksiyon oyunları (Space Invaders)
  - RPG oyunları (Pokemon tarzı)
- [ ] Favori oyunlarınızı listeleyin ve neden sevdiğinizi yazın (30 dk)
- [ ] İlk Python programınızı yazın: "Merhaba Dünya!" (30 dk)

**📚 Öğrenilecekler:**
- Oyun türleri
- Oyun geliştirme süreci
- Python temelleri

**✅ Gün Sonu Kontrol:**
- Python kurulu mu? ✓
- İlk "Hello World" programı çalışıyor mu? ✓

---

### 🌅 Gün 2: Python Temelleri 1
**⏰ Süre**: 2 saat  
**🎯 Hedef**: Python temel kavramlarını öğren

**📋 Yapılacaklar:**
- [ ] Değişkenler ve veri tipleri (45 dk)
- [ ] Basit matematiksel işlemler (30 dk)
- [ ] Input/Output işlemleri (45 dk)

**💻 Pratik Kod:**
```python
# Değişkenler
isim = "Oyuncu"
yas = 25
puan = 0

# Kullanıcıdan veri alma
print("Oyun karakterinizi oluşturalım!")
karakter_ismi = input("Karakterinizin adı: ")
print(f"Merhaba {karakter_ismi}!")

# Basit hesaplama
sayi1 = int(input("Birinci sayı: "))
sayi2 = int(input("İkinci sayı: "))
toplam = sayi1 + sayi2
print(f"Toplam: {toplam}")
```

**✅ Gün Sonu Kontrol:**
- Değişken oluşturabiliyor musunuz? ✓
- Kullanıcıdan veri alıp işleyebiliyor musunuz? ✓

---

### 🌅 Gün 3: Python Temelleri 2
**⏰ Süre**: 2 saat  
**🎯 Hedef**: Koşullar ve döngüler

**📋 Yapılacaklar:**
- [ ] If/else koşulları (60 dk)
- [ ] While döngüleri (60 dk)

**💻 Pratik Kod:**
```python
# Basit oyun mantığı
can = 3
puan = 0

while can > 0:
    print(f"Can: {can}, Puan: {puan}")
    
    secim = input("Ne yapmak istiyorsuniz? (1: Saldır, 2: Kaç): ")
    
    if secim == "1":
        print("Saldırdınız!")
        puan += 10
        can -= 1
    elif secim == "2":
        print("Kaçtınız!")
        break
    else:
        print("Geçersiz seçim!")

print(f"Oyun bitti! Final puanınız: {puan}")
```

**✅ Gün Sonu Kontrol:**
- If/else kullanabiliyor musunuz? ✓
- While döngüsü yazabiliyor musunuz? ✓

---

### 🌅 Gün 4: Python Temelleri 3
**⏰ Süre**: 2 saat  
**🎯 Hedef**: Fonksiyonlar ve listeler

**📋 Yapılacaklar:**
- [ ] Fonksiyon tanımlama ve kullanma (60 dk)
- [ ] Listeler ve temel işlemler (60 dk)

**💻 Pratik Kod:**
```python
# Fonksiyonlar
def selamla(isim):
    return f"Merhaba {isim}!"

def puan_hesapla(seviye, bonus):
    return seviye * 100 + bonus

# Listeler
oyuncular = ["Ali", "Ayşe", "Mehmet"]
puanlar = [150, 200, 175]

print("Oyuncu Listesi:")
for i in range(len(oyuncular)):
    print(f"{oyuncular[i]}: {puanlar[i]} puan")

# En yüksek puanı bul
en_yuksek = max(puanlar)
print(f"En yüksek puan: {en_yuksek}")
```

**✅ Gün Sonu Kontrol:**
- Fonksiyon yazabiliyor musunuz? ✓
- Liste işlemleri yapabiliyor musunuz? ✓

---

### 🌅 Gün 5: İlk Mini Oyun
**⏰ Süre**: 2 saat  
**🎯 Hedef**: Sayı tahmin oyununu tamamla

**📋 Yapılacaklar:**
- [ ] `ilk_oyunum.py` dosyasını çalıştırın (30 dk)
- [ ] Kodu satır satır inceleyin (60 dk)
- [ ] Kendi versiyonunuzu yazın (30 dk)

**💻 Kendi Versiyonunuz:**
- Farklı zorluk seviyeleri ekleyin
- Daha eğlenceli mesajlar yazın
- Puan sistemi ekleyin

**✅ Gün Sonu Kontrol:**
- İlk oyununuz çalışıyor mu? ✓
- Kodun mantığını anlıyor musunuz? ✓

---

### 🌅 Gün 6: Godot Kurulum
**⏰ Süre**: 2 saat  
**🎯 Hedef**: Godot'u kur ve tanı

**📋 Yapılacaklar:**
- [ ] Godot'u indirin ve kurun (30 dk)
- [ ] İlk projeyi oluşturun (30 dk)
- [ ] Arayüzü keşfedin (60 dk)

**🔧 Kurulum Adımları:**
1. `godot_kurulum.md` dosyasını takip edin
2. İlk "Merhaba Dünya" projesini yapın
3. Her paneli (Scene, Inspector, etc.) inceleyin

**✅ Gün Sonu Kontrol:**
- Godot kurulu ve çalışıyor mu? ✓
- İlk proje oluşturuldu mu? ✓

---

### 🌅 Gün 7: Hafta Değerlendirmesi
**⏰ Süre**: 1.5 saat  
**🎯 Hedef**: Öğrendiklerini pekiştir

**📋 Yapılacaklar:**
- [ ] Python bilginizi test edin (45 dk)
- [ ] Godot'ta basit bir sahne oluşturun (45 dk)

**🧪 Test Soruları:**
1. Bir fonksiyon nasıl tanımlanır?
2. While döngüsü nasıl çalışır?
3. Liste elemanlarına nasıl erişilir?
4. Godot'ta node nedir?

**✅ Hafta Sonu Değerlendirme:**
- Python temellerini öğrendim ✓
- İlk oyunumu yaptım ✓
- Godot'u kurdum ve tanıdım ✓

---

## 📅 HAFTA 2: İLK ADIMLAR (Gün 8-14)

### 🌅 Gün 8: GDScript Temelleri
**⏰ Süre**: 2 saat  
**🎯 Hedef**: GDScript'e giriş

**📋 Yapılacaklar:**
- [ ] GDScript syntax'ını öğrenin (60 dk)
- [ ] İlk script'inizi yazın (60 dk)

**💻 İlk GDScript:**
```gdscript
extends Node2D

# Değişkenler
var oyuncu_ismi = "Kahraman"
var can = 100
var puan = 0

# Oyun başladığında çalışır
func _ready():
    print("Oyun başladı!")
    print("Oyuncu: " + oyuncu_ismi)

# Her frame'de çalışır
func _process(delta):
    if Input.is_action_just_pressed("ui_accept"):
        puan += 10
        print("Puan: " + str(puan))
```

**✅ Gün Sonu Kontrol:**
- İlk GDScript'iniz çalışıyor mu? ✓

---

### 🌅 Gün 9: Node Sistemi
**⏰ Süre**: 2 saat  
**🎯 Hedef**: Godot'un node sistemini anla

**📋 Yapılacaklar:**
- [ ] Temel node türlerini öğrenin (60 dk)
- [ ] Node hiyerarşisi oluşturun (60 dk)

**🔧 Deneyecekleriniz:**
- Node2D, Sprite2D, RigidBody2D
- Parent-child ilişkileri
- Scene kaydetme ve yükleme

**✅ Gün Sonu Kontrol:**
- Node hiyerarşisi oluşturabiliyor musunuz? ✓

---

### 🌅 Gün 10: Hareket ve Animasyon
**⏰ Süre**: 2 saat  
**🎯 Hedef**: Nesneleri hareket ettir

**📋 Yapılacaklar:**
- [ ] Position değiştirmeyi öğrenin (60 dk)
- [ ] Basit animasyon yapın (60 dk)

**💻 Hareket Kodu:**
```gdscript
extends Sprite2D

var hiz = 200

func _process(delta):
    if Input.is_action_pressed("ui_right"):
        position.x += hiz * delta
    if Input.is_action_pressed("ui_left"):
        position.x -= hiz * delta
```

**✅ Gün Sonu Kontrol:**
- Nesneleri hareket ettirebiliyor musunuz? ✓

---

### 🌅 Gün 11-14: İlk Gerçek Proje
**⏰ Süre**: 4 gün × 2 saat = 8 saat  
**🎯 Hedef**: Basit bir "Catch the Ball" oyunu

**📋 4 Günlük Plan:**

**Gün 11**: Temel kurulum
- Oyuncu karakteri (hareket eden)
- Düşen toplar
- Temel sahne düzeni

**Gün 12**: Oyun mekaniği  
- Çarpışma algılama
- Puan sistemi
- Top spawn sistemi

**Gün 13**: Geliştirmeler
- Ses efektleri
- Görsel iyileştirmeler
- Zorluk artışı

**Gün 14**: Bitirme
- Oyun menüsü
- Game over ekranı
- Final testler

---

## 📅 HAFTA 3: İLK OYUN (Gün 15-21)

### 🎯 Hedef: Tamamlanmış bir Pong oyunu

**📋 7 Günlük Detaylı Plan:**

### Gün 15: Proje Kurulumu
- Yeni Godot projesi oluştur
- Temel sahne yapısı
- Player paddle oluştur

### Gün 16: Oyuncu Kontrolü
- Paddle hareket sistemi
- Input handling
- Sınır kontrolü

### Gün 17: Top Mekaniği
- Ball fizik sistemi
- Başlangıç hareketi
- Duvar çarpışmaları

### Gün 18: AI Rakip
- Bilgisayar paddle'ı
- Basit AI mantığı
- Zorluk ayarı

### Gün 19: Skor Sistemi
- UI oluşturma
- Puan hesaplama
- Oyun bitişi

### Gün 20: Ses ve Efektler
- Ses efektleri ekleme
- Görsel efektler
- Parçacık sistemleri

### Gün 21: Son Dokunuşlar
- Menü sistemi
- Oyun ayarları
- Final testler

---

## 📅 HAFTA 4: GELİŞTİRME (Gün 22-30)

### 🎯 Hedef: Oyunu geliştir ve gelecek planlarını yap

### Gün 22-25: Oyun Geliştirmeleri
- Farklı zorluk seviyeleri
- Power-up'lar
- Daha iyi AI
- Görsel iyileştirmeler

### Gün 26-28: İkinci Proje Başlangıcı
- Yeni oyun türü seç (Snake veya Tetris)
- Temel kurulum
- İlk mekanikler

### Gün 29: Portfolyo Oluşturma
- Projelerinizi düzenleyin
- GitHub'a yükleyin
- Basit bir portfolyo sitesi

### Gün 30: Gelecek Planları
- Öğrendiklerinizi değerlendirin
- Sonraki 30 günlük planınızı yapın
- Toplulukla paylaşın

---

## 📊 Günlük Takip Tablosu

### Hafta 1: Temeller
| Gün | Konu | Süre | Tamamlandı |
|-----|------|------|------------|
| 1   | Oyun geliştirme girişi | 2h | ⬜ |
| 2   | Python temelleri 1 | 2h | ⬜ |
| 3   | Python temelleri 2 | 2h | ⬜ |
| 4   | Python temelleri 3 | 2h | ⬜ |
| 5   | İlk mini oyun | 2h | ⬜ |
| 6   | Godot kurulum | 2h | ⬜ |
| 7   | Hafta değerlendirme | 1.5h | ⬜ |

### Hafta 2: İlk Adımlar
| Gün | Konu | Süre | Tamamlandı |
|-----|------|------|------------|
| 8   | GDScript temelleri | 2h | ⬜ |
| 9   | Node sistemi | 2h | ⬜ |
| 10  | Hareket ve animasyon | 2h | ⬜ |
| 11  | Catch Ball - Kurulum | 2h | ⬜ |
| 12  | Catch Ball - Mekanik | 2h | ⬜ |
| 13  | Catch Ball - Geliştirme | 2h | ⬜ |
| 14  | Catch Ball - Bitirme | 2h | ⬜ |

## 💡 Başarı İpuçları

### ✅ Her Gün Yapın:
1. **Planlı çalışın** - Günlük hedefleri takip edin
2. **Notlar alın** - Öğrendiklerinizi yazın
3. **Pratik yapın** - Sadece okumayın, kodlayın
4. **Sorular sorun** - Anlamadığınız yerleri araştırın

### ⚠️ Dikkat Edilecekler:
1. **Mükemmeliyetçilik yapmayın** - İlk projeleriniz mükemmel olmayacak
2. **Çok hızlı gitmeyin** - Temelleri sağlam öğrenin
3. **Vazgeçmeyin** - Zorluklarla karşılaştığınızda devam edin
4. **Karşılaştırma yapmayın** - Herkesin öğrenme hızı farklıdır

## 🎯 30 Gün Sonunda Sahip Olacaklarınız:

### 💻 Teknik Beceriler:
- ✅ Python programlama temelleri
- ✅ GDScript bilgisi
- ✅ Godot Engine kullanımı
- ✅ Temel oyun geliştirme konseptleri
- ✅ Basit oyun mekaniği tasarımı

### 🎮 Tamamlanmış Projeler:
- ✅ Sayı tahmin oyunu (Python)
- ✅ Catch the Ball oyunu (Godot)
- ✅ Pong oyunu (Godot)
- ✅ Başlanmış ikinci proje

### 🌟 Kişisel Gelişim:
- ✅ Problem çözme becerisi
- ✅ Proje tamamlama deneyimi
- ✅ Oyun geliştirme süreç bilgisi
- ✅ Gelecek için net plan

## 🚀 31. Günden Sonra Ne Yapacaksınız?

### Kısa Vadeli Hedefler (2-3 ay):
1. **Daha karmaşık projeler** - Platform oyunu, RPG temelleri
2. **Grafik becerilerini geliştir** - Pixel art, 3D modelleme
3. **Ses tasarımını öğren** - Müzik ve efekt oluşturma
4. **Toplulukla etkileşim** - Projelerinizi paylaşın

### Uzun Vadeli Hedefler (6-12 ay):
1. **İlk ticari projeniz** - Steam'de satılabilecek kalitede
2. **Takım çalışması** - Diğer geliştiricilerle projeler
3. **Özel alanınızı seçin** - Programcı, tasarımcı, sanatçı
4. **Profesyonel gelişim** - İş fırsatları, freelance projeler

---

**Bu plan sizin oyun geliştirme yolculuğunuzun sadece başlangıcı! Her gün biraz ilerlediğinizde, 30 gün sonunda ne kadar yol aldığınıza şaşıracaksınız. 🎮✨**

**Bol şans ve iyi kodlamalar!**