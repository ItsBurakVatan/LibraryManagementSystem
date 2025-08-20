# 🎮 Sıfırdan Oyun Geliştirme Rehberi

Merhaba! Bu rehber, oyun geliştirme dünyasına hiçbir bilgi olmadan adım atmak isteyen herkes için hazırlanmıştır. Her şeyi adım adım öğreneceğiz!

## 📋 İçindekiler

1. [Oyun Geliştirme Nedir?](#oyun-geliştirme-nedir)
2. [Gerekli Araçlar](#gerekli-araçlar)
3. [Öğrenme Yol Haritası](#öğrenme-yol-haritası)
4. [İlk Projeniz](#ilk-projeniz)
5. [Öğrenme Kaynakları](#öğrenme-kaynakları)
6. [Topluluklar](#topluluklar)

## 🎯 Oyun Geliştirme Nedir?

Oyun geliştirme, dijital oyunları tasarlama, programlama ve yayınlama sürecidir. Bu süreç şu ana bileşenleri içerir:

### 🔧 Ana Disiplinler:
- **Programlama**: Oyunun mantığını, yapay zekasını ve mekaniklerini kodlama
- **Oyun Tasarımı**: Oynanış, seviyeler, zorluk dengesi tasarlama
- **Grafik/Sanat**: Karakterler, ortamlar, arayüzler oluşturma
- **Ses Tasarımı**: Müzik, ses efektleri, diyaloglar
- **Test**: Hataları bulma ve oyun dengesini sağlama

## 🛠️ Gerekli Araçlar

### 🎮 Oyun Motorları (Yeni Başlayanlar İçin)

#### 1. **Godot Engine** ⭐ (ÖNERİLEN)
- ✅ **Ücretsiz ve açık kaynak**
- ✅ **Kolay öğrenme eğrisi**
- ✅ **Hem 2D hem 3D desteği**
- ✅ **Kendi programlama dili (GDScript) - Python benzeri**
- ✅ **Küçük dosya boyutu (50MB)**

**Neden Godot?**
- Sıfırdan başlayanlar için ideal
- Türkçe topluluk desteği
- Hızlı prototipleme
- Visual scripting desteği

#### 2. **Unity** 
- ✅ **Geniş platform desteği**
- ✅ **Büyük topluluk**
- ✅ **Çok sayıda tutorial**
- ❌ **C# bilgisi gerekli**
- ❌ **Daha karmaşık**

#### 3. **Pygame (Python)**
- ✅ **En basit başlangıç**
- ✅ **Python bilgisi yeterli**
- ✅ **Hızlı öğrenme**
- ❌ **Sadece 2D**
- ❌ **Performans sınırlı**

### 💻 Programlama Dilleri

#### Başlangıç İçin:
1. **Python** - En kolay, Pygame ile oyun yapabilirsiniz
2. **GDScript** - Godot'un kendi dili, Python'a çok benzer
3. **JavaScript** - Web tabanlı oyunlar için

#### İleri Seviye:
1. **C#** - Unity için
2. **C++** - Unreal Engine için

### 🎨 Grafik Araçları

#### Ücretsiz:
- **GIMP** - Photoshop alternatifi
- **Krita** - Dijital çizim ve sprite oluşturma
- **Blender** - 3D modelleme ve animasyon
- **Piskel** - Pixel art için

#### Ücretli:
- **Adobe Photoshop** - Profesyonel grafik düzenleme
- **Adobe Illustrator** - Vektör grafikleri

### 🔊 Ses Araçları

- **Audacity** (Ücretsiz) - Ses düzenleme
- **Bfxr** (Ücretsiz) - Retro ses efektleri
- **MuseScore** (Ücretsiz) - Müzik kompozisyonu

## 🗺️ Öğrenme Yol Haritası

### 📚 Aşama 1: Temel Bilgiler (1-2 Hafta)

#### Günlük Plan:
- **Gün 1-3**: Oyun geliştirme temellerini öğrenin
  - Oyun türlerini keşfedin
  - Oyun geliştirme sürecini anlayın
  - Temel terimleri öğrenin (sprite, texture, animation, etc.)

- **Gün 4-7**: Programlama temelleri
  - Python temellerini öğrenin (variables, loops, functions)
  - Basit konsol uygulamaları yazın

- **Gün 8-14**: İlk oyun motorunuzu seçin ve kurun
  - Godot'u indirin ve kurun
  - Temel arayüzü öğrenin
  - İlk "Hello World" projenizi oluşturun

### 🎯 Aşama 2: İlk Oyununuz (2-3 Hafta)

#### Hedef: Basit bir "Pong" oyunu yapmak

**Hafta 1:**
- Godot'ta sahne sistemi öğrenin
- Temel şekiller çizmeyi öğrenin
- Hareket etmeyi öğrenin

**Hafta 2:**
- Çarpışma algılamayı öğrenin
- Ses eklemeyi öğrenin
- Skor sistemi yapın

**Hafta 3:**
- Oyunu bitirin ve test edin
- Arkadaşlarınıza oynatın
- Geri bildirimleri değerlendirin

### 🚀 Aşama 3: Daha Karmaşık Projeler (1-2 Ay)

#### Proje Önerileri (Sırayla):
1. **Snake Oyunu** (1 hafta)
2. **Tetris Benzeri** (2 hafta)
3. **Platform Oyunu** (3-4 hafta)
4. **Basit RPG** (1-2 ay)

### 🎓 Aşama 4: Uzmanlaşma (3-6 Ay)

- Bir alan seçin (programlama, grafik, ses, tasarım)
- O alanda derinlemesine çalışın
- Büyük bir proje başlatın
- Topluluktan geri bildirim alın

## 🎮 İlk Projeniz: Basit Bir Oyun

Hemen başlayalım! Size basit bir Python oyunu yazacağım:

### Basit "Guess the Number" Oyunu

```python
import random

def tahmin_oyunu():
    print("🎮 Sayı Tahmin Oyununa Hoş Geldiniz!")
    print("1 ile 100 arasında bir sayı tuttum. Tahmin edin!")
    
    gizli_sayi = random.randint(1, 100)
    tahmin_sayisi = 0
    max_tahmin = 7
    
    while tahmin_sayisi < max_tahmin:
        try:
            tahmin = int(input(f"Tahmininiz ({tahmin_sayisi + 1}/{max_tahmin}): "))
            tahmin_sayisi += 1
            
            if tahmin == gizli_sayi:
                print(f"🎉 Tebrikler! {tahmin_sayisi} tahminde buldunuz!")
                return
            elif tahmin < gizli_sayi:
                print("📈 Daha büyük bir sayı deneyin!")
            else:
                print("📉 Daha küçük bir sayı deneyin!")
                
        except ValueError:
            print("❌ Lütfen geçerli bir sayı girin!")
    
    print(f"😔 Maalesef! Doğru cevap {gizli_sayi} idi.")

if __name__ == "__main__":
    tahmin_oyunu()
```

Bu oyunu çalıştırmak için:
1. Kodu bir `.py` dosyasına kaydedin
2. Terminal/komut satırında `python dosya_adi.py` yazın

## 📖 Öğrenme Kaynakları

### 🎥 YouTube Kanalları (Türkçe)
- **Oyun Geliştiricisi** - Unity ve C# eğitimleri
- **Kodluyoruz** - Genel programlama
- **Mustafa Murat Coşkun** - Python eğitimleri

### 🎥 YouTube Kanalları (İngilizce)
- **Brackeys** - Unity eğitimleri (arşiv)
- **GDQuest** - Godot eğitimleri
- **Code Monkey** - Oyun geliştirme konseptleri

### 📚 Online Kurslar
- **Udemy**: "Sıfırdan Oyun Geliştirme" kursları
- **Coursera**: "Introduction to Game Development"
- **edX**: MIT'den oyun geliştirme kursları

### 📖 Kitaplar
- **"The Art of Game Design"** - Jesse Schell
- **"Game Programming Patterns"** - Robert Nystrom
- **"Rules of Play"** - Katie Salen & Eric Zimmerman

### 🌐 Web Siteleri
- **Gamasutra** - Oyun geliştirme haberleri
- **itch.io** - Bağımsız oyunları keşfedin
- **GameDev.net** - Geliştirici topluluğu

## 👥 Topluluklar

### 🇹🇷 Türkçe Topluluklar
- **Game Developers Turkey** (Facebook)
- **Oyun Geliştiricileri Türkiye** (Discord)
- **Unity Türkiye** (Facebook)

### 🌍 Uluslararası Topluluklar
- **r/gamedev** (Reddit)
- **Unity Community**
- **Godot Community**
- **GameDev.tv Discord**

## 🎯 İlk 30 Günde Yapılacaklar Listesi

### Hafta 1: Temeller
- [ ] Python temellerini öğren (4 saat/gün)
- [ ] İlk konsol oyununu yaz
- [ ] Godot'u indir ve kur
- [ ] Godot arayüzünü keşfet

### Hafta 2: İlk Projeler
- [ ] Godot'ta ilk sahneyi oluştur
- [ ] Basit hareket sistemi yap
- [ ] Sprite kullanmayı öğren
- [ ] Ses eklemeyi öğren

### Hafta 3: Geliştirme
- [ ] İlk mini oyununu bitir
- [ ] Geri bildirim al
- [ ] İkinci projeye başla
- [ ] Toplulukla tanış

### Hafta 4: Derinleşme
- [ ] Daha karmaşık mekanikler ekle
- [ ] Grafik araçlarını keşfet
- [ ] İlk pixel art'ını yap
- [ ] Gelecek planlarını yap

## 💡 Önemli İpuçları

### ✅ Yapılması Gerekenler:
- **Küçük başlayın** - Basit projelerle başlayıp büyütün
- **Düzenli çalışın** - Günde 1-2 saat bile yeterli
- **Pratik yapın** - Teoriyi hemen uygulamaya geçirin
- **Toplulukla etkileşim kurun** - Sorular sorun, projelerinizi paylaşın
- **Geri bildirim alın** - Oyunlarınızı başkalarına oynatın
- **Sabırlı olun** - Öğrenme süreci zaman alır

### ❌ Yapılmaması Gerekenler:
- **Çok büyük projeler** - İlk oyununuz MMO olmasın
- **Mükemmeliyetçilik** - İlk oyununuz mükemmel olmayacak, bu normal
- **Çok fazla araç** - Bir araçta ustalaşın, sonra diğerlerine geçin
- **Tek başına çalışma** - Topluluktan yardım almaktan çekinmeyin
- **Vazgeçme** - Zorluklar normal, devam edin

## 🎯 Sonuç

Oyun geliştirme heyecan verici bir yolculuk! Bu rehberle:

1. **İlk 30 günde** temel bilgileri öğreneceksiniz
2. **İlk 3 ayda** basit oyunlar yapabileceksiniz  
3. **İlk yılda** kendi projelerinizi bitirebileceksiniz

**Unutmayın**: Her büyük oyun geliştirici de bir zamanlar sizin gibi sıfırdan başlamıştır. Önemli olan başlamak ve devam etmek!

---

### 🚀 Hemen Başlayın!

1. Bu rehberi kaydedin
2. Python'u öğrenmeye başlayın
3. İlk basit oyununuzu yazın
4. Toplulukla tanışın
5. Hayalinizdeki oyunu yapmaya doğru adım adım ilerleyin!

**Bol şans ve iyi kodlamalar! 🎮✨**

---

*Bu rehber sürekli güncellenmektedir. Sorularınız için toplulukları ziyaret edin!*