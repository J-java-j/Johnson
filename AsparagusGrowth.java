import java.util.*;
import java.io.*;

public class AsparagusGrowth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            long[] hi = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
            long[] ai = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
            int[] ti = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            long days = calculateDays(N, hi, ai, ti);
            out.println(days);
        }

        out.flush();
        out.close();
    }

    private static long calculateDays(int N, long[] hi, long[] ai, int[] ti) {
        long[] daysRequired = new long[N];
        Arrays.fill(daysRequired, -1); // Initialize with -1, meaning impossible until proven otherwise.

        Plant[] plants = new Plant[N];
        for (int i = 0; i < N; i++) {
            plants[i] = new Plant(hi[i], ai[i], i);
        }

        // Sort by potential height on day 0, break ties with growth rate
        Arrays.sort(plants, (p1, p2) -> {
            int cmp = Long.compare(p1.height, p2.height);
            if (cmp == 0) {
                return Long.compare(p1.growth, p2.growth);
            }
            return cmp;
        });

        for (int i = 0; i < N; i++) {
            long requiredHeight = plants[ti[i]].height;
            long days = 0;
            if (ti[i] < i) {
                days = (requiredHeight - hi[i] + ai[i] - 1) / ai[i]; // Ceiling division
            }
            daysRequired[plants[i].index] = days;
        }

        // Now, we need to check if the calculated days are actually valid
        for (int i = 0; i < N; i++) {
            int tallerPlants = 0;
            for (int j = 0; j < N; j++) {
                if (daysRequired[j] <= daysRequired[i]) {
                    tallerPlants++;
                }
            }
            // If the number of taller plants is not the desired one, return -1
            if (tallerPlants - 1 != ti[plants[i].index]) {
                return -1;
            }
        }

        // Find the max day which is the answer
        long maxDay = Arrays.stream(daysRequired).max().getAsLong();
        return maxDay;
    }

    static class Plant {
        long height;
        long growth;
        int index;

        Plant(long height, long growth, int index) {
            this.height = height;
            this.growth = growth;
            this.index = index;
        }
    }
}
