import java.util.*;

public class mutualNumber {
    public static double mutualNumber(int n) throws IllegalArgumentException{
        if (n < 1)
            throw new IllegalArgumentException();
        return 1.0/n;
    }
    
    public static void main(String... args) {
        int n;
        Scanner scanInt = new Scanner(System.in);
        
        System.out.print("Insert an integer: ");
        try {
            System.out.println(mutualNumber(scanInt.nextInt()));
        }
        
        catch (IllegalArgumentException e) {
            System.out.println("The integer must be higher than zero. Retry.");
            main();
        }
        
        catch (InputMismatchException e) {
            System.out.println("You have to enter an integer. Retry.");
            main();
        }
        
        scanInt.close();
        
    }
}
