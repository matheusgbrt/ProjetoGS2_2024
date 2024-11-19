package Utils.Evaluator;

import java.util.Scanner;

public class ScannerUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    public static void resetScanner() {
        // Close the current scanner before creating a new one
        if (scanner != null) {
            scanner.close();
        }
        // Create a new instance of Scanner
        scanner = new Scanner(System.in);
    }
}
