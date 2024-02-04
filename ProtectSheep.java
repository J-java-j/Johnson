/*
1. read input (The numbers of columns and rows0)
2.initialize an R abd c grid representing the pasture.
3. for each row in the pasture
    a. read the row input
    b. convert to char array and set to each row
    c. iterate the char array and save sheep locations
    d. check the number of wolves
  4. if there is no wolves, print YES and original grid
  5. iterate all sheep, check adj cells contains wolves or not,
    if yes -> not possible
    else put dogs around sheep (empty cell)
 */
import java.util.Scanner;
import java.util.ArrayList;

public class ProtectSheep {

    private static final char SHEEP = 'S';
    private static final char WOLF = 'W';
    private static final char DOG = 'D';
    private static final char EMPTY = '.';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();
        int C = scanner.nextInt();
        scanner.nextLine(); // consume the rest of the line

        char[][] pasture = new char[R][C];
        ArrayList<int[]> sheepLocations = new ArrayList<>();
        boolean wolvesPresent = false;

        for (int i = 0; i < R; i++) {
            String row = scanner.nextLine();
            pasture[i] = row.toCharArray();
            for (int j = 0; j < C; j++) {
                if (pasture[i][j] == SHEEP) {
                    sheepLocations.add(new int[]{i, j});
                } else if (pasture[i][j] == WOLF) {
                    wolvesPresent = true;
                }
            }
        }

        if (!wolvesPresent) {
            System.out.println("Yes");
            for (char[] row : pasture) {
                System.out.println(new String(row));
            }
        } else {
            if (protectSheep(pasture, sheepLocations)) {
                System.out.println("Yes");
                for (char[] row : pasture) {
                    System.out.println(new String(row));
                }
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean protectSheep(char[][] pasture, ArrayList<int[]> sheepLocations) {
        for (int[] location : sheepLocations) {
            int r = location[0];
            int c = location[1];
            if (isAdjacentToWolf(pasture, r, c)) {
                return false;
            } else {
                placeDogsAround(pasture, r, c);
            }
        }
        return true;
    }

    private static boolean isAdjacentToWolf(char[][] pasture, int r, int c) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];
            if (newR >= 0 && newR < pasture.length && newC >= 0 && newC < pasture[0].length) {
                if (pasture[newR][newC] == WOLF) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void placeDogsAround(char[][] pasture, int r, int c) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];
            if (newR >= 0 && newR < pasture.length && newC >= 0 && newC < pasture[0].length) {
                if (pasture[newR][newC] == EMPTY) {
                    pasture[newR][newC] = DOG;
                }
            }
        }
    }
}
