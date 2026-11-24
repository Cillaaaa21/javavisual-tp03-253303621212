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

## TP12 — Layout, UI Responsif & Analisis MVC

### A. Implementasi Layout

Pada TP12, aplikasi Character Manager dikembangkan menggunakan `BorderLayout` dengan empat wilayah utama, yaitu:

- **NORTH:** Header aplikasi yang berisi judul Character Manager dan panel statistik.
- **CENTER:** Daftar karakter yang ditampilkan dalam `JScrollPane`.
- **EAST:** Panel legenda role yang menggunakan `BoxLayout` dengan orientasi `Y_AXIS`.
- **SOUTH:** Status bar yang menampilkan informasi aplikasi di sebelah kiri dan versi `v0.5` di sebelah kanan.

Daftar karakter menggunakan `GridLayout` dengan dua kolom. Setiap karakter ditampilkan dalam kartu yang memiliki warna berbeda berdasarkan role masing-masing.

Legenda dibuat secara dinamis menggunakan `CharacterType.values()` sehingga seluruh jenis karakter dapat ditampilkan secara otomatis.

### B. Wireframe Aplikasi

```text
+------------------------------------------------------+
|                    NORTH                             |
|              CHARACTER MANAGER                       |
|------------------------------------------------------|
| Total Karakter | Rata-rata Level                     |
| Level Tertinggi| Jumlah Role                          |
+-----------------------------------------+------------+
|                  CENTER                 |    EAST    |
|                                         |            |
| +----------------+ +----------------+   |  LEGENDA   |
| | Arjuna         | | Merlin         |   |            |
| | Warrior        | | Mage           |   |  Warrior   |
| | Level: 5       | | Level: 3       |   |  Mage      |
| +----------------+ +----------------+   |  Archer    |
|                                         |  Healer    |
| +----------------+ +----------------+   |            |
| | Athena         | | Luna           |   |            |
| | Archer         | | Healer         |   |            |
| +----------------+ +----------------+   |            |
|                                         |            |
|              JScrollPane                |            |
+-----------------------------------------+------------+
|                  SOUTH                               |
| Character Manager siap digunakan             v0.5    |
+------------------------------------------------------+
```

### C. Screenshot Pengujian Responsif

**1. Ukuran Awal**

Pada ukuran awal, seluruh komponen aplikasi dapat terlihat dengan baik, termasuk header, statistik, daftar karakter, legenda role, dan status bar.

**2. Jendela Diperlebar**

Ketika ukuran jendela diperlebar, kartu karakter menyesuaikan ukuran area yang tersedia. Panel legenda tetap berada di sebelah kanan dan susunan komponen tetap rapi.

**3. Jendela Diperkecil**

Ketika ukuran jendela diperkecil, area daftar karakter menjadi lebih sempit. JScrollPane menampilkan scrollbar sehingga pengguna tetap dapat melihat seluruh daftar karakter.

### D. Tabel Pengamatan Resize

| Kondisi | Prediksi | Hasil Pengamatan |
|---|---|---|
| Ukuran awal | Semua komponen terlihat | Sesuai |
| Jendela diperlebar | Kartu karakter melebar mengikuti area | Sesuai |
| Jendela diperkecil | Scrollbar membantu melihat daftar karakter | Sesuai |

Berdasarkan pengujian, aplikasi dapat menyesuaikan tampilan ketika ukuran jendela berubah tanpa membuat komponen saling bertumpuk.

### E. Struktur Panel Bersarang

Aplikasi menggunakan `JPanel` utama dengan `BorderLayout` sebagai wadah untuk empat wilayah utama. Pada bagian NORTH, terdapat `headerPanel` yang menggunakan `BorderLayout` untuk menempatkan judul dan panel statistik. Pada bagian CENTER, `characterPanel` menampung kartu-kartu karakter dan ditempatkan di dalam `listWrapper` yang kemudian dimasukkan ke `JScrollPane`. Sementara itu, panel legenda menggunakan `BoxLayout` dan status bar menggunakan `BorderLayout` agar informasi dapat ditempatkan di kiri dan kanan.

### F. Alasan Pemilihan Layout Panel Tambahan

Panel tambahan yang digunakan adalah panel statistik dengan `GridLayout(2, 2, 10, 8)`.

Layout GridLayout dipilih karena dapat menyusun empat informasi statistik dalam dua baris dan dua kolom dengan ukuran sel yang seragam. Susunan ini membuat informasi total karakter, rata-rata level, level tertinggi, dan jumlah role terlihat teratur.

Layout yang ditolak adalah FlowLayout karena susunan komponennya mengikuti ukuran dan ruang yang tersedia secara berurutan. Untuk empat informasi statistik, GridLayout lebih sesuai karena menghasilkan susunan dua baris dan dua kolom yang konsisten.

### G. Bukti Package Model Tidak Berubah

Package `model` dipertahankan tanpa perubahan pada TP12.

Pemeriksaan dilakukan menggunakan perintah Git berikut:

```bash
git diff HEAD -- ":(glob)**/model/**"
```

Jika tidak terdapat output, berarti tidak ada perubahan pada file model yang dilacak dibandingkan commit HEAD.

### H. Teknologi yang Digunakan

- Java
- Java Swing
- BorderLayout
- GridLayout
- BoxLayout
- JScrollPane
- MVC (Model-View-Controller)
- Git dan GitHub

### I. Google Docs — Bagian D

Link Google Docs: https://1drv.ms/w/c/711877E32029CA45/IQCTH9rbrNDzTp17jIv03gjZAWFmaSafYl9qQevJ--gGLkI?e=hRLDbY

# Character Manager

Aplikasi Character Manager merupakan aplikasi berbasis Java Swing yang digunakan untuk mengelola data karakter, seperti nama, role, level, HP, dan attack power. Aplikasi ini dikembangkan dengan menerapkan konsep Object-Oriented Programming (OOP) dan pola arsitektur Model-View-Controller (MVC).

## TP14 — Validasi Form dan Analisis MVC

### A. Deskripsi

Pada TP14, aplikasi Character Manager dikembangkan dengan menambahkan sistem validasi pada form input karakter. Validasi bertujuan untuk memastikan data yang dimasukkan pengguna sesuai dengan aturan sebelum karakter ditambahkan ke dalam aplikasi.

Validasi diterapkan pada dua bagian, yaitu View dan Model. View bertugas memeriksa input pengguna serta menampilkan pesan kesalahan, sedangkan Model bertugas memastikan data karakter memenuhi aturan yang telah ditentukan.

### B. Implementasi Validasi

Aturan validasi yang diterapkan pada aplikasi Character Manager adalah:

1. Nama karakter tidak boleh kosong.
2. Nama karakter harus memiliki panjang 3–20 karakter.
3. Nama karakter hanya boleh berisi huruf dan spasi.
4. Nama karakter tidak boleh sama dengan karakter yang sudah terdaftar.
5. Level karakter harus berada pada rentang 1–99.
6. Karakter dengan role MAGE memiliki level maksimal 60.

Validasi pada View dilakukan sebelum data dikirim ke Model. Jika input tidak sesuai, aplikasi menampilkan pesan kesalahan dan memberikan tanda border merah pada kolom nama. Pada Model, validasi dilakukan menggunakan `IllegalArgumentException` untuk menolak data yang tidak memenuhi ketentuan.

### C. Dokumentasi Pengujian

Berikut merupakan dokumentasi hasil pengujian validasi pada aplikasi Character Manager.

#### 1. Pengujian Nama Kosong

**Hasil:** Ketika pengguna mencoba menyimpan karakter tanpa mengisi nama, aplikasi menampilkan pesan "Nama wajib diisi!". Data karakter tidak berhasil ditambahkan.

#### 2. Pengujian Nama Duplikat

**Hasil:** Ketika pengguna memasukkan nama karakter yang sudah terdaftar, aplikasi menampilkan pesan "Nama sudah dipakai!". Sistem menolak penambahan karakter dengan nama yang sama.

#### 3. Pengujian Berhasil Menambahkan Karakter Baru

**Hasil:** Pengguna berhasil menambahkan karakter baru bernama Kagura dengan role MAGE dan level 5. Kartu Kagura muncul pada daftar karakter dan jumlah karakter bertambah dari 8 menjadi 9.

### D. Tabel Pengujian Validasi

| No. | Skenario Pengujian | Hasil yang Diharapkan | Hasil Aktual |
|---|---|---|---|
| 1 | Nama dikosongkan | Muncul pesan nama wajib diisi | Berhasil, pesan kesalahan ditampilkan |
| 2 | Memasukkan nama duplikat (Arjuna) | Muncul pesan nama sudah dipakai | Berhasil, nama duplikat ditolak |
| 3 | Memasukkan nama terlalu pendek (Al) | Muncul pesan nama harus 3–20 karakter | Berhasil, nama ditolak |
| 4 | Memasukkan nama dengan angka (Arjuna123) | Muncul pesan nama hanya boleh berisi huruf dan spasi | Berhasil, format nama ditolak |
| 5 | Memasukkan nama valid (Kagura) | Karakter berhasil ditambahkan | Berhasil, kartu Kagura ditambahkan |
| 6 | Memasukkan nama lebih dari 20 karakter | Model menolak nama tersebut | Validasi Model menolak nama yang melebihi 20 karakter |
| 7 | Memasukkan MAGE dengan level 61 | Model menolak level tersebut | Validasi Model menolak level MAGE di atas 60 |
| 8 | Memasukkan level di luar rentang 1–99 | Model menolak level tersebut | Validasi Model menolak level di luar rentang 1–99 |

**Catatan:** Hasil pengujian menunjukkan bahwa validasi pada View memberikan umpan balik terhadap input yang tidak sesuai, sedangkan Model bertugas menjaga agar data yang disimpan tetap memenuhi aturan. Aturan pada nomor 6–8 diterapkan melalui validasi Model.

### E. Analisis Kompromi Sementara MVC

Pada TP14, penggunaan `ActionListener` masih dibuat secara minimal untuk menangani aksi tombol penyimpanan karakter. Pemanggilan `CharacterManager` juga masih dilakukan secara langsung dari komponen View melalui mekanisme yang digunakan saat ini. Pendekatan ini dipilih agar proses validasi dan penambahan karakter dapat berjalan tanpa mengubah terlalu banyak struktur program yang sudah ada. Pada pengembangan berikutnya, pemisahan tanggung jawab antara View, Controller, dan Model diharapkan dapat dibuat lebih baik agar penerapan pola MVC menjadi lebih terstruktur.

### F. Dokumentasi Analisis Bagian D

Dokumentasi analisis TP14 dibuat dalam Google Docs dan berisi pembahasan mengenai validasi input, validasi dua lapisan, penggunaan `IllegalArgumentException`, kualitas umpan balik kepada pengguna, serta penerapan pola MVC.

**Link Google Docs:** https://1drv.ms/w/c/711877E32029CA45/IQCUjvfrJnshTK-Ax2XfQdn8AePfv5SYYXf_cx7dnlWDMvg?e=9wOdLc



