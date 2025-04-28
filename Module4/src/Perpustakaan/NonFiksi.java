package perpustakaan;

import perpustakaan.Buku;

public class NonFiksi extends Buku {
    private String kategori;

    public NonFiksi(String judul, String penulis, String kategori) {
        super(judul, penulis);
        this.kategori = kategori;
    }

    @Override
    public void displayInfo() {
        System.out.println("Buku Non-Fiksi:");
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Kategori: " + kategori);
    }

    // Getter dan setter untuk kategori
    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}