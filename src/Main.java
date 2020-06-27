import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Scanner scanner;
    private static ArrayList<Patient> patients;

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        int input;
        scanner = new Scanner(System.in);
        while(true) {
            System.out.println("What do you want to do?\n" +
                    "1. Create an account\n" +
                    "2. Determine a time\n" +
                    "3. See a doctor\n" +
                    "4. Visits' records\n" +
                    "5. Exit");
            try {
                input = validateInput(scanner.nextLine());
                switch (input) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        determineTime();
                        break;
                    case 3:
                        pickTime();
                        break;
                    case 4:
                        viewRecords();
                        break;
                    case 5:
                        System.exit(1);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void viewRecords() {

    }

    private static void pickTime() {

    }

    private static void determineTime() {

    }

    private static void createAccount() {
        String[] information = null;
        while (information == null) {
            System.out.println("Enter:\nName-National Code-Age");
            try {
                information = getPatientsInformation(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        patients.add(new Patient(information[0], Integer.parseInt(information[1]), Integer.parseInt(information[2])));
    }

    private static String[] getPatientsInformation(String nextLine) throws Exception {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+-\\d+-\\d+$");
        Matcher matcher = pattern.matcher(nextLine);
        if(!matcher.matches())
            throw new Exception("Enter valid input!");
        return nextLine.split("-");
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
