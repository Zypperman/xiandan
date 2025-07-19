
import java.util.Scanner;

public class AbsoluteValue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = Integer.valueOf(scanner.nextLine());
        if (target < 0 ){
            target = -target;
        }
        System.out.println(target);
        
    }
}
