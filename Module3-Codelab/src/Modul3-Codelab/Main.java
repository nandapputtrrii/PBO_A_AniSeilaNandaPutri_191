public class Main {
    public static void main(String[] args) {
        // Create objects
        GameCharacter generalCharacter = new GameCharacter("General Character", 100);
        Hero brimstone = new Hero("Brimstone", 150);
        Enemy viper = new Enemy("Viper", 200);

        // Display initial health
        System.out.println("Initial Health:");
        System.out.println(brimstone.getName() + ": " + brimstone.getHealth());
        System.out.println(viper.getName() + ": " + viper.getHealth());
        System.out.println();

        // Simulate combat
        System.out.println("Battle begins:");
        brimstone.attack(viper);
        brimstone.attack(viper); // Brimstone attacks Viper
        viper.attack(brimstone);    // Viper attacks Brimstone
    }
}