import java.io.*;
import java.util.StringTokenizer;

public class Gymnastics {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] rankings = new int[K][N];

        // Read the rankings for K sessions
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                rankings[i][Integer.parseInt(st.nextToken()) - 1] = j;
            }
        }

        int consistentPairs = 0;

        // Compare all pairs of cows
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                boolean iConsistentlyBetter = true;
                boolean jConsistentlyBetter = true;

                // Check every session to determine if one cow is consistently ranked above the other
                for (int[] ranking : rankings) {
                    if (ranking[i] > ranking[j]) {
                        iConsistentlyBetter = false;
                    }
                    if (ranking[i] < ranking[j]) {
                        jConsistentlyBetter = false;
                    }
                }

                // If one cow is consistently better than the other, count the pair
                if (iConsistentlyBetter || jConsistentlyBetter) {
                    consistentPairs++;
                }
            }
        }

        pw.println(consistentPairs);
        pw.close();
        br.close();
    }
}




/*
Reads the number of sessions and cows from the input file.
Initializes an array to hold the rankings from each session.
Reads the rankings for each session into the array.
Compares each possible pair of cows to determine if they form a consistent pair across all sessions.
Counts the number of consistent pairs.
Writes the count to the output file.
 */