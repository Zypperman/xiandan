
import java.util.Scanner;

public class AverageOfTwoNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Give the first number:");
        int firstnum = Integer.valueOf(scanner.nextLine());
        System.out.println("Give the second number:");
        int secondnum = Integer.valueOf(scanner.nextLine());
        double Average = (firstnum + secondnum) / 2 ;
        System.out.println("The average is "+ Average);
    }
}
