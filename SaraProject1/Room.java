public abstract class Room implements RoomValues{
    private String type;
    private AgeGroupTreasure treasure;
    private AgeGroupMonster monster;
    private AgeGroupTrap trap;
    private boolean visited;
    
    public abstract void enter(Player player);
    
    public Room(AgeGroupMonster monster, AgeGroupTreasure treasure, AgeGroupTrap trap) {
        this.monster = monster;
        this.treasure = treasure;
        this.trap = trap;
        this.visited = false;
    }

    public boolean hasMonster() {
        return monster != null;
    }

    public AgeGroupMonster getMonster() {
        return monster;
    }

    public boolean hasTrap() {
        return trap != null;
    }

    public AgeGroupTrap getTrap() {
        return trap;
    }

    public AgeGroupTreasure getTreasure() {
        return treasure;
    }

    public void setMonster(AgeGroupMonster monster) {
        this.monster = monster;
    }

    public void setItem(AgeGroupTreasure treasure) {
        this.treasure = treasure;
    }
    
    public boolean isExit(){
        if (this.getTreasure() != null && this.getTreasure().getName().equals("Exit")) {
                return true; 
            }
        return false;
    }
    

    
}