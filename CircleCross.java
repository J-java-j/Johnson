import java.io.*;
import java.util.*;

public class CircleCross {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));

        String s = br.readLine();
        int crossings = 0;

        // Using a map to store the index of the first occurrence of each letter
        Map<Character, Integer> firstOccurrence = new HashMap<>();

        // Iterate through the characters in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If we have not seen this character before, store its index
            if (!firstOccurrence.containsKey(c)) {
                firstOccurrence.put(c, i);
            } else {
                // If we have seen this character, check for crossings
                for (char other = 'A'; other <= 'Z'; other++) {
                    // Ignore the same character and characters not yet seen
                    if (other == c || !firstOccurrence.containsKey(other)) continue;

                    // Get the index of the first occurrence of the other character
                    int otherIndex = firstOccurrence.get(other);

                    // If the first occurrence of the other character is after the first occurrence of c
                    // and before the current index of c, we have a crossing
                    if (otherIndex > firstOccurrence.get(c) && otherIndex < i) {
                        crossings++;
                    }
                }
                // Remove the character from the map after processing its crossings
                firstOccurrence.remove(c);
            }
        }

        pw.println(crossings);
        pw.close();
        br.close();
    }
}



/*
Iterate through the string and record the indices of the first and second occurrence of each cow.
For each cow
a, count the number of cows
b such that
b's first occurrence is between
a's first and second occurrence, and
b's second occurrence is outside
a's pair.
Divide the total count by 2, since each pair is counted twice.
 */