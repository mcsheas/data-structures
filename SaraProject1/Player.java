public class Player {
    private int age;
    private int health;
    private int wisdom;
    private int happiness;
    private int energy;
    private int skipCount;
    private boolean alive;
    private boolean hasFamily;

    public Player() {
        age = 0;
        health = 100;
        wisdom = 0;
        happiness = 50;
        energy = 50; 
        alive = true;
        hasFamily = false;
        skipCount = 2;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getEnergy() {
        return energy;
    }
    
    public int getAge(){
        return age;
    }

    public int getHealth(){
        return health;
    }
    
    public int getSkipCount(){
        return skipCount;
    }
    
    public void decSkipCount(){
        skipCount--;
    }
    
    public void resetSkipCount(){
        skipCount = 2;
    }
    
    public void gainEnergy(int amount) {
    this.energy += amount;
    System.out.println("Looks like you took your vitamins :)");
    }   

    public void takeDamage(int damage) {
        int defense = happiness/10;
        int adjustedDamage = Math.max(0, damage - defense); 
        health -= adjustedDamage;
        happiness-=defense/2;
        if (health <= 0) {alive = false;}
    }

    public void decreaseEnergy(int amount) {
        energy -= amount;
        if (energy < 0){energy = 0;}
        System.out.println("Oof you might need a Celcius");
    }

    public void gainWisdom(int amount) {
         wisdom += amount;
    }
    
    public void loseWisdom(int amount){
        wisdom-=amount;
        if (wisdom < 0){wisdom = 0;}
    }

    public void gainHappiness(int amount) {
        happiness += amount;
        System.out.println("Glad to see you are happier!");
    }

    public void loseHappiness(int amount) {
        happiness -= amount;
        if (happiness < 0) {happiness = 0;}
        System.out.println("Im sorry, do you want to talk about it?");
    }

    public void ageUp() {
        age++;
        System.out.println("You are now " + age + " year(s) old.");
        displayStats(); 
    }

    public boolean isAlive() {
        return alive;
    }
    public void displayStats() {
        System.out.println("Player Stats:");
        System.out.println("Age: " + age);
        if (age>40){System.out.println("I think I'm starting to see some wrinkles...");}
        System.out.println("Health: " + health);
        if (health >=75) {System.out.println("What is your secret??");}
        System.out.println("Wisdom: " + wisdom);
        if (wisdom <=25){System.out.println("Hit the books!");}
        System.out.println("Happiness: " + happiness);
        if (happiness>=50){System.out.println("Oh what a happy fella you are!");}
        System.out.println("Energy: " + energy);
        if (health <=25){System.out.println("Oof, you need to get some sleep!");}
        System.out.println();
    }
}
