public class StartingRoom extends Room {
    public StartingRoom() {
        super(null, null, null);
    }

    @Override
    public void enter(Player player) {
        if (player.getAge()==0){
        System.out.println("Welcome to the world! Life awaits you with many challenges and treasures. Good luck!");
    }else {
    System.out.println("Happy Birthday! You are now a year older,don't worry the chaos hasn't started...YET");
    }    }
}
