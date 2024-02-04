
/*
ID: johnson42
LANG: JAVA
TASK: milk2
        */
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class milk2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        int N = Integer.parseInt(f.readLine());
        int [][] times = new int [N][2];
        for (int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            times[i][0]= Integer.parseInt(st.nextToken());//start time
            times[i][1]= Integer.parseInt(st.nextToken());// end time
        }
        //sort the times by starting times
        Arrays.sort(times, Comparator.comparing(a -> a[0]));

        int longestMilk = 0;
        int longestIdle = 0;
        int start = times[0][0];
        int end = times[0][1];

        for (int i = 1; i < N; i++){
            if(times[i][0]<= end){
                //extend the milking time if the next cow starts before the previous one ends
                end = Math.max(end, times[i][1]);
            }else{
                longestMilk = Math.max(longestMilk, end - start);
                longestIdle = Math.max(longestIdle, times[i][0] - end);

                start = times[i][0];
                end = times [i][1];

            }
        }
        longestMilk = Math.max(longestMilk, end - start);
        out.println(longestMilk+ " " + longestIdle);
        out.close();


}
}
/*
        1.read input
        create an array to store the milking intervals
        store milking intervals loop through the n lines for each line use the string tokenizer to read the star and end
        store it in the array
        2. sort intervals array by the start times of each milking session
        3. process variable for longest miking time and longest idle time
        4. intalize varaible to keep track of current milking session star and end times
        iterate through the array
            if an interval overlapse with or touches the current milking session extend the session.
            otherwise update longest milking time and longest idle time
        printwriter to print both
         */