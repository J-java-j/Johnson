import java.util.Scanner;
import java.lang.Math;

public class InfectionSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline


        String finalState = scanner.nextLine();

        int minInfected = calculateMinInfected(N, finalState);
        System.out.println( minInfected);

        scanner.close();
    }

    public static int calculateMinInfected(int N, String finalState) {
        String[] groups = finalState.trim().split("0");
        int totalInitialInfected = 0;

        for (String group : groups) {
            int length = group.length();
            if (length == 0) continue; // Skip empty groups

            int nights = (length > 1) ? (length - 1) / 2 : 0;
            int initiallyInfected = (int) Math.ceil((double) length / (2 * nights + 1));
            totalInitialInfected += initiallyInfected;
        }

        return totalInitialInfected;
    }
}
