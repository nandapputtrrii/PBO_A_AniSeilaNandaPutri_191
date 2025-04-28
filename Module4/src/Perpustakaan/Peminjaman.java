package perpustakaan;

public interface Peminjaman {
    void pinjamBuku(String judul);
    void pinjamBuku(String judul, int durasi); // Method overloading
    void kembalikanBuku(String judul);
}