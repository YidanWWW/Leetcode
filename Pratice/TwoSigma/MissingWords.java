package TwoSigma;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class MissingWords {
    public static List<String> missingWords(String s, String t) {
        String[] sWords = s.split(" ");
        String[] tWords = t.split(" ");
        List<String> result = new ArrayList<>();
        int tIndex = 0;

        for (String word : sWords) {
            if (tIndex == tWords.length || !word.equals(tWords[tIndex])) {
                result.add(word);
            } else {
                tIndex++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "I am using OpenAI's GPT-3 model.";
        String t = "am using GPT-3 model.";
        List<String> missingWordsList = missingWords(s, t);

        for (String word : missingWordsList) {
            System.out.print(word + " ");
        }
    }
}

