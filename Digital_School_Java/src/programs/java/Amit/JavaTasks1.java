package programs.java.Amit;
import java.util.*;

public class JavaTasks1 {

    // 1. Reverse a String
    public static void reverseString(String input) {
        // Using StringBuilder
        String reversedSB = new StringBuilder(input).reverse().toString();
        System.out.println("Reversed using StringBuilder: " + reversedSB);

        // Using loop
        String reversedLoop = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversedLoop += input.charAt(i);
        }
        System.out.println("Reversed using loop: " + reversedLoop);
    }

    // 2. Check if a String is a Palindrome
    public static void checkPalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        if (input.equals(reversed)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
    }

    // 3. Find the Largest Element in an Array
    public static void findLargest(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Largest element: " + max);
    }

    // 4. Sort an Array
    public static void sortArray(int[] array) {
        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    // 5. Sort a List of Strings
    public static void sortStringList(List<String> list) {
        Collections.sort(list);
        System.out.println("Sorted list of strings: " + list);
    }

    public static void main(String[] args) {
        // Task 1
        reverseString("Hello");

        // Task 2
        checkPalindrome("madam");
        checkPalindrome("hello");

        // Task 3
        int[] numbers = {45, 22, 89, 12, 67};
        findLargest(numbers);

        // Task 4
        sortArray(numbers);

        // Task 5
        List<String> stringList = Arrays.asList("Banana", "Apple", "Mango", "Cherry");
        sortStringList(stringList);
    }
}
