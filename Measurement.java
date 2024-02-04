import java.io.*;
import java.util.*;

public class Measurement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("measurement.out"));

        int N = Integer.parseInt(br.readLine());

        String[] cows = {"Bessie", "Elsie", "Mildred"};
        Map<String, Integer> cowIndex = new HashMap<>();

        Map<String, Integer> milkOutput = new HashMap<>();

        int index = 0;
        for(String cow: cows){
            milkOutput.put(cow, 7);
            cowIndex.put(cow, index);
            index ++;}

        List<int[]> logs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            String cow = st.nextToken();
            int change = Integer.parseInt(st.nextToken());
            //logs.add(new int[]{day, "Bessie".equals(cow) ? 0 : "Elsie".equals(cow) ? 1 : 2, change});
            logs.add(new int[]{day, cowIndex.get(cow),change});
        }

        logs.sort(Comparator.comparingInt(a -> a[0]));

        Set<String> display = milkOutput.keySet();
        int displayChanges = 0;
        int maxOutput = 7;

        for (int[] log : logs) {
            String cow = cows[log[1]];
            milkOutput.put(cow, milkOutput.get(cow) + log[2]);

            int currentMaxOutput = Collections.max(milkOutput.values());
            Set<String> currentDisplay = new HashSet<>();

            for (String key : milkOutput.keySet()) {
                if (milkOutput.get(key) == currentMaxOutput) {
                    currentDisplay.add(key);
                }
            }

            if (!currentDisplay.equals(display) || (currentMaxOutput != maxOutput && !currentDisplay.containsAll(display))) {
                maxOutput = currentMaxOutput;
                displayChanges++;
                display = currentDisplay;
            }
        }

        bw.write(String.valueOf(displayChanges));
        br.close();
        bw.close();
    }
}



/*
Parse Inputs:

Read the number of entries N.
For each entry, read the day, the cow's name, and the change in milk output.
Initialize Data Structures:

Use a HashMap to keep track of each cow's total milk output.
Initialize all cows with the starting milk output
Process Changes:

For each measurement, update the cow's milk output in the HashMap.
Determine the cow(s) with the highest milk output after each update.
Track Display Changes:

Keep track of the current set of cows on display (those with the highest output)..
Output Result:

After processing all entries, output the counter value which represents the number of days
 */