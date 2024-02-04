import java.util.*;

public class line {
    // HashMap to store constraints where each cow is keyed to its adjacent cows
    private Map<String, List<String>> constraints = new HashMap<>();
    // TreeSet to keep cows sorted alphabetically
    private TreeSet<String> cows = new TreeSet<>(Arrays.asList("Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"));
    // List to store the final lineup
    private List<String> lineup = new ArrayList<>();

    // Method to add constraints
    public void addConstraint(String x, String y) {
        constraints.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
        constraints.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
    }

    // Recursive method to build the lineup respecting the constraints
    public boolean buildLineup(String cow) {
        lineup.add(cow);
        cows.remove(cow);

        if (lineup.size() == 8) return true; // All cows have been lined up

        List<String> nextCows = constraints.getOrDefault(cow, new ArrayList<>());
        nextCows.retainAll(cows); // Keep only cows that haven't been lined up yet

        for (String nextCow : nextCows) {
            if (buildLineup(nextCow)) return true;
        }

        for (String nextCow : cows) { // Try the next cow alphabetically
            if (buildLineup(nextCow)) return true;
        }

        lineup.remove(lineup.size() - 1); // Backtrack
        cows.add(cow);
        return false;
    }

    // Method to get the lineup
    public List<String> getLineup() {
        for (String cow : cows) {
            if (buildLineup(cow)) break;
        }
        return lineup;
    }

    // Main method to run the lineup process
    public static void main(String[] args) {
        line lineupSolver = new line();
        // Adding constraints as per the sample input
        lineupSolver.addConstraint("Buttercup", "Bella");
        lineupSolver.addConstraint("Blue", "Bella");
        lineupSolver.addConstraint("Sue", "Beatrice");

        // Getting the lineup
        List<String> finalLineup = lineupSolver.getLineup();
        // Printing the lineup
        finalLineup.forEach(System.out::println);
    }
}
