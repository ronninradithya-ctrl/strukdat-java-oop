import java.util.*;

class User {
    String userId;
    String nama;
    String email;
    String noTelepon;
    String alamat;
    String tipeUser;

    public void register() {
        System.out.println(nama + " berhasil register");
    }

    public void login() {
        System.out.println(nama + " login");
    }

    public void updateProfil() {
        System.out.println("Profil diperbarui");
    }
}

class Admin extends User {
    Date tanggalDibuat;

    public void kelolaPengguna() {
        System.out.println("Mengelola pengguna");
    }

    public void kelolaPemesanan() {
        System.out.println("Mengelola pemesanan");
    }

    public void lihatLaporan() {
        System.out.println("Melihat laporan");
    }
}

class Pelanggan extends User {
    List<Pemesanan> riwayatBooking = new ArrayList<>();
    double saldoDompetDigital;

    public void buatBooking(Pemesanan p) {
        riwayatBooking.add(p);
        System.out.println("Booking dibuat");
    }

    public void lihatKetersediaan() {
        System.out.println("Melihat ketersediaan lapangan");
    }

    public void pembayaran() {
        System.out.println("Melakukan pembayaran");
    }

    public void batalkanBooking() {
        System.out.println("Booking dibatalkan");
    }
}

class Lapangan {
    String lapanganId;
    String nama;
    String lokasi;
    double hargaPerJam;
    List<String> fasilitas;
    String status;

    public void tambahLapangan() {
        System.out.println("Lapangan ditambahkan");
    }

    public void updateHarga() {
        System.out.println("Harga diperbarui");
    }

    public void lihatKetersediaan() {
        System.out.println("Cek ketersediaan lapangan");
    }
}

class Jadwal {
    String jadwalId;
    Lapangan lapangan;
    Date tanggal;
    String jamMulai;
    String jamSelesai;
    String status;

    public void cekKetersediaan() {
        System.out.println("Cek jadwal tersedia");
    }

    public void updateStatus() {
        System.out.println("Status jadwal diperbarui");
    }
}

class Pemesanan {
    String pemesananId;
    Pelanggan pelanggan;
    Lapangan lapangan;
    Jadwal jadwal;
    Date tanggalPemesanan;
    double totalHarga;
    String status;

    public void buatPemesanan() {
        System.out.println("Pemesanan dibuat");
    }

    public void konfirmasiPemesanan() {
        status = "Dikonfirmasi";
        System.out.println("Pemesanan dikonfirmasi");
    }

    public void batalkanPemesanan() {
        status = "Dibatalkan";
        System.out.println("Pemesanan dibatalkan");
    }
}

class Pembayaran {
    String pembayaranId;
    Pemesanan pemesanan;
    double jumlah;
    String metodePembayaran;
    String statusPembayaran;
    Date tanggalPembayaran;

    public void prosesPembayaran() {
        statusPembayaran = "Berhasil";
        System.out.println("Pembayaran diproses");
    }

    public void verifikasiPembayaran() {
        System.out.println("Pembayaran diverifikasi");
    }

    public void buatInvoice() {
        System.out.println("Invoice dibuat");
    }
}

class Review {
    String reviewId;
    Pemesanan pemesanan;
    int rating;
    String komentar;
    Date tanggalReview;

    public void buatReview() {
        System.out.println("Review dibuat");
    }

    public void updateReview() {
        System.out.println("Review diperbarui");
    }
}

class Notifikasi {
    String notifikasiId;
    User pengguna;
    String pesan;
    String tipe;
    Date tanggalDikirim;
    boolean statusBaca;

    public void kirimNotifikasi() {
        System.out.println("Notifikasi dikirim ke " + pengguna.nama);
    }

    public void tandaiSudahDibaca() {
        statusBaca = true;
        System.out.println("Notifikasi dibaca");
    }
}

public class App {
    public static void main(String[] args) {

        Pelanggan pelanggan = new Pelanggan();
        pelanggan.nama = "Ronnin";

        Lapangan lapangan = new Lapangan();
        lapangan.nama = "Lapangan Futsal A";

        Jadwal jadwal = new Jadwal();
        jadwal.lapangan = lapangan;

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
        review.pemesanan = pemesanan;
        review.rating = 5;
        review.komentar = "Bagus banget!";
        review.buatReview();
    }
}