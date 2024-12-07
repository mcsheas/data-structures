import java.util.Random;

public class Charmander extends Pokemon implements Attacking
{
    private int loss= 0;
    public Charmander(){
       super(39, 52, 43, 60, 50, 65, "Charmander");
    }

   
   public Charmander(int inputHp, int inputAttack, int inputDefense,int inputSpAtk, int inputSpDef, int inputSpeed, String inputName){
       super(inputHp, inputAttack, inputDefense, inputSpAtk, inputSpDef, inputSpeed, inputName);
   }
   
   public void flareBlitz(Pokemon anyPoorPokemon){
       loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Charmander used Flare Blitz!");
       
   }
    
   public void scrath(Pokemon anyPoorPokemon){
       loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }
       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Charmander used Scrath!");
       
   }
   
   public void fireFang(Pokemon anyPoorPokemon){
        loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Charmander used Fire Fang!");
       
   }
   
   public void dragonBreath (Pokemon anyPoorPokemon){
        loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Charmander used Dragon Breath!");
       
   }
   
   @Override
   public void attack(Pokemon opponent){
       Random rand = new Random();
       int atk = rand.nextInt(4);
       
       if (atk == 0){
           flareBlitz(opponent);
       }else if (atk == 1){
           scrath(opponent);
       }else if (atk == 2){
           fireFang(opponent);
       }else{
           dragonBreath(opponent);
       }
   }
}