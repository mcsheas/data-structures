public class AgeGroupTrap {
    private String name;
    private int energyLoss;
    private int happinessLoss;
    private String ageGroup;

    public AgeGroupTrap(String name, int energyLoss, int happinessLoss, String ageGroup) {
        this.name = name;
        this.energyLoss = energyLoss;
        this.happinessLoss = happinessLoss;
        this.ageGroup = ageGroup;
    }

    public String getName() {
        return name;
    }

    public int getEnergyLoss() {
        return energyLoss;
    }

    public int getHappinessLoss() {
        return happinessLoss;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void activate(Player player) {
        player.takeDamage(energyLoss);       
        player.loseHappiness(happinessLoss); 
        System.out.println("Everyone must deal with " + name + " at somepoint in their life. Hate to say that now is your time... You loss " + happinessLoss + " happiness and " + energyLoss + " energy.");
    }
}
