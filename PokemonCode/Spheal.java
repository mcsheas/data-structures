import java.util.Random;

public class Spheal extends Pokemon implements Attacking
{
    private int loss = 0;
    public Spheal(){
       super(70, 40, 50, 55, 50, 25, "Spheal");
    }

   
   public Spheal(int inputHp, int inputAttack, int inputDefense,int inputSpAtk, int inputSpDef, int inputSpeed, String inputName){
       super(inputHp, inputAttack, inputDefense, inputSpAtk, inputSpDef, inputSpeed, inputName);
   }
   
   public void blizzard(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Spheal used Blizzard!");
       
   }
   
   public void waterGun(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }      
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Spheal used Water Gun!");
       
   }
   
   public void snore(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }      
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Spheal used Snore!");
       
   }
   
   public void rollout(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Spheal used Rollout!");
       
   }
   
   @Override
   public void attack(Pokemon opponent){
       Random rand = new Random();
       int atk = rand.nextInt(4);
       
       if (atk == 0){
           blizzard(opponent);
       }else if (atk == 1){
           waterGun(opponent);
       }else if (atk == 2){
           snore(opponent);
       }else{
           rollout(opponent);
       }
   }
    
}