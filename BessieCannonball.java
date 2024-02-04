import java.io.*;
import java.util.*;

public class BessieCannonball {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int S = Integer.parseInt(firstLine[1]);

        int[] locations = new int[N + 1]; // Using 1-indexed for convenience
        boolean[] isJumpPad = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            isJumpPad[i] = Integer.parseInt(line[0]) == 0;
            locations[i] = Integer.parseInt(line[1]);
        }

        int position = S;
        int power = 1;
        int direction = 1; // Start going right
        int brokenTargets = 0;
        boolean[] broken = new boolean[N + 1]; // To keep track of broken targets

        // Start bouncing
        while (position > 0 && position <= N) {
            if (!isJumpPad[position] && locations[position] <= power) {
                // Break the target if not already broken
                if (!broken[position]) {
                    brokenTargets++;
                    broken[position] = true;
                }
            } else if (isJumpPad[position]) {
                // Reverse direction and increase power on a jump pad
                power += locations[position];
                direction = -direction;
            }

            position += power * direction; // Make the next bounce
        }

        System.out.println(brokenTargets);
    }
}
