import java.io.*;
import java.util.*;

public class race {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("race.in"));
        PrintWriter out = new PrintWriter(new File("race.out"));

        int k = in.nextInt();
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            out.println(time(k, x));
        }

        in.close();
        out.close();
    }

    static int time(int dis, int max_speed){
        int speedup_dis = 0;
        int speeddown_dis = 0;
        int time = 0;

        int speed = 1;
        while(true){
            speedup_dis += speed;
            time ++;
            if (speedup_dis + speeddown_dis >= dis)
                return time;

            if(speed >= max_speed){
                speeddown_dis += speed;
                time ++;
                if(speedup_dis + speeddown_dis >= dis)
                    return time;
            }

            speed ++;
        }

    }
    static int minTime(int k, int x) {

        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;


        for (int i = 1; i <= k; i++) {
            // Iterate from 1 to x for smaller jumps
            for (int j = 1; j <= Math.min(i, x); j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + 1);
            }
            // Check if using all remaining speed at once is faster
            if (i - x >= 0) {
                dp[i] = Math.min(dp[i], dp[i - x] + 1);
            }
        }

        return dp[k];
    }
}






/**Read the input, K and N
 * For each X, determine the minimum time by simulation:
 * 1. start with 0m/s, increase the speed per second to minimize the time, keep track of the distance traveled: d += vi*t = vi
 * 2. If the speed is below the speed limit, keep accumulating the distance, compare with the length of race
 * 3. However, if the speed is above the speed limit already, we need to decelerate, therefore, the distance for slowing down is required
 * 4. Distance of deceleration can be calculated by adding the curr speed to the decel_distance variable, d_dc += vi*t = vi
 * 5. Add these two distance together and compare with the of the race during each second, if higher than K, return time
 * */
