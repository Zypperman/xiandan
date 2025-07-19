
import java.util.Scanner;

public class OnlyPositives {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Give a number:");
            input = Integer.valueOf(scanner.nextLine());

            if (input > 0) {
                System.out.println(input * input);
            } else if (input < 0) {
                System.out.println("Unsuitable number");
            } else {
                break;
            }
        }
    }
}
