import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        String input;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                input = validateInput(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private static String validateInput(String nextLine) throws Exception {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(nextLine);
        if(!matcher.matches()) {
            throw new Exception("Enter a Number!");
        }
        return null;
    }
}
