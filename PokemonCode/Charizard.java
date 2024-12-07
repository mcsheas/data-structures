import java.util.Random;

public class Charizard extends Pokemon implements Attacking
{
    private int loss = 0;
    public Charizard(){
       super(78, 84, 78,109,89, 100, "Charizard");
    }

   public Charizard(int inputHp, int inputAttack, int inputDefense,int inputSpAtk, int inputSpDef, int inputSpeed, String inputName){
       super(inputHp, inputAttack, inputDefense, inputSpAtk, inputSpDef, inputSpeed, inputName);
   }
   
   public void blastBurn(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }      
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Charizard used Blast Burn!");
       
   }
   
   public void fireSpin(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Charizard used Fire Spin!");
   }
   
   public void airSlash(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Charizard used Air Slash!");
       
   }
   
   public void ember(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Charizard used Ember!");
       
   }
   
   @Override
   public void attack(Pokemon opponent){
       Random rand = new Random();
       int atk = rand.nextInt(4);
       
       if (atk == 0){
           blastBurn(opponent);
       }else if (atk == 1){
           fireSpin(opponent);
       }else if (atk == 2){
           airSlash(opponent);
       }else{
           ember(opponent);
       }
   }
   
    
}

