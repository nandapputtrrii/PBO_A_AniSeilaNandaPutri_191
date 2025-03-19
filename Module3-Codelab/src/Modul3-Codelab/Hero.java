// Hero class (Subclass of GameCharacter)
public class Hero extends GameCharacter {
    // Constructor using super()
    public Hero(String name, int health) {
        super(name, health);
    }

    // Override attack method
    @Override
    public void attack(GameCharacter target) {
        System.out.println(this.getName() + " attacks " + target.getName() + " using a sword!");

        // Reduce target health by 20
        target.setHealth(target.getHealth() - 20);

        // Display target's current health
        System.out.println(target.getName() + "'s health is now " + target.getHealth());
    }
}