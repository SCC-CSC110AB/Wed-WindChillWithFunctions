package wed.windchillwithfunctions;

import java.util.Scanner;

/**
 *
 * @author john
 */
public class WedWindChillWithFunctions {

    public static String getUserInput() {
        System.out.println("Enter in the current temperature (e.g: 80 F): ");
        return new Scanner(System.in).nextLine();
    }

    public static String[] getSplitUserInput(String userInput) {
        return userInput.split(" ");
    }

    public static double getTemperatureValue(String userInput) {
        return Double.parseDouble(getSplitUserInput(userInput)[0]);
    }

    public static String getTemperatureUnit(String userInput) {
        return getSplitUserInput(userInput)[1];
    }

    public static boolean isCelsius(String userInput) {
        return getTemperatureUnit(userInput).equalsIgnoreCase("C");
    }

    public static boolean isValid(String userInput) {
        double temperatureValue = getTemperatureValue(userInput);
        if (isCelsius(userInput)) {
            return temperatureValue >= -40 && temperatureValue <= 40;
        } else {
            return temperatureValue >= -40 && temperatureValue <= 100;
        }
    }

    public static String getValidUserInput() {
        boolean isValid;
        String userInput;

        do {
            userInput = getUserInput();
            isValid = isValid(userInput);

            if (!isValid) {
                System.out.println(
                    "Invalid temperature range. Please try again"
                );
            }
        } while (!isValid);

        return userInput;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String userInput = getValidUserInput();
        double temperatureValue = getTemperatureValue(userInput);
        boolean isCelsius = isCelsius(userInput);

        System.out.println(
                "The current temperature is: "
                + temperatureValue
                + " and that value is celsius? "
                + isCelsius
        );
    }

}
