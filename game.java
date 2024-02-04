import java.util.Scanner;
public class game {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int packageDelivered = Integer.parseInt(scan.nextLine());
        int collisions = Integer.parseInt(scan.nextLine());
        //System.out.println(packageDelivered + collisions);

        int scores = 50 * packageDelivered - 10 *collisions;

        if(packageDelivered>collisions){
            scores+=500;

        }
        System.out.println(scores);


    }
}
