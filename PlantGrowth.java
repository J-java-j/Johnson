import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PlantGrowth {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out, true);

        int N = Integer.parseInt(reader.readLine());
        int[] heights = new int[N];
        int[] growthRates = new int[N];
        int[] targets = new int[N];

        String[] heightsInput = reader.readLine().split(" ");
        String[] growthRatesInput = reader.readLine().split(" ");
        String[] targetsInput = reader.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(heightsInput[i]);
            growthRates[i] = Integer.parseInt(growthRatesInput[i]);
            targets[i] = Integer.parseInt(targetsInput[i]);
        }

        int result = findMinDays(N, heights, growthRates, targets);
        writer.println(result);

        reader.close();
        writer.close();
    }

    public static int findMinDays(int N, int[] initialHeights, int[] growthRates, int[] targets) {
        int maxDays = -1;
        for (int i = 0; i < N; i++) {
            int days = minDaysForPlant(i, N, initialHeights, growthRates, targets);
            if (days == -1) {
                return -1;
            }
            maxDays = Math.max(maxDays, days);
        }
        return maxDays;
    }

    private static int minDaysForPlant(int index, int N, int[] heights, int[] growthRates, int[] targets) {
        int days = 0;
        while (true) {
            int tallerPlants = 0;
            for (int i = 0; i < N; i++) {
                if (heights[i] + days * growthRates[i] > heights[index] + days * growthRates[index]) {
                    tallerPlants++;
                }
            }
            if (tallerPlants == targets[index]) {
                break;
            }
            days++;
            if (days > 1e6) { // to prevent infinite loops
                return -1;
            }
        }
        return days;
    }
}
