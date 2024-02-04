import java.io.*;
import java.util.*;

public class cownomics {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] spotty = new char[N][M];
        char[][] plain = new char[N][M];

        for (int i = 0; i < N; i++) spotty[i] = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) plain[i] = br.readLine().toCharArray();

        int count = 0;
        for (int a = 0; a < M; a++) {
            for (int b = a + 1; b < M; b++) {
                for (int c = b + 1; c < M; c++) {
                    if (isUniqueCombo(spotty, plain, N, a, b, c)) {
                        count++;
                    }
                }
            }

        }
        pw.println(count);
        br.close();
        pw.close();
    }

    private static boolean isUniqueCombo(char[][] spotty, char[][] plain, int N, int a, int b, int c) {
    Set<String> spottyPatterns = new HashSet<>();
    Set<String> plainPatterns = new HashSet<>();

    for (int i = 0; i <N; i++){
        String patterns =""+spotty[i][a]+spotty[i][b]+spotty[i][c];
        spottyPatterns.add(patterns);
    }

    for (int i = 0; i<N;i++){
        String patterns =""+plain[i][a]+plain[i][b]+plain[i][c];
        if(spottyPatterns.contains(patterns)){
            return false;
        }
        //plainPatterns.add(patterns);
    }
    /*for (String patterns: spottyPatterns){
        if (plainPatterns.contains(patterns)){
            return false;
        }
    }*/
    return true;

}
}

/*
1. read the input
initalize the data structure
3. oriocess each of the three combination
4. check uniquness of each combination
5. determin the uniquness of the ocmbination
6. output
 */