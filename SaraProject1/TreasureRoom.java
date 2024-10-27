public class TreasureRoom extends Room {
    private AgeGroupTreasure treasure;

    public TreasureRoom(AgeGroupTreasure treasure) {
        super(null, treasure, null); 
        this.treasure = treasure; 
    }

    @Override
    public void enter(Player player) {
         if (this.isExit() == false ) {
            System.out.println("Life isn't all bad. There's some good things too, like " + treasure.getName() + "!");
            treasure.use(player);
        }
   }
}
