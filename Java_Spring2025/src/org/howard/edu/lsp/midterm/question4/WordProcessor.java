package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that processes a sentence and returns all longest words.
 */
public class WordProcessor {
    private String sentence;

    /**
     * Constructs a WordProcessor with a given sentence.
     *
     * @param sentence The sentence to be processed.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all longest words in the sentence.
     * The method handles varying whitespace between words and returns all words with the maximum length
     * in the order they appear.
     *
     * @return A list of longest words in the sentence.
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords;
        }

        String[] words = sentence.split("\\s+"); // Split by whitespace (handles multiple spaces)
        int maxLength = 0;

        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWords.clear();
                longestWords.add(word);
            } else if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
}
