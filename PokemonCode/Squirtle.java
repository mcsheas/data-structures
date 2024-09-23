import java.util.Random;

public class Squirtle extends Pokemon implements Attacking
{
    private int loss = 0;
    public Squirtle(){
       super(44, 48, 65, 50, 64, 43, "Squirtle");
    }

   
   public Squirtle(int inputHp, int inputAttack, int inputDefense,int inputSpAtk, int inputSpDef, int inputSpeed, String inputName){
       super(inputHp, inputAttack, inputDefense, inputSpAtk, inputSpDef, inputSpeed, inputName);
   }
 
   public void zenHeadbutt(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Squirtle used Zen Headbutt!");
       
   }
   
   public void rapidSpin(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Squirtle used Rapid Spin!");
       
   }
   
   public void tailWhip(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Squirtle used Tail Whip!");
       
   }
   
   public void ironDefense(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Squirtle used Iron Defense!");
       
   }
   
   @Override
   public void attack(Pokemon opponent){
       Random rand = new Random();
       int atk = rand.nextInt(4);
       
       if (atk == 0){
           zenHeadbutt(opponent);
       }else if (atk == 1){
           rapidSpin(opponent);
       }else if (atk == 2){
           tailWhip(opponent);
       }else{
           ironDefense(opponent);
       }
   }
    
}