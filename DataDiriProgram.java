import java.util.Scanner;
import java.time.LocalDate;

// Class untuk menyimpan data pengguna
class Pengguna {
    private String nama;
    private String jenisKelamin;
    private int tahunLahir;
    private int umur;

    // Constructor yang mengambil 3 parameter
    // nama dan tahun lahir ke instansi variable
    public Pengguna(String nama, String jenisKelamin, int tahunLahir) {
        this.nama = nama;
        this.jenisKelamin = formatJenisKelamin(jenisKelamin);
        this.tahunLahir = tahunLahir;
        hitungUmur();
    }

    // Method
    private String formatJenisKelamin(String input) {
        if (input.equalsIgnoreCase("L")) {
            return "Laki-laki";
        } else if (input.equalsIgnoreCase("P")) {
            return "Perempuan";
        }
        return "Tidak Valid";
    }

    // Method untuk menghitung umur (instansi)
    private void hitungUmur() {
        int tahunSekarang = LocalDate.now().getYear();
        this.umur = tahunSekarang - this.tahunLahir;
    }

    // Getter methods untuk mengenkapsulate agar data tidak bisa diubah/pengelolaan data
    public String getNama() {
        return nama;
        //getnama() untuk return nama
    }

    public String getJenisKelamin() {
        return jenisKelamin;
        //getJenisKelamin() untuk return jenis kelamin/gender
    }

    public int getUmur() {
        return umur;
        //getUmur() untuk return umur
    }

    // Method untuk menampilkan data
    public void tampilkanData() {
        System.out.println("\nData Pengguna:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Umur: " + umur + " tahun");
    }
}

// Class utama program DataDiriProgram
public class DataDiriProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input nama
            System.out.print("Masukkan nama: ");
            String nama = scanner.nextLine();

            // Input dan validasi jenis kelamin
            String jenisKelamin;
            do {
                System.out.print("Masukkan jenis kelamin (L/P): ");
                jenisKelamin = scanner.nextLine();
                if (!jenisKelamin.equalsIgnoreCase("L") && !jenisKelamin.equalsIgnoreCase("P")) {
                    System.out.println("Error: Masukkan L atau P saja!");
                }
            } while (!jenisKelamin.equalsIgnoreCase("L") && !jenisKelamin.equalsIgnoreCase("P"));

            // Input dan validasi tahun lahir
            int tahunLahir;
            int tahunSekarang = LocalDate.now().getYear();
            do {
                System.out.print("Masukkan tahun lahir: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Error: Masukkan angka yang valid!");
                    System.out.print("Masukkan tahun lahir: ");
                    scanner.next();
                }
                tahunLahir = scanner.nextInt();
                if (tahunLahir > tahunSekarang || tahunLahir < 1900) {
                    System.out.println("Error: Tahun lahir tidak valid!");
                }
            } while (tahunLahir > tahunSekarang || tahunLahir < 1900);

            // Membuat objek Pengguna dan menampilkan data
            Pengguna pengguna = new Pengguna(nama, jenisKelamin, tahunLahir);
            pengguna.tampilkanData();

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}