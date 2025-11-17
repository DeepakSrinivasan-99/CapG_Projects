package programs.java.Amit;

import java.util.*;

public class JavaTasks6 {

    // Task 31: Check if a number is even or odd
    public static void checkEvenOdd(int num) {
        System.out.println(num + " is " + (num % 2 == 0 ? "Even" : "Odd"));
    }

    // Task 32: Count words in a sentence
    public static void countWords(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        System.out.println("Word count: " + words.length);
    }

    // Task 33: Reverse a sentence
    public static void reverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        Collections.reverse(Arrays.asList(words));
        System.out.println("Reversed sentence: " + String.join(" ", words));
    }

    // Task 34: Find max and min in an array
    public static void findMaxMin(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        System.out.println("Max: " + max + ", Min: " + min);
    }

    // Task 35: Check if a string contains only digits
    public static void checkOnlyDigits(String str) {
        boolean isDigits = str.matches("\\d+");
        System.out.println(str + " contains only digits: " + isDigits);
    }

    // Task 36: Find common elements between two arrays
    public static void findCommonElements(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> common = new HashSet<>();
        for (int num : arr1) set1.add(num);
        for (int num : arr2) {
            if (set1.contains(num)) common.add(num);
        }
        System.out.println("Common elements: " + common);
    }

    // Task 37: Convert string to title case
    public static void toTitleCase(String str) {
        String[] words = str.toLowerCase().split(" ");
        StringBuilder titleCase = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                         .append(word.substring(1)).append(" ");
            }
        }
        System.out.println("Title Case: " + titleCase.toString().trim());
    }

    // Task 38: Find second highest number in array
    public static void findSecondHighest(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        System.out.println("Second highest: " + second);
    }

    // Task 39: Check if a string is numeric
    public static void isNumeric(String str) {
        try {
            Double.parseDouble(str);
            System.out.println(str + " is numeric.");
        } catch (NumberFormatException e) {
            System.out.println(str + " is not numeric.");
        }
    }

    // Task 40: Remove all whitespaces from a string
    public static void removeWhitespaces(String str) {
        System.out.println("Without spaces: " + str.replaceAll("\\s", ""));
    }

    public static void main(String[] args) {
        // Task 31
        checkEvenOdd(7);

        // Task 32
        countWords("Java is a powerful language");

        // Task 33
        reverseSentence("Java is fun");

        // Task 34
        int[] arr = {10, 25, 3, 89, 45};
        findMaxMin(arr);

        // Task 35
        checkOnlyDigits("12345");
        checkOnlyDigits("12a45");

        // Task 36
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6};
        findCommonElements(arr1, arr2);

        // Task 37
        toTitleCase("java is awesome");

        // Task 38
        findSecondHighest(arr);

        // Task 39
        isNumeric("123.45");
        isNumeric("abc123");

        // Task 40
        removeWhitespaces("Java is cool");
    }
}