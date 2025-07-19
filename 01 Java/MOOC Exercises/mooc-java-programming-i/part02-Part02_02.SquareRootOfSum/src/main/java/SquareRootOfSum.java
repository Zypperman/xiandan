
import java.util.Scanner;

public class SquareRootOfSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetNum = Integer.valueOf(scanner.nextLine());
        int power = Integer.valueOf(scanner.nextLine());
        System.out.println(Math.sqrt(power+targetNum));
    }
}
