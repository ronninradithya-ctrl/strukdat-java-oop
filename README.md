# 🏟️ Aplikasi Pemesanan Lapangan Olahraga

## 📌 Deskripsi Kasus

Aplikasi ini merupakan sistem pemesanan lapangan olahraga berbasis objek yang memungkinkan pengguna (pelanggan) untuk melakukan booking lapangan sesuai jadwal yang tersedia.

Fitur utama dalam sistem ini meliputi:

* Registrasi dan login user
* Melihat ketersediaan lapangan
* Melakukan pemesanan (booking)
* Melakukan pembayaran
* Memberikan review
* Menerima notifikasi

Terdapat dua jenis user:

* **Admin** → Mengelola sistem (pengguna & pemesanan)
* **Pelanggan** → Melakukan booking dan transaksi

---

## 🧩 Class Diagram

Class diagram menggambarkan struktur sistem berbasis OOP yang terdiri dari beberapa class utama:

* User (parent class)
* Admin & Pelanggan (inheritance dari User)
* Pemesanan (core system)
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

*(Tambahkan gambar diagram kamu di sini di GitHub)*

---

## 💻 Kode Program Java

```java
import java.util.*;

// ================= USER =================
class User {
    String userId;
    String nama;
    String email;

    public void login() {
        System.out.println(nama + " login");
    }
}

// ================= ADMIN =================
class Admin extends User {
    public void kelolaPengguna() {
        System.out.println("Admin mengelola pengguna");
    }
}

// ================= PELANGGAN =================
class Pelanggan extends User {
    List<Pemesanan> riwayatBooking = new ArrayList<>();

    public void buatBooking(Pemesanan p) {
        riwayatBooking.add(p);
        System.out.println("Booking berhasil dibuat");
    }
}

// ================= LAPANGAN =================
class Lapangan {
    String nama;
    double hargaPerJam;
}

// ================= JADWAL =================
class Jadwal {
    Lapangan lapangan;
    String jamMulai;
    String jamSelesai;
}

// ================= PEMESANAN =================
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

// ================= PEMBAYARAN =================
class Pembayaran {
    Pemesanan pemesanan;

    public void prosesPembayaran() {
        System.out.println("Pembayaran berhasil");
    }
}

// ================= REVIEW =================
class Review {
    int rating;
    String komentar;

    public void buatReview() {
        System.out.println("Review ditambahkan");
    }
}

// ================= MAIN =================
public class MainApp {
    public static void main(String[] args) {

        Pelanggan pelanggan = new Pelanggan();
        pelanggan.nama = "Ronnin";

```
