// Source: https://www.geeksforgeeks.org/java-string-split-method/
package org.howard.edu.lsp.midterm.question4;

import java.util.List;

/**
 * A driver class to test the WordProcessor class.
 */
public class WordProcessorDriver {
    /**
     * The main method that executes test cases for WordProcessor.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Test case 1: Sentence with single longest word
        WordProcessor wp1 = new WordProcessor("This is a test with amazing results amazing achievements");
        List<String> longestWords1 = wp1.findLongestWords();
        System.out.println("Test 1 - Longest words: " + longestWords1);
        // Expected Output: ["achievements"]

        // Test case 2: Sentence with multiple occurrences of the same longest word and length
        WordProcessor wp2 = new WordProcessor("Java is a powerful  tool");
        List<String> longestWords2 = wp2.findLongestWords();
        System.out.println("Test 2 - Longest words: " + longestWords2);
        // Expected Output: ["powerful"]

        // Test case 3: Sentence with multiple longest words appearing in order
        WordProcessor wp3 = new WordProcessor("Coding makes life exciting and rewarding");
        List<String> longestWords3 = wp3.findLongestWords();
        System.out.println("Test 3 - Longest words: " + longestWords3);
        // Expected Output: ["exciting", "rewarding"]

        // Test case 4: Single character words
        WordProcessor wp4 = new WordProcessor("A B C D E");
        List<String> longestWords4 = wp4.findLongestWords();
        System.out.println("Test 4 - Longest words: " + longestWords4);
        // Expected Output: ["A", "B", "C", "D", "E"]

        // Test case 5: Empty string input
        WordProcessor wp5 = new WordProcessor("");
        List<String> longestWords5 = wp5.findLongestWords();
        System.out.println("Test 5 - Longest words: " + longestWords5);
        // Expected Output: []
    }
}
