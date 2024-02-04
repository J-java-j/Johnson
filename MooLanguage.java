/*
Main Function:

    Read T (number of test cases)
    For each test case:
        Read N, C, P (number of nouns, commas, periods)
        Create empty lists for nouns, transitive verbs, intransitive verbs, conjunctions
        Fill lists with words from input
        Invoke constructSentences with filled lists and comma/period counts

Construct Sentences Function:
Initialize an empty list for sentences
While we have periods left and enough words to form a sentence:
    If transitive verbs and nouns are available:
        Build a Type 1 sentence
        Use commas if available for additional nouns
    Else if intransitive verbs and nouns are available:
        Build a Type 2 sentence
    If conjunctions are available and we have more than one sentence:
        Combine sentences with a conjunction
    End the sentence with a period and decrement period count
    Add new sentence to sentences list
Return the sentences list
 */
import java.util.*;
import java.io.*;

public class MooLanguage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            List<String> nouns = new ArrayList<>();
            List<String> transitiveVerbs = new ArrayList<>();
            List<String> intransitiveVerbs = new ArrayList<>();
            List<String> conjunctions = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String word = st.nextToken();
                String type = st.nextToken();
                switch (type) {
                    case "noun":
                        nouns.add(word);
                        break;
                    case "transitive-verb":
                        transitiveVerbs.add(word);
                        break;
                    case "intransitive-verb":
                        intransitiveVerbs.add(word);
                        break;
                    case "conjunction":
                        conjunctions.add(word);
                        break;
                }
            }

            List<String> sentences = constructSentences(nouns, transitiveVerbs, intransitiveVerbs, conjunctions, C, P);

            out.println(sentences.size());
            for (String sentence : sentences) {
                out.println(sentence.trim());
            }
        }
        br.close();
        out.flush();
        out.close();
    }

    private static List<String> constructSentences(List<String> nouns, List<String> transitiveVerbs, List<String> intransitiveVerbs, List<String> conjunctions, int commas, int periods) {
        List<String> sentences = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // Loop until we can no longer create valid sentences
        while (periods > 0 && !nouns.isEmpty() && (!transitiveVerbs.isEmpty() || !intransitiveVerbs.isEmpty())) {
            boolean useTransitive = !transitiveVerbs.isEmpty() && !nouns.isEmpty();

            if (useTransitive) {
                // Construct Type 1 sentence: noun + transitive verb + noun(s)
                sb.append(nouns.remove(0)).append(" ").append(transitiveVerbs.remove(0));
                sb.append(" ").append(nouns.remove(0)); // At least one noun after the transitive verb
                while (commas > 0 && !nouns.isEmpty()) {
                    sb.append(", ").append(nouns.remove(0));
                    commas--;
                }
            } else {
                // Construct Type 2 sentence: noun + intransitive verb
                sb.append(nouns.remove(0)).append(" ").append(intransitiveVerbs.remove(0));
            }

            // If we have a conjunction and more than one sentence, create a compound sentence
            if (!conjunctions.isEmpty() && sentences.size() > 0 && periods > 1) {
                sb.insert(0, conjunctions.remove(0) + " ");
            } else {
                periods--; // End the sentence with a period
            }

            // Add the constructed sentence to the list and reset the StringBuilder
            sentences.add(sb.toString());
            sb.setLength(0);

            if (periods > 0 && !conjunctions.isEmpty() && sentences.size() > 0) {
                // If possible, continue with a compound sentence
                sb.append(sentences.remove(sentences.size() - 1)).append(" ");
            } else if (periods > 0) {
                // Otherwise, start a new sentence
                sb.append(sentences.remove(sentences.size() - 1)).append(". ");
            }
        }

        // If we ended with a compound sentence, add the final period
        if (sb.length() > 0) {
            sb.append(".");
            sentences.add(sb.toString());
        }

        return sentences;
    }
}

