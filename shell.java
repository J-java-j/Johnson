import java.io.*;
import java.util.StringTokenizer;

public class shell {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("shell.out"));
       StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int [] scores = new int [3];
        int currentGuess;
        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            currentGuess = Integer.parseInt(st.nextToken()) - 1;

            int temp = scores[a];
            scores[a]=scores[b];
            scores[b] =temp;
            scores[currentGuess]++;
        }
        int maxScore = Math.max(scores[0], Math.max(scores[1],scores[2]));
        pw.println(maxScore);
        br.close();
        pw.close();
    }
}
