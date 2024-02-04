/*
ID: johnson42
LANG: JAVA
TASK: friday
        */
import java.io.*;
class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        int N = Integer.parseInt(f.readLine());

        int[] days = new int[7];
        int[] non_leap = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int currentDay = 0;

        for (int year = 1900; year < 1900 + N; year++) {
            int[] months = isLeap(year) ? leap : non_leap;
            for (int month : months) {
                days[currentDay]++;
                currentDay = (currentDay + month) % 7;
            }
        }

        out.println(days[0] + " " + days[1] + " " + days[2] + " " + days[3] + " " + days[4] + " " + days[5] + " " + days[6]);
        out.close();
    }

    static boolean isLeap(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }
}
/*
Initialization:
Create an array days of size 7 initialized to 0. This will store the count of 13th falling on each day of the week.
Create an array months to store the number of days in each month. For non-leap years: [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] and for leap years: [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31].
Set currentDay to 2 (representing Monday, as January 1, 1900 was a Monday). We can use numbers to represent days of the week, e.g., 0 for Saturday, 1 for Sunday, 2 for Monday, and so on.
Iterate through each year and month:

For each year from 1900 to 1900+N-1:
Determine if the year is a leap year.
For each month:
Increment the count of days[currentDay] as this will be the 13th of the month.
Update currentDay by adding the number of days in the month and taking modulo 7 to wrap around the week.
Output the result:

Print the values in days array in the order: Saturday, Sunday, Monday, ..., Friday.

 */