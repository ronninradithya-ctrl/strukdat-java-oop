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

<img width="1093" height="1660" alt="mermaid-diagram (1)" src="https://github.com/user-attachments/assets/fb91dcd4-cd95-4533-a153-ee2f2b2f8872" />


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
    double totalHarga;

    public void hitungTotal() {
        totalHarga = lapangan.hargaPerJam * 2; // misal 2 jam
    }

    public void tampilDetail() {
        hitungTotal();
        System.out.println("\n=== DETAIL PEMESANAN ===");
        System.out.println("Nama: " + pelanggan.nama);
        System.out.println("Lapangan: " + lapangan.nama);
        System.out.println("Waktu: " + jadwal.jamMulai + " - " + jadwal.jamSelesai);
        System.out.println("Total Harga: Rp " + totalHarga);
    }

    public void konfirmasi() {
        status = "Dikonfirmasi";
        System.out.println("Status: " + status);
    }
}

class Pembayaran {
    Pemesanan pemesanan;
    double jumlah;
    String status;

    public void proses() {
        jumlah = pemesanan.totalHarga;
        status = "Lunas";
        System.out.println("\nPembayaran sebesar Rp " + jumlah + " berhasil!");
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
        System.out.print("\nMasukkan jam mulai: ");
        jadwal.jamMulai = input.nextLine();
        System.out.print("Masukkan jam selesai: ");
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
            bayar.pemesanan = p;
            bayar.proses();

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

Masukkan jam mulai: 10:00
Masukkan jam selesai: 12:00

=== DETAIL PEMESANAN ===
Nama: Ronnin
Lapangan: Lapangan A
Waktu: 10:00 - 12:00
Total Harga: Rp 120000.0

Konfirmasi booking? (y/n): y

Booking berhasil dibuat!
Status: Dikonfirmasi

Pembayaran sebesar Rp 200000.0 berhasil!

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
