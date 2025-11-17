package programs.java.Amit;




import java.util.*;

public class JavaTasks3 {

    // 11. Find the Frequency of Words in a Sentence using HashMap
    public static void wordFrequency(String sentence) {
        String[] words = sentence.toLowerCase().split("\\s+");
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            //freqMap.put(word, freqMap.getOrDefault(word, 0)+1);     //Gives 0 as value always initially for 1st occurence of word
        }
        System.out.println("Word frequencies: " + freqMap.toString());
    }

    // 12. Check if Two Strings are Anagrams
    public static void checkAnagram(String str1, String str2) {
        char[] a = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] b = str2.replaceAll("\\s", "").toLowerCase().toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if (Arrays.equals(a, b)) {
            System.out.println("Strings are anagrams.");
        } else {
            System.out.println("Strings are not anagrams.");
        }
    }

    // 13. Find the Missing Number in an Array from 1 to n
    public static void findMissingNumber(int[] array, int n) {
        int expectedSum = n * (n + 1) / 2;   //sum of n natural numbers
        int actualSum = 0;
        for (int num : array) {
            actualSum += num;
        }
        int missing = expectedSum - actualSum;
        System.out.println("Missing number is: " + missing);
    }

    // 14. Find the Intersection of Two Arrays using HashSet
    public static void findIntersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for (int num : arr1) 
         set1.add(num);
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }
        System.out.println("Intersection: " + intersection);
    }

    // 15. Rotate an Array by k positions
    public static void rotateArray(int[] array, int k) {
        int n = array.length;
        k = k % n; // Handle k > n
        reverse(array, 0, n - 1);
        reverse(array, 0, k - 1);
        reverse(array, k, n - 1);
        System.out.println("Rotated array: " + Arrays.toString(array));
    }

    private static void reverse(int[] array, int start, int end) {
        while (start < end) {  
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Task 11
        wordFrequency("Java is great and Java is powerful");

        // Task 12
        checkAnagram("Listen", "Silent");

        // Task 13
        int[] arr = {1, 2, 4, 3, 5, 6, 8}; // Missing 3
        findMissingNumber(arr, 8);

        // Task 14
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6};
        findIntersection(arr1, arr2);

        // Task 15
        int[] arrayToRotate = {1, 2, 3, 4, 5, 6, 7};
        rotateArray(arrayToRotate, 3); // Rotate by 3 positions
    }
}


/* 
11. Find the Frequency of Words in a Sentence
Write a program to count the frequency of words in a sentence using a HashMap.
12. Check if Two Strings are Anagrams
Write a program to check if two strings are anagrams.
13. Find the Missing Number in an Array
Write a program to find the missing number in an array of integers from 1 to n.
14. Find the Intersection of Two Arrays
Write a program to find the intersection of two arrays using a HashSet.
15. Rotate an Array
Write a program to rotate an array by k positions.
*/