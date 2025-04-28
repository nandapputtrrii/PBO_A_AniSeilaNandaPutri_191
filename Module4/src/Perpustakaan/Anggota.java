package perpustakaan;

import perpustakaan.Peminjaman;

public class Anggota implements Peminjaman {
    private String nama;
    private String idAnggota;

    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }

    @Override
    public void pinjamBuku(String judul) {
        System.out.println(nama + " (ID: " + idAnggota + ") meminjam buku \"" + judul + "\"");
    }

    @Override
    public void pinjamBuku(String judul, int durasi) {
        System.out.println(nama + " (ID: " + idAnggota + ") meminjam buku \"" + judul +
                "\" selama " + durasi + " hari");
    }

    @Override
    public void kembalikanBuku(String judul) {
        System.out.println(nama + " (ID: " + idAnggota + ") mengembalikan buku \"" + judul + "\"");
    }

    // Getter dan setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(String idAnggota) {
        this.idAnggota = idAnggota;
    }
}