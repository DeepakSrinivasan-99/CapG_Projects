package programs.java.Amit;


import java.util.*;

public class JavaTasks8 {

    // Task 51: Count number of words starting with a vowel
    public static void countWordsStartingWithVowel(String sentence) {
        int count = 0;
        for (String word : sentence.toLowerCase().split("\\s+")) {
            if (!word.isEmpty() && "aeiou".indexOf(word.charAt(0)) != -1) {
                count++;
            }
        }
        System.out.println("Words starting with vowel: " + count);
    }

    // Task 52: Find the most frequent character in a string
    public static void mostFrequentChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        char maxChar = ' ';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        System.out.println("Most frequent character: " + maxChar + " (" + maxCount + " times)");
    }

    // Task 53: Find the sum of all odd numbers in an array
    public static void sumOddNumbers(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (num % 2 != 0) sum += num;
        }
        System.out.println("Sum of odd numbers: " + sum);
    }

    // Task 54: Count number of digits, letters, and special characters in a string
    public static void countCharTypes(String str) {
        int digits = 0, letters = 0, specials = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) digits++;
            else if (Character.isLetter(ch)) letters++;
            else specials++;
        }
        System.out.println("Digits: " + digits + ", Letters: " + letters + ", Special characters: " + specials);
    }

    // Task 55: Find the second smallest number in an array
    public static void findSecondSmallest(int[] arr) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < first) {
                second = first;
                first = num;
            } else if (num < second && num != first) {
                second = num;
            }
        }
        System.out.println("Second smallest number: " + second);
    }

    // Task 56: Count number of uppercase letters in a string
    public static void countUppercase(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) count++;
        }
        System.out.println("Uppercase letters: " + count);
    }

    // Task 57: Find the product of digits in a number
    public static void productOfDigits(int num) {
        int product = 1;
        while (num != 0) {
            product *= num % 10;
            num /= 10;
        }
        System.out.println("Product of digits: " + product);
    }

    // Task 58: Check if a string is a valid binary number
    public static void isValidBinary(String str) {
        boolean isBinary = str.matches("[01]+");
        System.out.println(str + " is " + (isBinary ? "a valid binary number." : "not a valid binary number."));
    }

    // Task 59: Count number of lines in a multiline string
    public static void countLines(String str) {
        String[] lines = str.split("\n");
        System.out.println("Number of lines: " + lines.length);
    }

    // Task 60: Find the reverse of each word in a sentence
    public static void reverseEachWord(String sentence) {
        StringBuilder result = new StringBuilder();
        for (String word : sentence.split(" ")) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }
        System.out.println("Reversed words: " + result.toString().trim());
    }

    public static void main(String[] args) {
        // Task 51
        countWordsStartingWithVowel("Apple is a fruit and orange is too");

        // Task 52
        mostFrequentChar("Deepak");

        // Task 53
        int[] arr1 = {1, 2, 3, 4, 5};
        sumOddNumbers(arr1);

        // Task 54
        countCharTypes("Java@123!");

        // Task 55
        int[] arr2 = {10, 5, 3, 8, 2};
        findSecondSmallest(arr2);

        // Task 56
        countUppercase("Hello JAVA World");

        // Task 57
        productOfDigits(2345);

        // Task 58
        isValidBinary("101010");
        isValidBinary("10201");

        // Task 59
        countLines("Java is fun\nIt is powerful\nIt is popular");

        // Task 60
        reverseEachWord("Java is awesome");
    }
}