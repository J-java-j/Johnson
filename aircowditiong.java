import java.util.*;

class Cow {
    int start;
    int end;
    int coolingNeeded;

    public Cow(int start, int end, int coolingNeeded) {
        this.start = start;
        this.end = end;
        this.coolingNeeded = coolingNeeded;
    }
}

class AirConditioner {
    int start;
    int end;
    int coolingPower;
    int cost;

    public AirConditioner(int start, int end, int coolingPower, int cost) {
        this.start = start;
        this.end = end;
        this.coolingPower = coolingPower;
        this.cost = cost;
    }
}

public class aircowditiong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            cows[i] = new Cow(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        AirConditioner[] airConditioners = new AirConditioner[M];
        for (int i = 0; i < M; i++) {
            airConditioners[i] = new AirConditioner(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        // Sort the air conditioners by their starting stall number
        Arrays.sort(airConditioners, Comparator.comparingInt(a -> a.start));

        int totalCost = 0;
        // We will need to track which cows have been satisfied
        boolean[] satisfied = new boolean[N];

        // Iterate through the air conditioners
        for (AirConditioner ac : airConditioners) {
            // Check each cow to see if this air conditioner can cool it
            for (int i = 0; i < N; i++) {
                if (!satisfied[i] && cows[i].start >= ac.start && cows[i].end <= ac.end && cows[i].coolingNeeded <= ac.coolingPower) {

                    satisfied[i] = true;
                    totalCost += ac.cost;
                    break;
                }
            }
        }


        for (boolean s : satisfied) {
            if (!s) {

                System.out.println("Cannot satisfy all cows");
                return;
            }
        }

        System.out.println(totalCost);
        scanner.close();
    }
}






/*
parse the input tp pbtaint he number of cows(N), the number of air condtioners(M), and their respective renges and costs
use recursion to generate all posible subsets of air conditioners.
check if a subset covers all stalls ad calculate the cost
keep track of the minimum cost


 */