import java.io.*;
import java.util.StringTokenizer;

public class mixmilk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mixmilk.out"));

        int[][] buckets = new int[3][2];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buckets[i][0] = Integer.parseInt(st.nextToken()); // capacity
            buckets[i][1] = Integer.parseInt(st.nextToken()); // current amount
        }

        for (int i = 0; i < 100; i++) {
            int fromBucket = i % 3;
            int toBucket = (i + 1) % 3;
            int amountToPour = Math.min(buckets[fromBucket][1], buckets[toBucket][0] - buckets[toBucket][1]);

            // Perform the pour
            buckets[fromBucket][1] -= amountToPour;
            buckets[toBucket][1] += amountToPour;
        }

        // Write the final amount of milk in each bucket to the output file
        for (int i = 0; i < 3; i++) {
            pw.println(buckets[i][1]);
        }

        br.close();
        pw.close();
    }
}
