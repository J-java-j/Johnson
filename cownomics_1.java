import java.io.*;
import java.util.*;

public class cownomics_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));

        String[] firstline = br.readLine().split(" ");
        int N = Integer.parseInt(firstline[0]);
        int M = Integer.parseInt(firstline[1]);

        char[][] spotty = new char[N][];
        char[][] plain = new char[N][];

        for (int i = 0; i < N; i++) spotty[i] = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) plain[i] = br.readLine().toCharArray();
        br.close();

        int count = 0;
        for (int i = 0; i < M; i++) {
            Map<Character, Boolean> spottyMap = new HashMap<>();
            Map<Character, Boolean> plainMap = new HashMap<>();

            for (int j = 0; j <N; j++) {
                spottyMap.put(spotty[j][i], true);
                plainMap.put(plain[j][i], true);
            }
            boolean isUnique = true;
            for (char nucleotide : spottyMap.keySet()) {
                if (plainMap.containsKey(nucleotide)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                count++;
            }
        }
        pw.println(count);
        pw.close();
    }
}

/*
1. Read the number of spotty anc plain cow, and the length oif their genomic sequences
2. store the genomics sequences of spotty cows and plain cows in separate arrays or lists
3. iterate over each position in the genomic sequences
4. For each position, check if there is a character (A,C,G or,T) that only appears in spotty cows and now in the
plain cows
5.keep count of such unique positions that could potentially explain spottiness
 */