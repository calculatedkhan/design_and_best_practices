package best_practices;
import java.util.Scanner;
import static java.lang.Math.floor;

/*
This class has a super bloated method that does too many things at once. Refactor the describeYear method and
separate out the responsibilities into other methods to improve readability and maintainability.
 */
public class YearDescriber {
    static Scanner fromUser = new Scanner(System.in);
    private static int year = 0;
    private static boolean isLeap;
    private static String leapYear = "not a leap year";
    private static String startDay;
    private YearDescriber(){}; //static class

    public static void  describeYear() {
        getYear();
        isLeapYear();
        dayCalculator();
        System.out.println("The year " + year + " is " + leapYear + " and started on a " + startDay);
    }

    public static void getYear() {
        System.out.println("What year would you like to learn about?");
        while (true) {
            try {
                year = fromUser.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please just input a year in the format YYYY!");
            }
        }
    }

    public static void isLeapYear() {
        isLeap = (year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0));
        if (isLeap) {
            leapYear = "a leap year";
        }
    }

    public static void dayCalculator() {
        //Incorrect formula
        int startDayCalc = (30 - (year / 50) + ((year % 100 - 1) / 4) + (year / 400)) % 7;
        while (startDayCalc < 0) {
            startDayCalc += 7;
        }
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int dayIndex = startDayCalc % 7;
        startDay = daysOfWeek[dayIndex];
    }
}
