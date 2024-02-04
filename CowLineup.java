/*
1. Read input hard code the cows in order and constraints
2. Store the constraints in a hashmap
3. Iterate the hashmap
* */
import java.io.*;
import java.util.*;

public class CowLineup {

    private static final String[] COWS = {
            "Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"
    };

    private static List<String[]> constraints;

    public static void main(String[] args) throws IOException {
        // Read input constraints
        constraints = new ArrayList<>();
        Scanner sc = new Scanner(new File("lineup.in"));
        int N = sc.nextInt();
        sc.nextLine(); // skip the rest of the line
        for (int i = 0; i < N; i++) {
            constraints.add(sc.nextLine().split(" must be milked beside "));
        }
        sc.close();

        // Generate all permutations of cows
        List<String> cows = Arrays.asList(COWS);
        List<List<String>> permutations = generatePermutations(cows);

        // Filter permutations to find valid orderings
        List<List<String>> validOrderings = new ArrayList<>();
        for (List<String> perm : permutations) {
            if (isValidOrdering(perm)) {
                validOrderings.add(perm);
            }
        }

        // Find the alphabetically first valid ordering
        Collections.sort(validOrderings, new Comparator<List<String>>() {
            public int compare(List<String> o1, List<String> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    int cmp = o1.get(i).compareTo(o2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return 0;
            }
        });

        // Write the first valid ordering to the output file
        PrintWriter pw = new PrintWriter(new FileWriter("lineup.out"));
        for (String cow : validOrderings.get(0)) {
            pw.println(cow);
        }
        pw.close();
    }

    // Method to check if a permutation satisfies all constraints
    private static boolean isValidOrdering(List<String> perm) {
        for (String[] constraint : constraints) {
            int pos1 = perm.indexOf(constraint[0]);
            int pos2 = perm.indexOf(constraint[1]);
            if (Math.abs(pos1 - pos2) != 1) {
                return false;
            }
        }
        return true;
    }

    // Method to generate all permutations of a list of strings
    private static List<List<String>> generatePermutations(List<String> list) {
        if (list.isEmpty()) {
            List<List<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        List<List<String>> returnMe = new ArrayList<>();
        String firstElement = list.remove(0);
        List<List<String>> recursiveReturn = generatePermutations(list);
        for (List<String> li : recursiveReturn) {
            for (int index = 0; index <= li.size(); index++) {
                List<String> temp = new ArrayList<>(li);
                temp.add(index, firstElement);
                returnMe.add(temp);
            }
        }
        return returnMe;
    }
}
