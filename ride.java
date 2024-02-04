/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: johnson42
LANG: JAVA
PROB: ride
*/
import java.io.*;
import java.util.*;

public class ride  {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader reader = new BufferedReader(new FileReader("ride.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(reader.readLine());
        String comet = st.nextToken();

        st  = new StringTokenizer(reader.readLine());
        String group = st.nextToken();

        // Get line, break into tokens
        // String comet = reader.readLine();
        // String group = reader.readLine();

        if (calculateProduct(comet) % 47 == calculateProduct(group) % 47) {
            out.println("GO");
        }else{
            out.println("STAY");
        }
        out.close();
    }



    public static int calculateProduct(String name){
        int product = 1;
        char[] nameChars = name.toCharArray();
        for (char c : nameChars){
            product *= (c -'A' +1);
        }
        return product;
    }
}

