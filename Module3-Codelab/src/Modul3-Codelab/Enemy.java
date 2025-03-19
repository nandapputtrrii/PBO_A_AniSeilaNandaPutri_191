// Enemy Class (Subclass of GameCharacter)
public class Enemy extends GameCharacter {
    // Constructor using super()
    public Enemy(String name, int health) {
        super(name, health);
    }

    // Override attack method
    @Override
    public void attack(GameCharacter target) {
        System.out.println(this.getName() + " attacked " + target.getName() + " using magic!");

        // Reduce target health by 15
        target.setHealth(target.getHealth() - 15);

        // Display target's current health
        System.out.println(target.getName() + "'s health is now " + target.getHealth());
    }
}