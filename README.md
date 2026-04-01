# Aplikasi Pemesanan Lapangan Olahraga

## Deskripsi Kasus

Aplikasi ini merupakan sistem pemesanan lapangan olahraga berbasis objek yang memungkinkan pengguna (pelanggan) untuk melakukan booking lapangan sesuai jadwal yang tersedia.

Fitur utama dalam sistem ini meliputi:

* Registrasi dan login user
* Melihat ketersediaan lapangan
* Melakukan pemesanan (booking)
* Melakukan pembayaran
* Memberikan review
* Menerima notifikasi

Terdapat dua jenis user:

* Admin → Mengelola sistem
* Pelanggan → Melakukan booking

---

## Class Diagram

Class diagram menggambarkan struktur sistem berbasis OOP yang terdiri dari beberapa class utama:

* User (parent class)
* Admin dan Pelanggan (inheritance dari User)
* Pemesanan (inti sistem)
* Lapangan
* Jadwal
* Pembayaran
* Review
* Notifikasi

Relasi utama:

* Pelanggan melakukan Pemesanan
* Pemesanan terhubung dengan Lapangan dan Jadwal
* Pemesanan memiliki Pembayaran dan Review
* User menerima Notifikasi

(Tambahkan gambar class diagram di sini)

---

## Kode Program Java

```java
import java.util.*;

class User {
    String userId;
    String nama;
    String email;

    public void login() {
        System.out.println(nama + " login");
    }
}

class Admin extends User {
    public void kelolaPengguna() {
        System.out.println("Admin mengelola pengguna");
    }
}

class Pelanggan extends User {
    List<Pemesanan> riwayatBooking = new ArrayList<>();

    public void buatBooking(Pemesanan p) {
        riwayatBooking.add(p);
        System.out.println("Booking berhasil dibuat");
    }
}

class Lapangan {
    String nama;
    double hargaPerJam;
}

class Jadwal {
    Lapangan lapangan;
    String jamMulai;
    String jamSelesai;
}

class Pemesanan {
    Pelanggan pelanggan;
    Lapangan lapangan;
    Jadwal jadwal;
    String status;

    public void konfirmasiPemesanan() {
        status = "Dikonfirmasi";
        System.out.println("Pemesanan dikonfirmasi");
    }
}

class Pembayaran {
    Pemesanan pemesanan;

    public void prosesPembayaran() {
        System.out.println("Pembayaran berhasil");
    }
}

class Review {
    int rating;
    String komentar;

    public void buatReview() {
        System.out.println("Review ditambahkan");
    }
}

class Notifikasi {
    User pengguna;
    String pesan;

    public void kirimNotifikasi() {
        System.out.println("Notifikasi dikirim ke " + pengguna.nama);
    }
}

public class MainApp {
    public static void main(String[] args) {

        Pelanggan pelanggan = new Pelanggan();
        pelanggan.nama = "Ronnin";

        Lapangan lapangan = new Lapangan();
        lapangan.nama = "Lapangan Futsal A";

        Jadwal jadwal = new Jadwal();
        jadwal.lapangan = lapangan;
        jadwal.jamMulai = "10:00";
        jadwal.jamSelesai = "12:00";

        Pemesanan pemesanan = new Pemesanan();
        pemesanan.pelanggan = pelanggan;
        pemesanan.lapangan = lapangan;
        pemesanan.jadwal = jadwal;

        pelanggan.buatBooking(pemesanan);
        pemesanan.konfirmasiPemesanan();

        Pembayaran pembayaran = new Pembayaran();
        pembayaran.pemesanan = pemesanan;
        pembayaran.prosesPembayaran();

        Review review = new Review();
        review.rating = 5;
        review.komentar = "Sangat bagus!";
        review.buatReview();

        Notifikasi notifikasi = new Notifikasi();
        notifikasi.pengguna = pelanggan;
        notifikasi.pesan = "Booking berhasil!";
        notifikasi.kirimNotifikasi();
    }
}
```

---

## Screenshot Output

Tambahkan screenshot hasil running program di sini.

Contoh output:

```
Booking berhasil dibuat
Pemesanan dikonfirmasi
Pembayaran berhasil
Review ditambahkan
Notifikasi dikirim ke Ronnin
```

---

## Prinsip OOP yang Diterapkan

1. Inheritance
   Class Admin dan Pelanggan mewarisi class User sehingga tidak perlu mendefinisikan ulang atribut yang sama.

2. Encapsulation
   Data dan method dibungkus dalam class masing-masing, walaupun pada implementasi ini masih sederhana dan belum menggunakan access modifier seperti private.

3. Abstraction
   Setiap class merepresentasikan entitas nyata seperti Pemesanan, Pembayaran, dan Lapangan sehingga kompleksitas sistem disederhanakan dalam bentuk objek.

4. Association
   Terdapat hubungan antar objek, seperti Pemesanan yang memiliki Pelanggan, Lapangan, dan Jadwal, serta Pembayaran yang berhubungan dengan Pemesanan.

---

## Keunikan / Pembeda

Beberapa keunikan dari sistem ini dibandingkan dengan implementasi lain:

* Menggunakan struktur relasi yang cukup lengkap dengan Pemesanan sebagai pusat sistem
* Mencakup alur lengkap mulai dari booking, pembayaran, hingga review dan notifikasi
* Menggabungkan beberapa konsep OOP dalam satu sistem sederhana
* Desain mendekati implementasi sistem nyata aplikasi pemesanan lapangan olahraga

---
