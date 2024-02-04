import java.io.*;
import java.util.StringTokenizer;

/*
ID: johnson42
LANG: JAVA
TASK: palsquare
        */
public class palsquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("palsquare.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        String numberInBaseB, squareInBaseB;

        for(int N = 1; N <= 300; N++){
            numberInBaseB = Integer.toString(N, B);
            squareInBaseB = Integer.toString(N * N, B);
            if(isPalindrome(numberInBaseB) && isPalindrome(squareInBaseB)){
                pw.println(numberInBaseB.toUpperCase() + " " + squareInBaseB.toUpperCase());
            }
        }
        pw.flush();
        pw.close();
        br.close();

    }
    private static boolean isPalindrome (String str){
        int left = 0;
        int right = str.length() -1;

        while(left< right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }

        }
        return true;
    }
}
/*
1. take an integer B as an input
2. find all integers N, where 1<= N <= 300
3. output these numbers and their palindromic squares in base B
 */