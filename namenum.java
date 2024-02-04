/*
ID: johnson42
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.*;

public class namenum{
    private static final Map<Character, String> PHONE_MAP = new HashMap<>();
    private static Set<String> dictionary;

    static {
        PHONE_MAP.put('2', "ABC");
        PHONE_MAP.put('3', "DEF");
        PHONE_MAP.put('4', "GHI");
        PHONE_MAP.put('5', "JKL");
        PHONE_MAP.put('6', "MNO");
        PHONE_MAP.put('7', "PQRS");
        PHONE_MAP.put('8', "TUV");
        PHONE_MAP.put('9', "WXYZ");
        // Initialize the dictionary of valid names
        dictionary = new HashSet<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        // Load the dictionary
        BufferedReader dictReader = new BufferedReader(new FileReader("dict.txt"));
        String line;
        while ((line = dictReader.readLine()) != null) {
             dictionary.add(line.trim());
        }
        dictReader.close();

        // Read the brand number from the input file
        String brandNumber = br.readLine().trim();
        br.close();

        // Find valid names and write to the output file
        List<String> validNames = findValidNames(brandNumber);
        if (validNames.isEmpty()) {
            pw.println("NONE");
        } else {
            for (String name : validNames) {
                pw.println(name);
            }
        }
        pw.close();
    }

    private static List<String> findValidNames(String number) {
        List<String> results = new ArrayList<>();
        generateNames("", number, 0, results);
        Collections.sort(results);
        return results;
    }

    private static void generateNames(String prefix, String remaining, int index, List<String> results) {
        if (index == remaining.length()) {
            if (dictionary.contains(prefix)) {
                results.add(prefix);
            }
            return;
        }

        char digit = remaining.charAt(index);
        String letters = PHONE_MAP.get(digit);
        if (letters != null) {
            for (char letter : letters.toCharArray()) {
                generateNames(prefix + letter, remaining, index + 1, results);
            }
        }
    }
}

