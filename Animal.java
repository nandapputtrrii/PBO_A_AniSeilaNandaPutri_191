// Animal.java
public class Animal {
    // Attributes (fields)
    private String name;
    private String type;
    private String sound;

    // Constructor
    public Animal(String name, String type, String sound) {
        this.name = name;
        this.type = type;
        this.sound = sound;
    }

    // Getter methods (optional but common practice in Java)
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSound() {
        return sound;
    }

    // Display information about the animal
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Sound: " + sound);
        System.out.println(); // For better readability
    }
}

class Main {
    public static void main(String[] args) {
        // Create 2 animal objects
        Animal animal1 = new Animal("Cat", "Mammal", "Nyann~~");
        Animal animal2 = new Animal("Dog", "Mammal", "Woof-Woof!!");

        // Display information for both animals
        System.out.println("Animal 1 Info:");
        animal1.displayInfo();

        System.out.println("Animal 2 Info:");
        animal2.displayInfo();
    }
}