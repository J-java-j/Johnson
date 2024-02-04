
import java.io.*;
import java.util.*;

    public class balancing {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] x = new int[N];
            int[] y = new int[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
            }
            br.close();

            int M = N; // Start with the maximum possible value of M
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int fenceX = x[i] + 1;
                    int fenceY = y[j] + 1;

                    int[] quadrant = new int[4];
                    for (int k = 0; k < N; k++) {
                        int qx = x[k] < fenceX ? 0 : 1;
                        int qy = y[k] < fenceY ? 0 : 2;
                        quadrant[qx + qy]++;
                    }

                    int localM = Math.max(Math.max(quadrant[0], quadrant[1]), Math.max(quadrant[2], quadrant[3]));
                    M = Math.min(M, localM);
                }
            }

            pw.println(M);
            pw.close();
        }
    }


   /* Read the input from a file using BufferedReader.
        Parse the input and store the cow coordinates in a suitable data structure, like an array or list.
        Determine the optimal position for the fences that minimizes M, the maximum number of cows in any one of the four regions after partitioning.
        Write the result to an output file using PrintWriter.*/