package programs.java.Amit;



import java.util.*;

public class JavaTasks7 {

    // Task 41: Check if a string is palindrome (ignoring case)
    public static void checkPalindromeIgnoreCase(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println(str + " is " + (str.equalsIgnoreCase(reversed) ? "a palindrome." : "not a palindrome."));
    }

    // Task 42: Count uppercase and lowercase letters
    public static void countCase(String str) {
        int upper = 0, lower = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) upper++;
            else if (Character.isLowerCase(ch)) lower++;
        }
        System.out.println("Uppercase: " + upper + ", Lowercase: " + lower);
    }

    // Task 43: Find sum of digits in a string
    public static void sumDigitsInString(String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                sum += Character.getNumericValue(ch);
            }
        }
        System.out.println("Sum of digits in string: " + sum);
    }

    // Task 44: Remove duplicate characters from a string
    public static void removeDuplicateChars(String str) {
        Set<Character> seen = new LinkedHashSet<>();
        for (char ch : str.toCharArray()) {
            seen.add(ch);
        }
        StringBuilder result = new StringBuilder();
        for (char ch : seen) {
            result.append(ch);
        }
        System.out.println("Without duplicates: " + result.toString());
    }

    // Task 45: Find frequency of words in a sentence
    public static void wordFrequency(String sentence) {
        String[] words = sentence.toLowerCase().split("\\s+");
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Task 46: Find longest word in a sentence
    public static void findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        System.out.println("Longest word: " + longest);
    }

    // Task 47: Count special characters in a string
    public static void countSpecialChars(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch)) {
                count++;
            }
        }
        System.out.println("Special characters count: " + count);
    }

    // Task 48: Convert character case (toggle)
    public static void toggleCase(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(ch);
            }
        }
        System.out.println("Toggled case: " + result.toString());
    }

    // Task 49: Find average of array elements
    public static void averageOfArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double avg = (double) sum / arr.length;
        System.out.println("Average: " + avg);
    }

    // Task 50: Find all prime numbers in an array
    public static void findPrimesInArray(int[] arr) {
        System.out.print("Prime numbers: ");
        for (int num : arr) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Task 41
        checkPalindromeIgnoreCase("Madam");

        // Task 42
        countCase("Hello World");

        // Task 43
        sumDigitsInString("abc123xyz");

        // Task 44
        removeDuplicateChars("programming");

        // Task 45
        wordFrequency("Java is great and Java is powerful");

        // Task 46
        findLongestWord("Java is a powerful language");

        // Task 47
        countSpecialChars("Hello@World#2025!");

        // Task 48
        toggleCase("Java123");

        // Task 49
        int[] arr = {10, 20, 30, 40, 50};
        averageOfArray(arr);

        // Task 50
        int[] nums = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        findPrimesInArray(nums);
    }
}