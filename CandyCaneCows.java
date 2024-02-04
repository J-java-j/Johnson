import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class CandyCaneCows {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // Number of cows
        int M = Integer.parseInt(firstLine[1]); // Number of candy canes

        String[] cowHeightsStr = br.readLine().split(" ");
        long[] cowHeights = new long[N];
        for (int i = 0; i < N; i++) {
            cowHeights[i] = Long.parseLong(cowHeightsStr[i]);
        }

        String[] caneHeightsStr = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            long caneHeight = Long.parseLong(caneHeightsStr[i]);

            for (int j = 0; j < N; j++) {
                if (cowHeights[j] < caneHeight) {
                    // The cow can't reach the candy cane, so it eats nothing.
                    continue;
                }

                // The cow eats up to its height from the candy cane.
                long eaten = Math.min(cowHeights[j], caneHeight);
                cowHeights[j] += eaten;
                caneHeight -= eaten;

                if (caneHeight <= 0) {
                    // The candy cane is finished.
                    break;
                }
            }
        }

        for (long cowHeight : cowHeights) {
            pw.println(cowHeight);
        }

        pw.flush();
        pw.close();
        br.close();
    }
}
