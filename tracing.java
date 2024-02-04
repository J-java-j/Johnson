import java.io.*;
import java.util.*;

public class tracing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("tracing.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tracing.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        String initialState = br.readLine();
        List<Interaction> interactions = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            interactions.add(new Interaction(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        // Sort interactions by time
        Collections.sort(interactions);

        int possibleZeros = 0;
        int minK = Integer.MAX_VALUE;
        int maxK = -1;

        for (int i = 1; i <= N; i++) {
            for (int K = 0; K <= T; K++) {
                boolean[] infected = new boolean[N + 1];
                int[] shakesLeft = new int[N + 1];
                Arrays.fill(shakesLeft, K);

                infected[i] = true; // Assume cow i is patient zero
                simulateSpread(interactions, infected, shakesLeft);

                if (matches(initialState, infected)) {
                    possibleZeros++;
                    minK = Math.min(minK, K);
                    break; // Found a valid K for cow i, no need to check smaller K values
                }
            }
            for (int K = T; K >= 0; K--) {
                boolean[] infected = new boolean[N + 1];
                int[] shakesLeft = new int[N + 1];
                Arrays.fill(shakesLeft, K);

                infected[i] = true; // Assume cow i is patient zero
                simulateSpread(interactions, infected, shakesLeft);

                if (matches(initialState, infected)) {
                    maxK = Math.max(maxK, K);
                    break; // Found a valid K for cow i, no need to check larger K values
                }
            }
        }

        pw.println(possibleZeros + " " + (minK == Integer.MAX_VALUE ? 0 : minK) + " " + (maxK == -1 ? "Infinity" : maxK));
        pw.close();
        br.close();
    }

    private static void simulateSpread(List<Interaction> interactions, boolean[] infected, int[] shakesLeft) {
        for (Interaction interaction : interactions) {
            if (infected[interaction.x] && shakesLeft[interaction.x] > 0) {
                infected[interaction.y] = true;
                shakesLeft[interaction.x]--;
            }
            if (infected[interaction.y] && shakesLeft[interaction.y] > 0) {
                infected[interaction.x] = true;
                shakesLeft[interaction.y]--;
            }
        }
    }

    private static boolean matches(String initialState, boolean[] infected) {
        for (int i = 0; i < initialState.length(); i++) {
            if ((initialState.charAt(i) == '1') != infected[i + 1]) {
                return false;
            }
        }
        return true;
    }

    static class Interaction implements Comparable<Interaction> {
        int time, x, y;

        public Interaction(int time, int x, int y) {
            this.time = time;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Interaction o) {
            return Integer.compare(this.time, o.time);
        }
    }
}


/*
Read the input from tracing.in using BufferedReader.
Parse the input and store the necessary information.
Implement the logic to determine the possible patient zero candidates and the number of hoof shakes (K) after which a cow no longer passes the infection.
Keep track of the infection spread through the interactions to determine the maximum possible K.
Write the results to tracing.out using PrintWriter.
 */
