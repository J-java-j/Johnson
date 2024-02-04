import java.io.*;
import java.util.*;

public class Blocks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("blocks.out"));
        int N = Integer.parseInt(br.readLine());
        int[] letterCounts = new int[26]; // For storing the counts of each letter

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String firstWord = st.nextToken();
            String secondWord = st.nextToken();

            int[] firstWordCount = new int[26];
            int[] secondWordCount = new int[26];

            // Count the letters in the first word
            for (char c : firstWord.toCharArray()) {
                firstWordCount[c - 'a']++;
            }

            // Count the letters in the second word
            for (char c : secondWord.toCharArray()) {
                secondWordCount[c - 'a']++;
            }

            // Take the maximum count for each letter
            for (int j = 0; j < 26; j++) {
                letterCounts[j] += Math.max(firstWordCount[j], secondWordCount[j]);
            }
        }

        // Write the counts to the output file
        for (int count : letterCounts) {
            pw.println(count);
        }

        br.close();
        pw.close();
    }
}
