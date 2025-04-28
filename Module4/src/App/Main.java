import perpustakaan.Fiksi;
import perpustakaan.NonFiksi;
import perpustakaan.Buku;
import perpustakaan.Anggota;

public class Main {
    public static void main(String[] args) {
        // Membuat objek buku
        perpustakaan.Fiksi bukuFiksi = new perpustakaan.Fiksi("Harry Potter", "J.K. Rowling", "Fantasi");
        perpustakaan.NonFiksi bukuNonFiksi = new perpustakaan.NonFiksi("Atomic Habits", "James Clear", "Pengembangan Diri");

        // Membuat objek anggota
        perpustakaan.Anggota anggota1 = new perpustakaan.Anggota("Amalia", "A038");
        perpustakaan.Anggota anggota2 = new perpustakaan.Anggota("Nanda", "A191");

        // Menampilkan informasi buku
        System.out.println("=== Informasi Buku ===");
        bukuFiksi.displayInfo();
        System.out.println();
        bukuNonFiksi.displayInfo();
        System.out.println();

        // Demonstrasi peminjaman dan pengembalian buku
        System.out.println("=== Peminjaman dan Pengembalian ===");
        anggota1.pinjamBuku("Harry Potter");
        anggota2.pinjamBuku("Atomic Habits", 7);
        System.out.println();

        anggota1.kembalikanBuku("Harry Potter");
        anggota2.kembalikanBuku("Atomic Habits");
    }
}