import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                input = validateInput(scanner.nextLine().trim());
                switch (input) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        determineTime();
                        break;
                    case 3:
                        reserve();
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

    private static void reserve() {

    }

    private static void determineTime() {
        String[] information = null;
        while (information == null) {
            System.out.println("Enter beginning and end date:\nyyyy-MM-dd-HH-mm-HH-mm\nExample:2020-11-23-12-00-14-00");
            try {
                String dateInput = getDateInput(scanner.nextLine().trim());
                String beginningDate = dateInput.split(",")[0];
                String endDate = dateInput.split(",")[1];
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
                Date date1 = format.parse(beginningDate);
                Date date2 = format.parse(endDate);
                System.out.println(date1.toString());
                System.out.println(date2.toString());
                information = getPatientsInformation(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getDateInput(String nextLine) throws Exception {
        Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}-\\d{2}-\\d{2}-\\d{2}-\\d{2}$");
        Matcher matcher = pattern.matcher(nextLine);
        if(!matcher.matches())
            throw new Exception("Enter valid input!");
        String beginningDate = nextLine.substring(0, 16);
        String endDate = nextLine.substring(0, 10) + nextLine.substring(16);
        return beginningDate + "," + endDate;
    }

    private static void createAccount() {
        String[] information = null;
        while (information == null) {
            System.out.println("Enter:\nName-National Code-Age");
            try {
                information = getPatientsInformation(scanner.nextLine().trim());
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
