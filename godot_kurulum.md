# 🎮 Godot Engine Kurulum ve İlk Adımlar

## Godot Nedir?

Godot, ücretsiz ve açık kaynaklı bir oyun motorudur. Yeni başlayanlar için ideal çünkü:

- ✅ Tamamen ücretsiz
- ✅ Kolay öğrenme eğrisi  
- ✅ Hem 2D hem 3D oyunlar yapabilirsiniz
- ✅ Kendi programlama dili (GDScript) - Python'a çok benzer
- ✅ Visual scripting desteği (kod yazmadan)
- ✅ Küçük dosya boyutu (50MB)

## 🔧 Kurulum

### Linux (Ubuntu/Debian) için:

1. **Terminal'i açın** ve şu komutu çalıştırın:
```bash
# Godot'u indir
wget https://github.com/godotengine/godot/releases/download/4.3-stable/Godot_v4.3-stable_linux.x86_64.zip

# Zip dosyasını çıkar
unzip Godot_v4.3-stable_linux.x86_64.zip

# Çalıştırılabilir yap
chmod +x Godot_v4.3-stable_linux.x86_64

# Çalıştır
./Godot_v4.3-stable_linux.x86_64
```

2. **Alternatif: Snap ile kurulum**
```bash
sudo snap install godot-4
```

### Windows için:

1. [Godot resmi sitesine](https://godotengine.org/download) gidin
2. "Windows" sekmesinden "64-bit" sürümünü indirin
3. Zip dosyasını çıkarın
4. `Godot_v4.x-stable_win64.exe` dosyasını çalıştırın

### macOS için:

1. [Godot resmi sitesine](https://godotengine.org/download) gidin
2. "macOS" sekmesinden uygun sürümü indirin
3. DMG dosyasını açın ve Godot'u Applications klasörüne sürükleyin

## 🚀 İlk Proje Oluşturma

### 1. Godot'u Açın
- İlk açılışta proje yöneticisi görünecek
- "New Project" butonuna tıklayın

### 2. Proje Ayarları
- **Project Name**: "İlk Oyunum" yazın
- **Project Path**: Projenizin kaydedileceği klasörü seçin
- **Renderer**: "Forward+" seçili bırakın (varsayılan)
- "Create & Edit" butonuna tıklayın

### 3. Godot Arayüzü
Godot açıldığında şu bölümleri göreceksiniz:

- **Scene Panel** (Sol üst): Oyun nesnelerinin hiyerarşisi
- **FileSystem** (Sol alt): Proje dosyalarınız
- **Inspector** (Sağ): Seçili nesnenin özellikleri
- **Viewport** (Orta): Oyun sahneniz
- **Script Editor** (Alt): Kod yazma alanı

## 🎯 İlk Basit Oyun: "Merhaba Dünya"

Hemen basit bir örnek yapalım:

### 1. Yeni Sahne Oluştur
- Scene panel'de "+" butonuna tıklayın
- "2D Scene" seçin
- Ana node "Node2D" olarak gelecek

### 2. Label Ekle
- Node2D'ye sağ tıklayın
- "Add Child" seçin
- "Label" aratın ve seçin

### 3. Metni Değiştir
- Label'ı seçin
- Inspector'da "Text" alanına "Merhaba Dünya!" yazın
- "Horizontal Alignment" ve "Vertical Alignment"'ı "Center" yapın

### 4. Sahneyi Kaydet
- Ctrl+S basın
- "main.tscn" olarak kaydedin

### 5. Çalıştır
- F5 basın veya "Play" butonuna tıklayın
- "Select a Main Scene" diyorsa "main.tscn"'yi seçin

Tebrikler! İlk Godot projenizi oluşturdunuz! 🎉

## 📚 Sonraki Adımlar

### 1. GDScript Öğrenin
GDScript, Python'a çok benzer bir dildir:

```gdscript
# Basit GDScript örneği
extends Node2D

func _ready():
    print("Oyun başladı!")
    
func _process(delta):
    # Her frame'de çalışır
    pass

func _on_button_pressed():
    print("Butona tıklandı!")
```

### 2. Temel Konseptleri Öğrenin
- **Node**: Godot'ta her şey bir node'dur
- **Scene**: Node'ların koleksiyonu
- **Signal**: Olayları iletme sistemi
- **Script**: Node'lara davranış kazandırma

### 3. İlk Gerçek Oyununuz
Basit bir "Top Sekme" oyunu yapmayı deneyin:

1. **Ball** (RigidBody2D) - Fizik kurallarına uyan top
2. **Paddle** (StaticBody2D) - Oyuncunun kontrol ettiği platform
3. **Walls** (StaticBody2D) - Sınır duvarları

## 🎓 Öğrenme Kaynakları

### Resmi Dokümantasyon
- [Godot Docs](https://docs.godotengine.org/) - Resmi dokümantasyon
- [Godot Tutorials](https://docs.godotengine.org/en/stable/getting_started/step_by_step/index.html) - Adım adım rehberler

### YouTube Kanalları
- **GDQuest** - En iyi Godot eğitimleri
- **HeartBeast** - Oyun geliştirme temelleri
- **Godot Tutorials** - Çeşitli projeler

### Türkçe Kaynaklar
- **Godot Türkiye Discord** - Türkçe topluluk
- **YouTube'da Türkçe Godot** videoları arayın

## 🔧 Faydalı Kısayollar

- **F5**: Oyunu çalıştır
- **F6**: Mevcut sahneyi çalıştır
- **Ctrl+S**: Kaydet
- **Ctrl+D**: Seçili node'u kopyala
- **Ctrl+Z**: Geri al
- **Tab**: Script editör ile sahne editörü arası geçiş

## 💡 İpuçları

### Yeni Başlayanlar İçin:
1. **Küçük başlayın** - İlk oyununuz Pong veya Snake olsun
2. **Dokümantasyonu okuyun** - Godot'un dokümantasyonu çok iyi
3. **Örnekleri inceleyin** - Godot ile gelen demo projeleri çalıştırın
4. **Toplulukla etkileşim kurun** - Discord ve forumlarda soru sorun
5. **Sabırlı olun** - Her şeyi bir anda öğrenmeye çalışmayın

### Sık Yapılan Hatalar:
- ❌ Çok büyük projelerle başlamak
- ❌ Node hiyerarşisini anlamadan ilerlemek
- ❌ Signal sistemini öğrenmemek
- ❌ Physics layer'larını yanlış ayarlamak

## 🎮 İlk Proje Önerisi: Pong Oyunu

Godot'u öğrenmenin en iyi yolu basit bir Pong oyunu yapmaktır:

### Gerekli Node'lar:
1. **Main** (Node2D) - Ana sahne
2. **Player** (CharacterBody2D) - Oyuncu raketi
3. **Ball** (RigidBody2D) - Top
4. **Walls** (StaticBody2D) - Duvarlar
5. **UI** (CanvasLayer) - Skor gösterimi

### Öğreneceğiniz Konular:
- Node sistemi
- Fizik simülasyonu
- Input handling
- Collision detection
- UI sistemleri
- Audio ekleme

## 🚀 Sonuç

Godot ile oyun geliştirme yolculuğunuz başladı! 

**Sonraki adımlarınız:**
1. ✅ Godot'u kurun ve çalıştırın
2. ✅ İlk "Merhaba Dünya" projesini yapın
3. ✅ GDScript temellerini öğrenin
4. ✅ Basit bir Pong oyunu yapın
5. ✅ Toplulukla tanışın

**Unutmayın**: Her uzman bir zamanlar başlangıçtı. Sabırlı olun ve pratik yapmaya devam edin!

---

**Bol şans ve iyi kodlamalar! 🎮✨**