import java.util.Scanner;

// Class untuk menyimpan kredensial Admin anggap sj seperti database
class Admin {
    private final String username = "Admin";
    private final String password = "Admin";

    public boolean validateLogin(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}

// Class untuk menyimpan data Mahasiswa anggap sj seperti database
class Mahasiswa {
    private final String nama = "Nanda";
    private final String nim = "202410370110191";

    public boolean validateLogin(String inputNama, String inputNim) {
        return nama.equals(inputNama) && nim.equals(inputNim);
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }
}

// Class untuk mengelola sistem login
class LoginSystem {
    private final Scanner scanner;
    private final Admin admin;
    private final Mahasiswa mahasiswa;

    public LoginSystem() {
        scanner = new Scanner(System.in);
        admin = new Admin();
        mahasiswa = new Mahasiswa();
    }

    public void start() {
        while (true) {
            displayMenu();
            int pilihan = getUserChoice();

            switch (pilihan) {
                case 1:
                    handleAdminLogin();
                    return;
                case 2:
                    handleMahasiswaLogin();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    return;
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nSistem Login");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih jenis login (1/2): ");
    }

    private int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void handleAdminLogin() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (admin.validateLogin(username, password)) {
            System.out.println("Login Admin berhasil!");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }

    private void handleMahasiswaLogin() {
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();

        if (mahasiswa.validateLogin(nama, nim)) {
            System.out.println("Login Mahasiswa berhasil!");
            System.out.println("Nama: " + mahasiswa.getNama());
            System.out.println("NIM: " + mahasiswa.getNim());
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}

// Class utama
public class SistemLoginApp {
    public static void main(String[] args) {
        LoginSystem loginSystem = new LoginSystem();
        try {
            loginSystem.start();
        } finally {
            loginSystem.closeScanner();
        }
    }
}