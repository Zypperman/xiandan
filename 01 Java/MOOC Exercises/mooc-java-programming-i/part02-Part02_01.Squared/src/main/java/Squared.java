import java.util.Scanner;

public class Squared {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int squaredInput = Integer.valueOf(scanner.nextLine());
        int squaredResult = squaredInput*squaredInput;
        System.out.println( squaredResult );
    }
}
