/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: johnson42
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;


class gift1 {
            public static void main(String[] args) throws IOException {
                BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

                int NP = Integer.parseInt(f.readLine());

                List<String> names = new ArrayList<>();
                Map<String, Integer> balances = new HashMap<>();

                for (int i = 0; i < NP; i++) {
                    String name = f.readLine();
                    names.add(name);
                    balances.put(name, 0);
                }

                for (int i = 0; i < NP; i++) {
                    String giver = f.readLine();
                    StringTokenizer st = new StringTokenizer(f.readLine());
                    int amount = Integer.parseInt(st.nextToken());
                    int numRecipients = Integer.parseInt(st.nextToken());

                    if (numRecipients == 0) continue;

                    int giftAmount = amount / numRecipients;
                    int remainingAmount = amount % numRecipients;

                    balances.put(giver, balances.get(giver) - amount + remainingAmount);

                    for (int j = 0; j < numRecipients; j++) {
                        String recipient = f.readLine();
                        balances.put(recipient, balances.get(recipient) + giftAmount);
                    }
                }

                for (String name : names) {
                    out.println(name + " " + balances.get(name));
                }

                out.close();
            }
        }
