public class TrapRoom extends Room {
    private AgeGroupTrap trap;

    public TrapRoom(AgeGroupTrap trap) {
        super(null, null, trap);
        this.trap = trap;
    }

    @Override
    public void enter(Player player) {
        if (this.isExit() == false ) {
            System.out.println("Uh oh today is not your day...");
            trap.activate(player);
        }
    }
}
