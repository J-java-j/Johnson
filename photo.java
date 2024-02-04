import java.io.*;
import java.util.*;

public class photo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("photo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));

        int N = Integer.parseInt(br.readLine());
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Try all possible starting values for a1
        for (int a1 = 1; a1 <= N; a1++) {
            int[] a = new int[N];
            a[0] = a1;
            Set<Integer> used = new HashSet<>();
            used.add(a1);
            boolean isValid = true;

            // Calculate the permutation based on the starting value
            for (int i = 1; i < N; i++) {
                a[i] = b[i - 1] - a[i - 1];
                // Check if the number is out of range or already used
                if (a[i] < 1 || a[i] > N || used.contains(a[i])) {
                    isValid = false;
                    break;
                }
                used.add(a[i]);
            }

            // If a valid permutation is found, print it and break
            if (isValid) {
                for (int i = 0; i < N; i++) {
                    pw.print(a[i] + (i < N - 1 ? " " : "\n"));
                }
                break;
            }
        }

        pw.close();
    }
}
