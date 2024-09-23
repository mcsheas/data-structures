import java.util.Random;

public abstract class Pokemon implements SpeedComparison, Attacking 
{
   private int hp;
   private int attack;
   private int defense;
   private int spAtk;
   private int spDef;
   private int speed;
   private String name;  
   
   public Pokemon(int userHp, int userAttack, int userDefense, int userSpAtk, int userSpDef, int userSpeed, String userName){
       hp = userHp;
       attack = userAttack;
       defense = userDefense;
       spAtk = userSpAtk;
       spDef = userSpDef;
       speed = userSpeed;
       name = userName;
   }
   
      public String getName(){
       return name;
   }
   
   public int getHp(){
       return hp;
   }
   
   public void setHp(int inputHp){
       hp = inputHp;
   }
   
   public int getAttack(){
       return attack;
   }
   
   public int getSpAtk(){
       return spAtk;
   }
   
   public int getSpDef(){
       return spDef;
   }
   
   public int getDefense(){
       return defense;
   }
   
   public int getSpeed(){
       return speed;
   }
   
   public abstract void attack(Pokemon opponent);
   
   @Override
   public int compareTo(Pokemon opponent){
       if(this.getSpeed()>opponent.getSpeed()){
           return 1;
       }else if(this.getSpeed()<opponent.getSpeed()){
           return -1;
       }else{
           return 0;
       }
   }
   
   @Override 
   public boolean equals(Object obj){
       
       Pokemon guy = (Pokemon) obj;
       
       return(this.getHp() == guy.getHp() && 
       this.getAttack() == guy.getAttack() &&
       this.getDefense() == guy.getDefense() &&
       this.getSpAtk() == guy.getSpAtk() &&
       this.getSpDef() == guy.getSpDef() &&
       this.getSpeed() == guy.getSpeed() &&
       this.getName().equals(guy.getName()));
   }
}
