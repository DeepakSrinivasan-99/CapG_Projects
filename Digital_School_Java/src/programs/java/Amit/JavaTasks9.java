package programs.java.Amit;


import java.util.*;

public class JavaTasks9 {

    // Task 61: Count frequency of each word in a paragraph
    public static void wordFrequency(String paragraph) {
        String[] words = paragraph.toLowerCase().split("\\s+");
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Task 62: Find all palindromic words in a sentence
    public static void findPalindromicWords(String sentence) {
        String[] words = sentence.split("\\s+");
        System.out.println("Palindromic words:");
        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equalsIgnoreCase(reversed) && word.length() > 1) {
                System.out.println(word);
            }
        }
    }

    // Task 63: Find sum of squares of digits in a number
    public static void sumOfSquares(int num) {
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        System.out.println("Sum of squares of digits: " + sum);
    }

    // Task 64: Find the longest palindrome in a sentence
    public static void longestPalindrome(String sentence) {
        String[] words = sentence.split("\\s+");
        String longest = "";
        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equalsIgnoreCase(reversed) && word.length() > longest.length()) {
                longest = word;
            }
        }
        System.out.println("Longest palindrome: " + longest);
    }

    // Task 65: Count number of prime digits in a number
    public static void countPrimeDigits(int num) {
        int count = 0;
        while (num != 0) {
            int digit = num % 10;
            if (digit == 2 || digit == 3 || digit == 5 || digit == 7) {
                count++;
            }
            num /= 10;
        }
        System.out.println("Prime digits count: " + count);
    }

    // Task 66: Find the difference between max and min digits in a number
    public static void digitRange(int num) {
        int max = 0, min = 9;
        while (num != 0) {
            int digit = num % 10;
            if (digit > max) max = digit;
            if (digit < min) min = digit;
            num /= 10;
        }
        System.out.println("Digit range (max - min): " + (max - min));
    }

    // Task 67: Check if a string is a pangram (case-insensitive)
    public static void isPangram(String str) {
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        Set<Character> letters = new HashSet<>();
        for (char ch : str.toCharArray()) {
            letters.add(ch);
        }
        System.out.println("Is Pangram: " + (letters.size() == 26));
    }

    // Task 68: Find the number of unique characters in a string
    public static void countUniqueChars(String str) {
        Set<Character> unique = new HashSet<>();
        for (char ch : str.toCharArray()) {
            unique.add(ch);
        }
        System.out.println("Unique characters count: " + unique.size());
    }

    // Task 69: Find the sum of ASCII values of characters in a string
    public static void sumAsciiValues(String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            sum += (int) ch;
        }
        System.out.println("Sum of ASCII values: " + sum);
    }

    // Task 70: Check if a number is a Harshad number
    public static void checkHarshadNumber(int num) {
        int original = num, sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        System.out.println(original + " is " + (original % sum == 0 ? "a Harshad number." : "not a Harshad number."));
    }

    public static void main(String[] args) {
        // Task 61
        wordFrequency("Java is great and Java is powerful");

        // Task 62
        findPalindromicWords("Madam Arora teaches malayalam");

        // Task 63
        sumOfSquares(123);

        // Task 64
        longestPalindrome("Wow level madam racecar civic");

        // Task 65
        countPrimeDigits(23579);

        // Task 66
        digitRange(9834);

        // Task 67
        isPangram("The quick brown fox jumps over the lazy dog");

        // Task 68
        countUniqueChars("banana");

        // Task 69
        sumAsciiValues("ABC");

        // Task 70
        checkHarshadNumber(18); // 18 / (1+8) = 2 → Harshad
    }
}