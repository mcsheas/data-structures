import java.util.Random;

public class Bulbasaur extends Pokemon implements Attacking
{
    private int loss = 0;
    public Bulbasaur(){
       super(45, 49, 49, 65, 65, 45, "Bulbasaur");
    }

   
   public Bulbasaur(int inputHp, int inputAttack, int inputDefense,int inputSpAtk, int inputSpDef, int inputSpeed, String inputName){
       super(inputHp, inputAttack, inputDefense, inputSpAtk, inputSpDef, inputSpeed, inputName);
   }

   public void solarBeam(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Bulbasaur used Solar Beam!");
       
   }
   
   public void seedBomb(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Bulbasaur used Seed Bomb!");
       
   }
   
   public void powerWhip(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Bulbasaur used Power Whip!");
       
   }
   
   public void sludgeBomb(Pokemon anyPoorPokemon){
      loss = this.getAttack() - anyPoorPokemon.getDefense();
       int resultingLife = 0;
       if(loss<0){
           resultingLife = anyPoorPokemon.getHp(); 
       }else{
           resultingLife = anyPoorPokemon.getHp() - (loss);
       }       anyPoorPokemon.setHp(resultingLife);
       System.out.println("Bulbasaur used Sludge Bomb!");
       
   }
    
   @Override
   public void attack(Pokemon opponent){
       Random rand = new Random();
       int atk = rand.nextInt(4);
       
       if (atk == 0){
           solarBeam(opponent);
       }else if (atk == 1){
           seedBomb(opponent);
       }else if (atk == 2){
           powerWhip(opponent);
       }else{
           sludgeBomb(opponent);
       }
   }
}