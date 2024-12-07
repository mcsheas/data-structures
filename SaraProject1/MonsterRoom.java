public class MonsterRoom extends Room {
    private AgeGroupMonster monster;

    public MonsterRoom(AgeGroupMonster monster) {
        super(monster, null, null);
        this.monster = monster;
    }

    @Override
    public void enter(Player player) {
         if (this.isExit() == false ) {
            System.out.println("Life comes with many challenges. Time for you to face " + monster.getName());
    
            boolean playerTurn = player.getWisdom() > monster.getWisdom();
            while (player.isAlive() && monster.getHealth() > 0 && monster.getTurnCount()<monster.getMaxTurns()) {
                if (playerTurn) {
                    int damage = player.getEnergy() / 10 + player.getWisdom() / 5;
                    System.out.println("You strike " + monster.getName() + " with " + damage + " power.");
                    monster.takeDamage(damage);
                } else {
                    monster.attack(player);
                }
                playerTurn = !playerTurn; 
            }
            System.out.println(player.isAlive() ? "You overcame " + monster.getName() + "!" : "You are not ready for " +monster.getName() + " quite yet...");    
        }
    }
}
