import java.io.*;
import java.util.StringTokenizer;

public class USACOTeleport {
    public static void main(String[] args)throws IOException {
        //Reading inputs
        BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        //calculating distances
        int directDistance = Math.abs(a - b);
        int teleportation1 = Math.abs(a - x) + Math.abs(y-b);
        int teleportation2 = Math.abs(a - y) + Math.abs(b -x);

        int minD = Math.min(directDistance, Math.min(teleportation1, teleportation2));

        //Writing the output
       /* BufferedWriter writer = new BufferedWriter(new FileWriter("teleport.out"));
        writer.write(minD);
        writer.close();*/

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
        writer.println(minD);
        writer.close();


    }

}