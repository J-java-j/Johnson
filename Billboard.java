import java.io.*;
import java.util.*;

public class Billboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        int[] lawn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cow = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Calculate the full area of the lawnmower billboard
        int lawnArea = (lawn[2] - lawn[0]) * (lawn[3] - lawn[1]);

        // Initialize variables to represent the covered areas on the lawnmower billboard by the cow feed billboard
        int coverTop = 0;
        int coverBottom = 0;
        int coverLeft = 0;
        int coverRight = 0;

        // Check if the cow billboard covers the lawnmower billboard horizontally
        if (cow[1] <= lawn[1] && cow[3] >= lawn[3]) {
            // Cow billboard is tall enough to cover the lawn billboard vertically
            // Check for horizontal coverage
            if (cow[0] <= lawn[0] && cow[2] < lawn[2]) {
                // Cow billboard covers the left part of the lawn billboard
                coverLeft = (cow[2] - lawn[0]) * (lawn[3] - lawn[1]);
            } else if (cow[2] >= lawn[2] && cow[0] > lawn[0]) {
                // Cow billboard covers the right part of the lawn billboard
                coverRight = (lawn[2] - cow[0]) * (lawn[3] - lawn[1]);
            } else if (cow[0] <= lawn[0] && cow[2] >= lawn[2]) {
                // Cow billboard covers the entire lawn billboard
                coverLeft = lawnArea;
            }
        }

        // Check if the cow billboard covers the lawnmower billboard vertically
        if (cow[0] <= lawn[0] && cow[2] >= lawn[2]) {
            // Cow billboard is wide enough to cover the lawn billboard horizontally
            // Check for vertical coverage
            if (cow[1] <= lawn[1] && cow[3] < lawn[3]) {
                // Cow billboard covers the bottom part of the lawn billboard
                coverBottom = (lawn[2] - lawn[0]) * (cow[3] - lawn[1]);
            } else if (cow[3] >= lawn[3] && cow[1] > lawn[1]) {
                // Cow billboard covers the top part of the lawn billboard
                coverTop = (lawn[2] - lawn[0]) * (lawn[3] - cow[1]);
            } else if (cow[1] <= lawn[1] && cow[3] >= lawn[3]) {
                // Cow billboard covers the entire lawn billboard
                coverBottom = lawnArea;
            }
        }

        // Calculate the minimum tarp area needed
        int tarpArea = lawnArea - Math.max(coverTop, Math.max(coverBottom, Math.max(coverLeft, coverRight)));

        pw.println(tarpArea);
        br.close();
        pw.close();
    }
}







/*
1.read the coordiantes of the two billbaord
2.calculate the area of the lawn mower billboard
3.determine the voerlaping area between the co feed billboard and the lawn mower billboard.
4.substract the overlap from the lawn mower billboard's area to fint eh minimum tarp size needed
 */
