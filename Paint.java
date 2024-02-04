import java.io.*;

public class Paint {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "paint.in"; // Replace with the actual input file path
        String outputFilePath = "paint.out"; // Replace with the actual output file path

        BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)));

        // Read the intervals from the input file
        String[] firstInterval = br.readLine().split(" ");
        String[] secondInterval = br.readLine().split(" ");

        int a = Integer.parseInt(firstInterval[0]);
        int b = Integer.parseInt(firstInterval[1]);
        int c = Integer.parseInt(secondInterval[0]);
        int d = Integer.parseInt(secondInterval[1]);

        br.close(); // Close the BufferedReader

        // Calculate the total painted length considering overlapping intervals
        int start = Math.min(a, c); // Start of the painted fence
        int end = Math.max(b, d);   // End of the painted fence

        // Calculate the total covered length
        int totalLength = (b - a) + (d - c);

        // Subtract the overlapping part if the intervals overlap
        if (Math.max(a, c) < Math.min(b, d)) {
            totalLength -= (Math.min(b, d) - Math.max(a, c));
        }

        // Write the result to the output file
        writer.println(totalLength);
        writer.close(); // Close the PrintWriter
    }
}
