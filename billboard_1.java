
import java.io.*;
import java.awt.Rectangle;

public class billboard_1 {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "billboard.in"; // Replace with the actual input file path
        String outputFilePath = "billboard.out"; // Replace with the actual output file path

        BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)));

        // Read the coordinates for the first billboard
        String[] line1 = br.readLine().split(" ");
        Rectangle billboard1 = new Rectangle(Integer.parseInt(line1[0]), Integer.parseInt(line1[1]),
                Integer.parseInt(line1[2]) - Integer.parseInt(line1[0]),
                Integer.parseInt(line1[3]) - Integer.parseInt(line1[1]));

        // Read the coordinates for the second billboard
        String[] line2 = br.readLine().split(" ");
        Rectangle billboard2 = new Rectangle(Integer.parseInt(line2[0]), Integer.parseInt(line2[1]),
                Integer.parseInt(line2[2]) - Integer.parseInt(line2[0]),
                Integer.parseInt(line2[3]) - Integer.parseInt(line2[1]));

        // Read the coordinates for the truck
        String[] line3 = br.readLine().split(" ");
        Rectangle truck = new Rectangle(Integer.parseInt(line3[0]), Integer.parseInt(line3[1]),
                Integer.parseInt(line3[2]) - Integer.parseInt(line3[0]),
                Integer.parseInt(line3[3]) - Integer.parseInt(line3[1]));

        br.close(); // Close the BufferedReader

        int visibleArea = billboard1.width * billboard1.height + billboard2.width * billboard2.height;

        // Subtract the area covered by the truck from each billboard
        Rectangle intersection1 = billboard1.intersection(truck);
        Rectangle intersection2 = billboard2.intersection(truck);

        // Only subtract the area if the truck actually covers part of the billboard
        if (billboard1.intersects(truck)) {
            visibleArea -= intersection1.width * intersection1.height;
        }
        if (billboard2.intersects(truck)) {
            visibleArea -= intersection2.width * intersection2.height;
        }

        // Write the result to the output file
        writer.println(visibleArea);
        writer.close(); // Close the PrintWriter
    }
}
