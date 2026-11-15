# Character Manager — TP3 (Java Visual SIH-6406)

Character Manager adalah project Java yang dibuat untuk mempelajari konsep class, object, constructor, enum, dan encapsulation. Pada tugas ini, project dikembangkan dengan menambahkan atribut mana, validasi mana agar tidak bernilai negatif, serta method isAlive() untuk memeriksa status hidup karakter.

Simpan screenshot hasil program ke dalam folder docs dengan nama output-terminalTP3.png.

Struktur Folder

```
CharacterManager/
├── src/
│   ├── Main.java
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               └── model/
│                   ├── Character.java
│                   └── CharacterType.java
```

Identitas Mahasiswa

Nama lengkap: Priscilla Chyntia Simanullang
NIM: 253303621212
Google Docs Analisis: https://1drv.ms/w/c/711877E32029CA45/IQD4hOyfZ7AHSYfR643nN2uPAcfcvBNCh9Cc7JuHXVqNbdw?e=hCm5Ar

# Character Manager — TP5

## Deskripsi Proyek dan screenshot CRUD

Character Manager merupakan aplikasi berbasis Java yang digunakan untuk mengelola data karakter dalam sebuah game. Aplikasi ini menerapkan konsep CRUD (*Create, Read, Update, Delete*) untuk menambahkan, menampilkan, mencari, dan menghapus data karakter.

Proyek ini juga menerapkan konsep Object-Oriented Programming (OOP), seperti Encapsulation, Constructor, Method, Static, dan Object Reference. Selain itu, terdapat fitur validasi nama duplikat, pencarian berdasarkan jenis karakter, perhitungan rata-rata level, serta pengelolaan data menggunakan `ArrayList`.

screenshot ada di output-terminalTP5

  # Fitur Utama
- Menambahkan karakter dengan validasi nama duplikat.
- Mencari karakter berdasarkan nama.
- Menghapus karakter berdasarkan nama.
- Menghitung jumlah karakter yang tersimpan.
- Mengambil salinan daftar karakter.
- Menghitung rata-rata level dengan aman saat daftar kosong.
- Mencari karakter berdasarkan tipe.
- Menghitung jumlah karakter berdasarkan tipe.

# Fitur Analitik Tambahan
Method countByType() menghitung jumlah karakter dengan tipe tertentu. Method ini membantu memperoleh ringkasan jumlah Warrior, Mage, dan Archer tanpa menghitung secara manual.

# Encapsulation dan Reference
Daftar karakter disimpan sebagai atribut private. Method getAllCharacters() mengembalikan salinan ArrayList agar perubahan struktur pada daftar hasil tidak mengubah daftar internal CharacterManager.

Salinan tersebut merupakan shallow copy. Objek Character di dalamnya masih menggunakan reference yang sama dengan objek pada daftar internal.

Link Google Docs : https://1drv.ms/w/c/711877E32029CA45/IQA0inSEJKxvQpdu6rFVqQigAQWqys-3mUGngN9mlMoYNUE?e=hLyrp6


## TP8 — MainWindow, Data Dinamis & Analisis MVC

### 1. Screenshot MainWindow

hasil screenshot MainWindow ada di output-terminal-sesudah.png

### 2. Alur Data dan Konsep MVC

Pada aplikasi Character Manager, class `Main` bertugas membuat objek `CharacterManager`, menambahkan data karakter, kemudian membuat `CharacterController` dan `MainWindow`.

`CharacterManager` berperan sebagai Model yang mengelola data karakter, sedangkan `CharacterController` menjadi penghubung antara Model dan View dengan menyediakan data yang diperlukan.

`MainWindow` berperan sebagai View yang menampilkan daftar karakter, jumlah karakter, dan rata-rata level secara dinamis.

Dengan penerapan konsep MVC (Model-View-Controller), setiap bagian memiliki tanggung jawab masing-masing sehingga program menjadi lebih terstruktur, mudah dipahami, dan mudah dikembangkan.

### 3. Daftar Karakter dan Alasan Pemilihan

| Nama Karakter | Tipe | Level | Alasan Pemilihan |
|---|---|---:|---|
| Aragorn | WARRIOR | 5 | Melambangkan karakter petarung dengan kemampuan menyerang yang baik. |
| Gandalf | MAGE | 3 | Melambangkan penyihir dengan kemampuan sihir. |
| Legolas | ARCHER | 4 | Melambangkan pemanah dengan kemampuan menyerang dari jarak jauh. |
| Evelyn | HEALER | 6 | Melambangkan karakter pendukung yang berfokus pada penyembuhan. |
| Alucard | MAGE | 10 | Dipilih sebagai karakter dengan level tertinggi untuk menunjukkan variasi level. |

### 4. Link Google Docs — Bagian D

Dokumentasi analisis konseptual MVC:

**Link Google Docs:** https://1drv.ms/w/c/711877E32029CA45/IQBwEi4NWF6lSL-Aa5ysh5ilAdBXFKsUnWUFoWzMojRLUY4?e=NFhwo6 

## TP10 — Theming, Properti Komponen & Analisis MVC

### A. Implementasi AppTheme

Pada TP10, aplikasi Character Manager dikembangkan dengan menggunakan class `AppTheme.java` yang berada di package `view`.

AppTheme digunakan untuk mengatur tampilan aplikasi agar lebih konsisten dan mudah dikelola.

Implementasi yang dilakukan:
- Menambahkan warna utama aplikasi seperti BACKGROUND, CARD_BACKGROUND, TEXT_COLOR, dan GOLD.
- Menambahkan warna kartu berdasarkan role karakter (WARRIOR, MAGE, ARCHER, dan HEALER).
- Menambahkan font TITLE_FONT, NAME_FONT, BODY_FONT, dan MONO_FONT.
- Menambahkan border untuk kartu karakter dan panel utama.
- Membuat method `colorFor()` untuk menentukan warna kartu berdasarkan role.
- Membuat method `borderFor()` untuk menentukan border berdasarkan role.

### B. Implementasi MainWindow v0.4

MainWindow menggunakan AppTheme untuk mengatur warna, font, dan border sehingga pengaturan tampilan tidak ditulis berulang kali di dalam MainWindow.

Fitur yang diterapkan:
1. Kartu karakter memiliki warna sesuai role.
2. Level karakter 5 ke atas ditampilkan dengan teks berwarna emas dan tebal.
3. Statistik menampilkan total karakter dan rata-rata level.
4. Tampilan menggunakan `setOpaque(true)` agar warna komponen terlihat dengan benar.
5. Ukuran jendela disesuaikan menggunakan `pack()`.

**Mini-Challenge:**
- Konstanta batas level menggunakan `GOLD_LEVEL_THRESHOLD = 5`.
- Karakter dengan level minimal 5 mendapatkan teks emas dan tebal.

### C. Penambahan Karakter

Aplikasi memiliki 6 karakter dengan variasi role dan level sebagai berikut:

| Nama | Role | Level |
|---|---|---:|
| Arjuna | WARRIOR | 5 |
| Merlin | MAGE | 3 |
| Athena | ARCHER | 4 |
| Hercules | WARRIOR | 7 |
| Luna | HEALER | 6 |
| Orion | ARCHER | 2 |

**Statistik aplikasi:**
- Total karakter: 6
- Rata-rata level: 4,5

### D. Properti Tambahan

Dua properti tambahan yang diterapkan pada aplikasi:

**1. Tooltip HP dan Attack Power**

Tooltip memberikan informasi tambahan mengenai karakter, seperti nama, role, HP, dan Attack Power ketika pengguna mengarahkan kursor ke kartu karakter. Properti ini membantu pengguna memperoleh informasi tanpa memenuhi tampilan utama aplikasi.

**2. Border Berbeda Berdasarkan Role**

Setiap kartu karakter memiliki warna border yang berbeda sesuai role. Tujuannya adalah mempermudah pengguna membedakan kategori karakter dan membuat tampilan aplikasi lebih informatif.

### E. Screenshot Perbandingan

**1. Sebelum — MainWindow v0.3**

Tampilan aplikasi sebelum penerapan AppTheme.

**2. Sesudah — MainWindow v0.4**

Tampilan aplikasi setelah penerapan AppTheme, warna berdasarkan role, dan Mini-Challenge level emas.

### F. Analisis Konseptual MVC

Warna dan pengaturan tampilan disimpan di dalam `AppTheme` karena pengaturan tersebut merupakan bagian dari tanggung jawab layer View. Class `Character` seharusnya hanya menyimpan dan mengelola data serta perilaku karakter, bukan mengatur bagaimana karakter ditampilkan. Dengan memisahkan tampilan dari Model, kode menjadi lebih terstruktur dan mudah dipelihara. Selain itu, perubahan desain aplikasi dapat dilakukan tanpa harus mengubah logika pada package Model.

### G. Analisis Perubahan Package Model

Package `model` dipertahankan seperti pada Sprint #3. Tidak ada perubahan yang dilakukan pada package Model untuk implementasi tema TP10.

Pemeriksaan perubahan dilakukan menggunakan perintah:

```bash
git diff -- src/com/unpri/charactermanager/model/
```

Hasil pemeriksaan digunakan untuk memastikan tidak ada perubahan pada file Model dibandingkan versi Sprint #3.

### H. Google Docs — Bagian D

Link Google Docs: https://1drv.ms/w/c/711877E32029CA45/IQATJ1L9Sk71RJ08X56HP-_pAZVtmInJs3_DcKY6pZhvxqU?e=28qSEB


