/*
ID: johnson42
LANG: JAVA
TASK: transform
        */

import java.io.*;
import java.util.*;

public class transform {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader("transform.in"));
            PrintWriter pw = new PrintWriter(new FileWriter("transform.out"));
            int N = Integer.parseInt(br.readLine());
            char[][] before = new char[N][N];
            char[][] after = new char[N][N];

            for (int i = 0; i < N; i++) {
                before[i] = br.readLine().toCharArray();
            }
            for (int i = 0; i < N; i++) {
                after[i] = br.readLine().toCharArray();
            }

            if (isEqual(rotate90(before), after)) {
                pw.println(1);
            } else if (isEqual(rotate180(before), after)) {
                pw.println(2);
            } else if (isEqual(rotate270(before), after)) {
                pw.println(3);
            } else if (isEqual(reflect(before), after)) {
                pw.println(4);
            } else if (isEqual(rotate90(reflect(before)), after)) {
                pw.println(5);
            } else if (isEqual(rotate180(reflect(before)), after)) {
                pw.println(5);
            } else if (isEqual(rotate270(reflect(before)), after)) {
                pw.println(5);
            } else if (isEqual(before, after)) {
                pw.println(6);
            } else {
                pw.println(7);
            }

            pw.close();
            br.close();
        }

        private static char[][] rotate90(char[][] square) {
            int N = square.length;
            char[][] result = new char[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result[j][N - 1 - i] = square[i][j];
                }
            }
            return result;
        }

        private static char[][] rotate180(char[][] square) {
            return rotate90(rotate90(square));
        }

        private static char[][] rotate270(char[][] square) {
            return rotate90(rotate180(square));
        }

        private static char[][] reflect(char[][] square) {
            int N = square.length;
            char[][] result = new char[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result[i][N - 1 - j] = square[i][j];
                }
            }
            return result;
        }

        private static boolean isEqual(char[][] a, char[][] b) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    if (a[i][j] != b[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }





/*
1. read input
2. define transformation implement the ducntion for each
3. check transformation apply each tranformation to the orignal pattern and check to see fi it matche with end result keep track of the
the minumum transformation number
4. output

 */