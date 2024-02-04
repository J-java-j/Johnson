/*
ID: johnson42
LANG: JAVA
TASK: beads
        */
import java.io.*;
import java.util.*;
class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int N = Integer.parseInt(f.readLine());
        String necklace = f.readLine();

        // Double the necklace to simulate the circular nature
        necklace += necklace;

        int maxBeads = 0;

        // Iterate over all possible break points
        for (int i = 0; i < N; i++) {
            int left = i, right = i + 1;
            char leftColor = 'w', rightColor = 'w';
            int count = 0;

            // Collect beads from the left of the break point
            while (left >= 0 && (necklace.charAt(left) == 'w' || necklace.charAt(left) == leftColor || leftColor == 'w')) {
                if (leftColor == 'w' && necklace.charAt(left) != 'w') {
                    leftColor = necklace.charAt(left);
                }
                count++;
                left--;
            }

            // Collect beads from the right of the break point
            while (right < 2 * N && (necklace.charAt(right) == 'w' || necklace.charAt(right) == rightColor || rightColor == 'w')) {
                if (rightColor == 'w' && necklace.charAt(right) != 'w') {
                    rightColor = necklace.charAt(right);
                }
                count++;
                right++;
            }

            // Update the maximum
            maxBeads = Math.max(maxBeads, count);
        }

        // Ensure we don't count more beads than there are in the original necklace
        maxBeads = Math.min(maxBeads, N);

        out.println(maxBeads);
        out.close();
    }
}
