// GameCharacter Class (Superclass)
public class GameCharacter {
       private String name;
       private int health;

       // Constructor with parameters
       public GameCharacter(String name, int health) {
              this.name = name;
              this.health = health;
       }

       // Getters and setters
       public String getName() {
              return name;
       }

       public void setName(String name) {
              this.name = name;
       }

       public int getHealth() {
              return health;
       }

       public void setHealth(int health) {
              this.health = health;
       }

       // Attack method to be overridden by subclasses
       public void attack(GameCharacter target) {
              // This will be overridden
       }
}