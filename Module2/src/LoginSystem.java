import java.util.Scanner;

public class LoginSystem {

    // kelas Admin
    public static class Admin {
        private String username;
        private String password;

        // konstruktor untuk inisialisasi username dan password admin
        public Admin(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // metode untuk memverifikasi kredensial login
        public boolean login(String inputUsername, String inputPassword) {
            if (this.username.equals(inputUsername) && this.password.equals(inputPassword)) {
                return true;  // login berhasil
            } else {
                System.out.println("username atau password salah untuk Admin.");
                return false;  // login gagal
            }
        }
    }

    // kelas Student
    public static class Student {
        private String name;
        private String studentID;

        // konstruktor untuk inisialisasi nama dan student ID mahasiswa
        public Student(String name, String studentID) {
            this.name = name;
            this.studentID = studentID;
        }

        // metode untuk memverifikasi login siswa
        public boolean login(String inputName, String inputStudentID) {
            if (this.name.equals(inputName) && this.studentID.equals(inputStudentID)) {
                return true;  // login berhasil
            } else {
                System.out.println("nama atau student ID salah untuk Mahasiswa.");
                return false;  // login gagal
            }
        }

        // metode untuk menampilkan informasi mahasiswa
        public void displayInfo() {
            System.out.println("Informasi Siswa:");
            System.out.println("Nama: " + name);
            System.out.println("Student ID: " + studentID);
        }
    }

    // kelas utama untuk menjalankan sistem login (LoginSystem)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // membuat objek Admin dan Student dengan data contoh
        Admin admin = new Admin("Admin", "Admin");  // contoh kredensial admin
        Student student = new Student("Nanda", "202410370110191"); // contoh kredensial mahasiswa

        // menampilkan menu untuk memilih jenis login
        System.out.println("Selamat datang di Sistem Login");
        System.out.println("Pilih jenis login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");

        // mendapatkan pilihan pengguna
        int choice = scanner.nextInt();
        scanner.nextLine(); // mengonsumsi karakter newline setelah membaca integer

        if (choice == 1) {
            // proses login Admin
            System.out.println("Login Admin");
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            // memverifikasi login admin
            if (admin.login(username, password)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Username atau password salah.");
            }

        } else if (choice == 2) {
            // proses login Siswa
            System.out.println("Login Mahasiswa");
            System.out.print("Masukkan nama: ");
            String name = scanner.nextLine();
            System.out.print("Masukkan student ID: ");
            String studentID = scanner.nextLine();

            // memverifikasi login mahasiswa
            if (student.login(name, studentID)) {
                System.out.println("Login Mahasiswa berhasil!");
                student.displayInfo();  // menampilkan informasi siswa
            } else {
                System.out.println("Nama atau student ID salah.");
            }

        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();  // menutup scanner
    }
}