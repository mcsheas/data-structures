public class AgeGroupMonster {
    private String name;
    private int health; 
    private int damage;
    private int wisdom;
    private String ageGroup;
    private int turns;
    private int maxTurns;

    public AgeGroupMonster(String name, int damage, int wisdom,int health,int maxTurns, String ageGroup) {
        this.name = name;
        this.damage = damage;
        this.wisdom = wisdom;
        this.ageGroup = ageGroup;
        this.health = health; 
        this.maxTurns = maxTurns;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getWisdom() {
        return wisdom;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public int getHealth() { 
        return health;
    }
    
    public int getTurnCount(){
        return turns;
    }
    
    public int getMaxTurns(){
        return maxTurns;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0; 
        }
    }

    public void attack(Player player) {
        turns++;
        System.out.println(name + " attacks with " + damage + " power.");
        player.takeDamage(damage);
    }
}
