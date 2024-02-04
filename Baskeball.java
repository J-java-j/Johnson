import java.util.Scanner;
public class Baskeball {
    public static void main(String[] args) {
        //read the input
        Scanner scan = new Scanner(System.in);
        String scores = scan.nextLine();
       //System.out.println(scores);

        int scoreA = 0;
        int scoreB = 0;
        boolean winBy2 = false;

        for (int i = 0; i < scores.length(); i += 2) {

            char player = scores.charAt(i);
            //System.out.print(player);
            int points = Integer.parseInt("" + scores.charAt(i + 1));
            //System.out.println(points);

            if (player == 'A') {
                scoreA += points;
            } else {
                scoreB += points;
            }

            //A:11 B:10
            //A:10 B:10 ->  win by 2
            if (!winBy2) {
                if (scoreA == 10 && scoreB == 10) {
                    winBy2 = true;
                    continue;
                } else {
                    if (scoreA >= 11) {
                        System.out.println("A");
                        return;
                    }
                    if (scoreB >= 11) {
                        System.out.println("B");
                        return;
                    }
                }
            } else {
                if (Math.abs(scoreA - scoreB) >= 2) {
                    if (scoreA > scoreB) {
                        System.out.println('A');
                        return;
                    } else {
                        System.out.println('B');
                        return;

                    }
                }



                    }

                }
            }

        }
