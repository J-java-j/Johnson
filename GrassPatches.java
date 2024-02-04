import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class GrassPatches {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());
        long[] bacteriaLevels = new long[N];
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            bacteriaLevels[i] = Long.parseLong(inputs[i]);
        }

        long totalApplications = calculateMinimumApplications(N, bacteriaLevels);

        pw.println(totalApplications);
        pw.flush();
        pw.close();
        br.close();
    }

    private static long calculateMinimumApplications(int N, long[] bacteriaLevels) {
        long totalApplications = 0;
        long cumulativeEffect = 0;

        for (int i = N - 1; i >= 0; i--) {
            long adjustment = bacteriaLevels[i] + cumulativeEffect;
            if (adjustment != 0) {
                totalApplications += Math.abs(adjustment);
                cumulativeEffect += adjustment;
            }
        }

        return totalApplications;
    }
}

