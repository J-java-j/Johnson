import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class USACO2020problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         //input
        int[] number = new int[7];
        int index=0;
        while(st.hasMoreTokens()){
            number[index++] = Integer.parseInt(st.nextToken());
        }
        //Sort the numbers
        Arrays.sort(number);

        // the three smallest number will be A, B, abd C in some order
        int a = number[0];
        int b = number[1];
        int c = number[6] - a - b;

        System.out.println(a+" "+b+" "+c);



    }
}
