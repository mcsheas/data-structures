import java.util.Random;

public class Pikachu extends Pokemon implements Attacking
{    
    private int loss = 0;
   public Pikachu(){
       super(35, 55, 30, 50, 40, 90,"Pikachu");
    }
   
   public Pikachu(int inputHp, int inputAttack, int inputDefense,int inputSpAtk, int inputSpDef, int inputSpeed, String inputName){
       super(inputHp, inputAttack, inputDefense, inputSpAtk, inputSpDef, inputSpeed, inputName);
   }
   
   public void thunderbolt(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Pikachu used Thunderbolt!");
       
   }
   
   public void doubleSlap(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Pikachu used Double Slap!");
       
   }
   
   public void charge(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Pikachu used Charge!");
       
   }
   
   public void thunderPunch(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Pikachu used Thunder Punch!");
       
   }
   
   @Override
   public void attack(Pokemon opponent){
       Random rand = new Random();
       int atk = rand.nextInt(4);
       
       if (atk == 0){
           thunderbolt(opponent);
       }else if (atk == 1){
           doubleSlap(opponent);
       }else if (atk == 2){
           charge(opponent);
       }else{
           thunderPunch(opponent);
       }
   }

    
}
