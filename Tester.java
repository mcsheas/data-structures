import java.util.Random;

public class Tester
{
    
     public static void main(String[] args){
        SaraContainer test = new SaraContainer(5);
        Random rand = new Random();
        
        test.add(14);
        test.add(3);
        test.add(56);
        test.add(4,4);
        test.add(2,4);
        test.replace(2,90);
        test.removesLast();
        test.removesFirst();
        System.out.println(test.size());
        test.addFirst(25);
        System.out.println(test.size());
        test.add(33);
        test.add(789);
        test.remove(2);
        System.out.println(test.size());
        System.out.println(test.indexOf(5));
        System.out.println(test.indexOf(789));
        System.out.println(test.isEmpty());
        System.out.println(test);
        test.clear();
        System.out.println(test.isEmpty());
        System.out.println(test);
        test.clear(1);
        System.out.println(test.isEmpty());
        test.add(8675309);
        System.out.println(test);
    }
}
