import java.util.ArrayList;
import java.util.Random;

public class TestStadium 
{
    private ArrayList<Pokemon> players = new ArrayList<>();
    
    public TestStadium(){
        players.add(new Pikachu());
        players.add(new Charizard());
        players.add(new Spheal());
        players.add(new Bulbasaur());
        players.add(new Squirtle());
        players.add(new Charmander());
    }
    
    private Random rand = new Random();
    
    public void startBattle(){
        int index = rand.nextInt(players.size());
        int secondIndex = rand.nextInt(players.size());
        
        /*while(secondIndex == index){
           secondIndex = rand.nextInt(players.size()); 
        }
        */
        Pokemon playerOne = players.get(index);
        Pokemon playerTwo = players.get(secondIndex);
       
       //System.out.println(playerOne.compareTo(playerTwo));
       while(playerOne.equals(playerTwo)){
           System.out.println("same opponenet");
           secondIndex = rand.nextInt(players.size());
           playerTwo = players.get(secondIndex);
       }
        
        //Battle begins
        
        System.out.println("Battle Music Initialized");
        int pOneHP = playerOne.getHp();
        int pTwoHP = playerTwo.getHp();
        String pOneName = playerOne.getName();
        String pTwoName = playerTwo.getName();
        System.out.println(pOneName + " vs. " + pTwoName); 
        
        while(pOneHP > 0 && pTwoHP > 0){
           System.out.println("Player One HP: " + pOneHP);
           System.out.println("Player Two HP: " + pTwoHP);
           
           //player 1 attack
           playerOne.attack(playerTwo);
           pTwoHP = playerTwo.getHp();
           
           if (pTwoHP <= 0){
                System.out.println(pTwoName + " loses. Better luck next time little one. womp womp :(");
                System.out.println(pOneName + " is victorious. Big dog or big luck?");
                return;
            }
        
           playerTwo.attack(playerOne);
           pOneHP = playerOne.getHp();
           
           if (pOneHP <= 0){
                System.out.println(pOneName + " loses. Better luck next time little one. womp womp :(");
                System.out.println(pTwoName + " is victorious. Big dog or big luck?");
                return;
            }
             
        }
    }
    public static void main(String[] args){
        TestStadium game = new TestStadium();
        game.startBattle();
    }
          
    }

