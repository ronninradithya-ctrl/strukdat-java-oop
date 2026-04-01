# Aplikasi Booking Lapangan Futsal

## Deskripsi Kasus

Aplikasi ini merupakan sistem sederhana berbasis Java yang digunakan untuk melakukan pemesanan (booking) lapangan futsal. Sistem ini memungkinkan pengguna (pelanggan) untuk memilih lapangan, menentukan jadwal bermain, melakukan konfirmasi pemesanan, dan menyelesaikan pembayaran.

Aplikasi dibuat menggunakan konsep Object-Oriented Programming (OOP) untuk merepresentasikan entitas dunia nyata seperti pengguna, lapangan, jadwal, dan pemesanan.

Fitur utama:

* Input data pelanggan
* Pemilihan lapangan
* Penentuan jadwal bermain
* Konfirmasi booking
* Proses pembayaran sederhana

---

## Class Diagram

Berikut adalah representasi class diagram:

<img width="5644" height="8191" alt="Futsal Booking System Model-2026-04-01-065044" src="https://github.com/user-attachments/assets/401f5472-7d76-4c44-b43d-0d6b3c786e61" />


---

## Kode Program Java

```java
import java.util.*;

class User {
    String nama;

    public void login() {
        System.out.println("\nSelamat datang, " + nama + "!");
    }
}

class Pelanggan extends User {
    List<Pemesanan> riwayatBooking = new ArrayList<>();

    public void buatBooking(Pemesanan p) {
        riwayatBooking.add(p);
        System.out.println("\nBooking berhasil dibuat!");
    }
}

class Lapangan {
    String nama;
    double hargaPerJam;

    public Lapangan(String nama, double hargaPerJam) {
        this.nama = nama;
        this.hargaPerJam = hargaPerJam;
    }
}

class Jadwal {
    String jamMulai;
    String jamSelesai;
}

class Pemesanan {
    Pelanggan pelanggan;
    Lapangan lapangan;
    Jadwal jadwal;
    String status;

    public void tampilDetail() {
        System.out.println("\n=== DETAIL PEMESANAN ===");
        System.out.println("Nama: " + pelanggan.nama);
        System.out.println("Lapangan: " + lapangan.nama);
        System.out.println("Waktu: " + jadwal.jamMulai + " - " + jadwal.jamSelesai);
        System.out.println("Harga/jam: Rp " + lapangan.hargaPerJam);
    }

    public void konfirmasi() {
        status = "Dikonfirmasi";
        System.out.println("Status: " + status);
    }
}

class Pembayaran {
    public void bayar() {
        System.out.println("\nPembayaran berhasil!");
    }
}

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== SISTEM BOOKING FUTSAL ===");

        System.out.print("Masukkan nama anda: ");
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.nama = input.nextLine();
        pelanggan.login();

        Lapangan l1 = new Lapangan("Lapangan A", 100000);
        Lapangan l2 = new Lapangan("Lapangan B", 120000);

        System.out.println("\nPilih Lapangan:");
        System.out.println("1. " + l1.nama + " (Rp " + l1.hargaPerJam + ")");
        System.out.println("2. " + l2.nama + " (Rp " + l2.hargaPerJam + ")");
        System.out.print("Pilihan (1/2): ");
        int pilihLap = input.nextInt();

        Lapangan lapanganDipilih = (pilihLap == 1) ? l1 : l2;

        input.nextLine();

        Jadwal jadwal = new Jadwal();
        System.out.print("\nMasukkan jam mulai (contoh 10:00): ");
        jadwal.jamMulai = input.nextLine();
        System.out.print("Masukkan jam selesai (contoh 12:00): ");
        jadwal.jamSelesai = input.nextLine();

        Pemesanan p = new Pemesanan();
        p.pelanggan = pelanggan;
        p.lapangan = lapanganDipilih;
        p.jadwal = jadwal;

        p.tampilDetail();

        System.out.print("\nKonfirmasi booking? (y/n): ");
        String konfirmasi = input.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            pelanggan.buatBooking(p);
            p.konfirmasi();

            Pembayaran bayar = new Pembayaran();
            bayar.bayar();

            System.out.println("\nBooking selesai. Terima kasih!");
        } else {
            System.out.println("\nBooking dibatalkan.");
        }

        input.close();
    }
}
```

---

## Screenshot Output

Contoh hasil saat program dijalankan:

```
=== SISTEM BOOKING FUTSAL ===
Masukkan nama anda: Ronnin

Selamat datang, Ronnin!

Pilih Lapangan:
1. Lapangan A (Rp 100000.0)
2. Lapangan B (Rp 120000.0)
Pilihan (1/2): 1

Masukkan jam mulai (contoh 10:00): 10:00
Masukkan jam selesai (contoh 12:00): 12:00

=== DETAIL PEMESANAN ===
Nama: Ronnin
Lapangan: Lapangan A
Waktu: 10:00 - 12:00
Harga/jam: Rp 100000.0

Konfirmasi booking? (y/n): y

Booking berhasil dibuat!
Status: Dikonfirmasi

Pembayaran berhasil!

Booking selesai. Terima kasih!
```

---

## Prinsip OOP yang Diterapkan

1. Inheritance
   Class Pelanggan mewarisi class User menggunakan keyword `extends`, sehingga atribut dan method yang sama tidak perlu ditulis ulang.

2. Encapsulation
   Data dan method dibungkus dalam masing-masing class, seperti Pemesanan yang memiliki atribut dan method sendiri.

3. Abstraction
   Setiap class merepresentasikan objek nyata seperti Lapangan, Jadwal, dan Pemesanan, sehingga sistem lebih mudah dipahami.

4. Association
   Terdapat hubungan antar objek, misalnya Pemesanan berhubungan dengan Pelanggan, Lapangan, dan Jadwal.

---

## Keunikan / Pembeda

* Menggunakan sistem input interaktif berbasis terminal sehingga pengguna dapat langsung melakukan simulasi booking
* Alur program mencerminkan proses nyata: login → pilih lapangan → pilih jadwal → konfirmasi → pembayaran
* Struktur class sederhana namun tetap menerapkan konsep OOP secara lengkap
* Mudah dikembangkan menjadi sistem yang lebih kompleks seperti berbasis GUI atau web

---
