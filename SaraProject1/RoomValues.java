
public interface RoomValues{
    void enter(Player player);
    
    boolean hasMonster();
    boolean hasTrap();
    public boolean isExit();
    
    AgeGroupMonster getMonster();
    AgeGroupTrap getTrap();
    AgeGroupTreasure getTreasure();
    
    void setMonster(AgeGroupMonster monster);
    void setItem(AgeGroupTreasure treasure);
    
    
}
