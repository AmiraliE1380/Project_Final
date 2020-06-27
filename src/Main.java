import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        int input;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("What do you want to do?\n" +
                    "1. Create an account\n" +
                    "2. Determine a time\n" +
                    "3. See a doctor\n" +
                    "4. Visits' records\n" +
                    "5. Exit");
            try {
                input = validateInput(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private static int validateInput(String nextLine) throws Exception {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(nextLine);
        if(!matcher.matches()) {
            throw new Exception("Enter a Number!");
        }
        Integer input = Integer.parseInt(nextLine);
        if(input < 1 || input > 5) {
            throw new Exception("Enter one of the above options!");
        }
        return input;
    }
}
