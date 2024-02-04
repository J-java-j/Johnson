import java.io.*;
import java.util.*;

public class tttt {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("tttt.out"));

        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            board[i] = br.readLine().toCharArray();
        }

        Set<Character> individualWinner = new HashSet<>();
        Set<String> teamWinners = new HashSet<>();

        //checks for individual and team winners in rows, columns and diagonals
        checkWinners(board, individualWinner, teamWinners);

        pw.println(individualWinner.size());
        pw.println(teamWinners.size());

        br.close();
        pw.close();
    }

    private static void checkWinners(char[][] board, Set<Character> individualWinners, Set<String> teamWinners) {
        for (int i = 0; i<3; i++){
            checkLine(board[i][0], board[i][1],board[i][2], individualWinners, teamWinners);
            checkLine(board[0][i], board[1][i],board[2][i], individualWinners, teamWinners);
        }
        checkLine(board[0][0], board[1][1],board[2][2], individualWinners, teamWinners);
        checkLine(board[0][2], board[1][1],board[2][0], individualWinners, teamWinners);
    }

    private static void checkLine(char a, char b, char c, Set<Character> individualWinners, Set<String> teamWinners) {
        Set<Character> uniqueChars = new HashSet<>(Arrays.asList(a, b, c));
        if (uniqueChars.size()==1){
            individualWinners.add(a);
        } else if (uniqueChars.size()==2) {
            String team = uniqueChars.stream().sorted().map(Object::toString).reduce("", String::concat);
            teamWinners.add(team);

        }


    }

}



/*
Reading the Game Board:

The game board is read from a file, ttt.in, line by line, and each character (representing a cow's initial) is stored in a 2D character array.
This represents the tic-tac-toe board.
Initializing Collections for Winners:

Two HashSet objects are created: individualWinners for individual cows that can claim victory, and teamWinners
for pairs of cows that can claim victory. The use of sets ensures that all winners are unique since sets do not allow duplicate elements.
Checking for Winners:

The program checks all possible lines where a victory can occur: three rows, three columns, and two diagonals.
For each line, it calls the checkLine method which determines if the line constitutes a victory for an individual cow or a pair of cows.
The checkLine Method:

This method receives three characters, each representing a square on the tic-tac-toe board, which could be part of a row, column, or diagonal.
It then adds these characters to a local HashSet to identify the unique characters in the line.
Based on the number of unique characters, the method distinguishes between an individual winner (a single character fills the line)
or a team winner (two different characters fill the line).
For team winners, it creates a sorted string representing the team (e.g., "AB" instead of "BA"), which guarantees the
uniqueness of the team regardless of the order of characters.
Ensuring Unique Team Identifiers:

When a team is identified, the characters are sorted and concatenated into a string, which is added to the teamWinners set.
Sorting ensures that the team "AB" is the same as "BA", and only one instance is stored.
Writing to the Output File:

After all lines have been checked, the program writes the size of the individualWinners set (the number of individual winners)
and the size of the teamWinners set (the number of team winners) to an output file, ttt.out.
Closing Resources:

The program closes the BufferedReader and PrintWriter to free up resources.
 */