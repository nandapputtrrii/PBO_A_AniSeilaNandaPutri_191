// BankAccount.java
public class BankAccount {

    // atribut
    private String accountNumber; // nomor akun
    private String ownerName;     // nama pemilik akun
    private double balance;       // saldo akun

    // konstruktor
    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber; // menginisialisasi nomor akun
        this.ownerName = ownerName;         // menginisialisasi nama pemilik akun
        this.balance = balance;             // menginisialisasi saldo akun
    }

    // metode untuk menampilkan informasi akun
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber); // menampilkan nomor akun
        System.out.println("Owner Name: " + ownerName);         // menampilkan nama pemilik akun
        System.out.println("Balance: $" + balance);             // menampilkan saldo akun
        System.out.println(); // memberi spasi untuk keterbacaan yang lebih baik
    }

    // metode untuk menyetor uang
    public void depositMoney(double amount) {
        if (amount > 0) { // jika jumlah setoran lebih besar dari 0
            balance += amount; // menambahkan jumlah setoran ke saldo
            System.out.println("Deposit of $" + amount + " successful."); // menampilkan pesan sukses
            System.out.println("New Balance: $" + balance); // menampilkan saldo baru
        } else { // jika jumlah setoran tidak valid (kurang dari atau sama dengan 0)
            System.out.println("Invalid deposit amount. Please enter a positive value."); // pesan kesalahan
        }
        System.out.println(); // memberi spasi untuk keterbacaan yang lebih baik
    }

    // metode untuk menarik uang
    public void withdrawMoney(double amount) {
        if (amount > 0 && balance >= amount) { // jika jumlah penarikan lebih besar dari 0 dan saldo cukup
            balance -= amount; // mengurangi jumlah penarikan dari saldo
            System.out.println("Withdrawal of $" + amount + " successful."); // menampilkan pesan sukses
            System.out.println("New Balance: $" + balance); // menampilkan saldo baru
        } else if (amount <= 0) { // jika jumlah penarikan tidak valid (kurang dari atau sama dengan 0)
            System.out.println("Invalid withdrawal amount. Please enter a positive value."); // pesan kesalahan
        } else { // jika saldo tidak mencukupi untuk penarikan
            System.out.println("Insufficient balance. Withdrawal not allowed."); // pesan kesalahan
        }
        System.out.println(); // memberi spasi untuk keterbacaan yang lebih baik
    }
}

class Main {
    public static void main(String[] args) {
        // membuat dua objek BankAccount
        BankAccount account1 = new BankAccount("202410370110191", "Nanda", 1500.0); // akun pertama
        BankAccount account2 = new BankAccount("202210370311382", "Alan", 1800.0);  // akun kedua

        // menampilkan informasi untuk kedua akun
        System.out.println("Account 1 Info:");
        account1.displayInfo(); // menampilkan informasi akun pertama

        System.out.println("Account 2 Info:");
        account2.displayInfo(); // menampilkan informasi akun kedua

        // melakukan beberapa transaksi pada akun1
        account1.depositMoney(200.0);   // menyetor uang ke akun1
        account1.withdrawMoney(100.0);  // menarik uang dari akun1

        // melakukan beberapa transaksi pada akun2
        account2.depositMoney(300.0);   // menyetor uang ke akun2
        account2.withdrawMoney(900.0);  // mencoba menarik lebih dari saldo akun2
    }
}