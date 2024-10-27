public class AgeGroupTreasure {
    private String name;
    private int hapEffect;
    private int energyEffect;
    private String ageGroup;

    public AgeGroupTreasure(String name, int hapEffect, int energyEffect, String ageGroup) {
        this.name = name;
        this.hapEffect = hapEffect;
        this.energyEffect = energyEffect;
        this.ageGroup = ageGroup;
    }
    
    public AgeGroupTreasure(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void use(Player player) {
        player.gainHappiness(hapEffect); 
        player.gainEnergy(energyEffect);
        System.out.println("You've used " + name + " and gained " + hapEffect + " happiness and " + energyEffect + " energy.");
    }
}
