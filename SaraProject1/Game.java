import java.util.Scanner;

public class Game {
    private Dungeon dungeon;
    private Player player;
    private Box currentBox; 
    private Scanner scanner;

    public Game() {
        player = new Player();
        dungeon = new Dungeon(player);
        currentBox = dungeon.getRooms().getHead(); 
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the Game of Life!");
        while (player.isAlive()) {
            dungeon.setCurrentRoom(currentBox);
            Room currentRoom = currentBox.getRoom();
             if (currentRoom.isExit() == true ) {
                System.out.println("\nYou've found the exit! Moving up in age.");
                dungeon.moveToNextLevel();
                currentBox = dungeon.getRooms().getHead(); 
                continue;
            }
            
            if (!player.isAlive()) {
                System.out.println("You have perished!");
                break;
            }
            
            Box targetBox = null;
            Box skipBox = null;
            boolean skipAction = false;
            while(targetBox == null) {
                System.out.println("Choose your action: (1) Go Left (2) Go Right (3) Skip Left (4) Skip Right (You have " + player.getSkipCount() + " skip(s) left)");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: 
                        targetBox = currentBox.getLeftBox();  
                        break;
                    case 2: 
                        targetBox = currentBox.getRightBox(); 
                        break;
                    case 3: 
                        if (player.getSkipCount() == 0 ) {
                            System.out.println("You are out of skips, please choose left or right!");
                            break;
                        }
                        targetBox = currentBox.getLeftBox().getLeftBox();
                        skipBox = currentBox.getLeftBox();
                        skipAction = true;
                        player.decSkipCount();
                        break;
                    case 4:
                        if (player.getSkipCount() == 0 ) {
                            System.out.println("You are out of skips, please choose left or right!");
                            break;
                        }
                        targetBox = currentBox.getRightBox().getRightBox();
                        skipBox = currentBox.getRightBox();
                        skipAction = true;
                        player.decSkipCount();
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        break;
                }
            }
            
            
            
            if (targetBox != null) {
            if (skipAction && skipBox.getRoom().hasMonster()) {
                AgeGroupMonster monster = skipBox.getRoom().getMonster();
                System.out.println("You cannot escape life's challeges. The " + monster.getName() + " strikes as you flee, dealing " + monster.getDamage() + " damage.");
                player.takeDamage(monster.getDamage());
            }
            dungeon.enteredCurrentBox(currentBox);
            currentBox = targetBox;
        }
        }
        scanner.close();
    }
}
