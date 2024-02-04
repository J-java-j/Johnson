import java.io.*;
import java.util.*;

public class FarmerJohnHayProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] hayInput = br.readLine().split(" ");
            int[] hayPreferences = new int[N];
            for (int i = 0; i < N; i++) {
                hayPreferences[i] = Integer.parseInt(hayInput[i]);
            }

            Set<Integer> possibleHays = findPossibleHays(N, hayPreferences);
            if (possibleHays.isEmpty()) {
                out.println(-1);
            } else {
                StringJoiner joiner = new StringJoiner(" ");
                possibleHays.stream().sorted().forEach(hay -> joiner.add(String.valueOf(hay)));
                out.println(joiner.toString());
            }
        }
        out.flush();
        out.close();
    }

    private static Set<Integer> findPossibleHays(int N, int[] hayPreferences) {
        Set<Integer> possibleHays = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int majorityHay = hayPreferences[i];
            int count = 1;
            for (int j = i + 1; j < N; j++) {
                if (hayPreferences[j] == majorityHay) {
                    count++;
                }
                if (count > (j - i + 1) / 2) {
                    possibleHays.add(majorityHay);
                    break;
                }
            }
        }
        return possibleHays;
    }
}
