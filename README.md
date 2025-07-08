# 💻 Aplikasi Kasir Java Dekstop

Aplikasi Kasir Sederhana berbasis Java Dekstop dengan database SQLite. Aplikasi ini dirancang untuk membantu pengguna dalam mengelola data barang dan transaksi secara offline secara efisien dan praktis.

## 🚀 Fitur Utama

- CRUD Data Barang (Tambah, Ubah, Hapus)
- Transaksi pembelian barang
- Stok otomatis berkurang saat transaksi
- Sistem login dan logout
- Format harga dalam Rupiah
- Perhitungan total belanja otomatis
- Tampilan tabel yang responsif saat window diubah ukurannya

## 🛠️ Teknologi yang Digunakan

- Java (Swing)
- SQLite (JDBC)
- NetBeans IDE

## 🔐 Informasi Login

Gunakan akun berikut untuk masuk ke aplikasi:

- **Username:** `admin`  
- **Password:** `1234`

> Username dan password dapat diubah langsung melalui database sesuai kebutuhan.

## ⚙️ Petunjuk Penggunaan

1. Buka proyek di NetBeans.
2. Tambahkan library JDBC untuk SQLite jika belum ada. "https://drive.google.com/file/d/1xEfUdMI4q_H8LnDunEXS_R3dHmj7YDO8/view?usp=sharing"
3. Jalankan file `Main.java` untuk memulai aplikasi.
4. Login menggunakan akun di atas, lalu mulai tambah barang dan lakukan transaksi.

## 🧑‍💻 Pendekatan OOP (Object-Oriented Programming)

Aplikasi ini dibangun menggunakan pendekatan **Pemrograman Berorientasi Objek (OOP)**, dengan struktur kode sebagai berikut:

- `Barang` sebagai class model yang mewakili data barang.
- `BarangDAO` sebagai class yang menangani akses database (DAO: Data Access Object).
- `Login`, `Transaksi`, dan form lainnya dibangun sebagai class GUI yang modular.
- Menerapkan prinsip **enkapsulasi**, pemisahan tanggung jawab, dan modularitas.
- Struktur ini membuat aplikasi lebih mudah dirawat, dikembangkan, dan diperluas di masa depan.

## 📘 Keterangan

Proyek ini dibuat untuk **memenuhi tugas Ujian Akhir Semester (UAS)** mata kuliah **Pemrograman Lanjut**.

## 👤 Developer

- Abdul Kader  
- Universitas Merdeka Malang  
- NIM: 24083000015  
- Kelas: 2A
