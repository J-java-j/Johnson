import java.util.Scanner;
public class Class2 {
    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your age:");

        int age;
        if(scan.hasNextInt()){
            age = scan.nextInt();
            System.out.println("Your age is:" + age);}

         else{
            System.out.println("invalid input");
            }*/
        Scanner scan =  new Scanner(System.in);
        System.out.println("Please enter a word:");
        String word = scan.next();

        System.out.println("Please enter a sentence:");
        scan.nextLine();
        String Sentence = scan.nextLine();

        int index = Sentence.indexOf(word);
        int app = index;
        int count = 0;

        while(index!=-1){
            count++;
            index = Sentence.indexOf(word, index+1);
        }
        if (count>0) {
            System.out.println("The word" + word + " is in the sentence, and is in position " + app +"the occurence is "+ count);
        } else{
            System.out.println("The word"+ word +" is not in the sentence");
        }
        }
    }


