import java.util.Scanner;
import java.util.ArrayList;

public class Infection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        //read the state of the cows as a string
        String cowStatesStr = scanner.next();
        System.out.println(N +"\n"+ cowStatesStr);
        char[] cowStates = cowStatesStr.toCharArray();

        //seperate in to groups
        //Count the cows in the left group and right group
        int idx = 0;
        while (idx < N && cowStates[idx]=='1'){
            idx ++;
        }
        int leftCows = idx;

        int j = N-1;
        while(j>idx && cowStates[j]=='1'){
            j --;
        }
        int rightCows = N-1-j;
        System.out.println("left: " + leftCows +"\n" + "right: " + rightCows);

        /*
        5 11111 5 0
        5 11001 2 1
        5 00111 0 3
        5 11000 2 0
        5 00000 0 0
        */

        ArrayList <Integer> centerCows = new ArrayList();
        //Count the cows in the center groups
        while(idx < j){
            int count = 0;
            while(idx<j && cowStates[idx] == '1'){
                count ++;
                idx ++;
            }
            if (count > 0){
                centerCows.add(count);
            }
            idx ++;
        }

        for(int cow : centerCows) {
            System.out.println(cow);
        }
        /*
        111001111011 4
        111001011011 1,2
        00011001     2
        14
        11101111101111
        * */

        int maxNight = Integer.MAX_VALUE;
        if (leftCows != 0) maxNight = Math.min(maxNight, leftCows-1);
        if (rightCows != 0) maxNight = Math.min(maxNight, rightCows-1);

        for (int cow: centerCows){
            int night = (cow-1)/2;
            maxNight = Math.min(maxNight,night);
        }

        System.out.println("Max nights: " +maxNight);

        //find the minimum amount of cows
        if(leftCows != 0){
            centerCows.add(leftCows);
        }
        if (rightCows !=0){
            centerCows.add(rightCows);
        }

        int totalCows = 0;
        for(int cow: centerCows){
            int cows = (int)Math.ceil(cow/(2*maxNight+1));
            totalCows += Math.max(cows, 1);
        }

        System.out.println("The total number of cows required is: "+ totalCows);
    }
}
/*
1. Read the input number of cows then the final state// of cows
2. seperate the list into manegable groups like between uninfected cows and walls
3. read each group and calculate the maximum amount of nights:
    if next to wall # of night is equal to the number of cows - 1
    if cow is bounded by uninfected cows than
    01110 3 -》 1
    011110 4 》 1
    0111110 5 > 2
    01111110 6 > 2
    （N-1）/2
    2*n+1 = N -> n = (N-1)/2
 4. Find the minimum number of night among all number of nights calculated, Nf
 5. Calculate the number of cows needed according to Nf:
    cf = 2*Nf + 1
    ct/cf -> math.ceil()
    Similar to this question: how many rectangles(cf) needed to cover an area(ct)
    Note: it doesn't matter the extract locations of the initial cows
 6. Add the cows together
 */

