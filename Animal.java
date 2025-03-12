// Animal.java
public class Animal {
    // atribut (fields)
    private String name;
    private String type;
    private String sound;

    // konstruktor untuk inisialisasi objek Animal
    public Animal(String name, String type, String sound) {
        this.name = name;
        this.type = type;
        this.sound = sound;
    }

    // metode getter untuk mengambil nama hewan
    public String getName() {
        return name;
    }

    // metode getter untuk mengambil tipe hewan
    public String getType() {
        return type;
    }

    // metode getter untuk mengambil suara hewan
    public String getSound() {
        return sound;
    }

    // menampilkan informasi tentang hewan
    public void displayInfo() {
        System.out.println("Name: " + name);  // menampilkan nama hewan
        System.out.println("Type: " + type);  // menampilkan tipe hewan
        System.out.println("Sound: " + sound); // menampilkan suara hewan
        System.out.println(); // untuk jarak yang lebih baik antar informasi
    }
}

// Main.java
class Main {
    public static void main(String[] args) {
        // membuat dua objek Animal
        Animal animal1 = new Animal("Cat", "Mammal", "Nyann~~");
        Animal animal2 = new Animal("Dog", "Mammal", "Woof-Woof!!");

        // menampilkan informasi untuk kedua objek animal
        System.out.println("Animal 1 Info:");
        animal1.displayInfo(); // menampilkan info untuk animal1

        System.out.println("Animal 2 Info:");
        animal2.displayInfo(); // menampilkan info untuk animal2
    }
}
