package programs.java.Amit;


import java.util.*;

public class JavaTasks5 {

    // Task 21: Find GCD of two numbers
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
            System.out.println("\ntemp="+temp+" b="+b+" a="+a);
        }
        return a;
    }

    // Task 22: Find LCM of two numbers
    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    // Task 23: Swap two numbers without third variable
    public static void swapNumbers(int a, int b) {
        System.out.println("\nBefore swap: a = " + a + ", b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swap: a = " + a + ", b = " + b);
    }

    // Task 24: Count vowels and consonants
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) { // It returns -1 if character is not present in "aeiou" string
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("\nVowels: " + vowels + ", Consonants: " + consonants);
    }

    // Task 25: Frequency of each character
    public static void characterFrequency(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        System.out.println("\nCharacter Frequencies:"+freqMap);
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Task 26: Reverse each word in a sentence
    public static void reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }
        System.out.println("Reversed words: " + result.toString().trim());
    }

    // Task 27: Check if a string is a pangram
    public static void checkPangram(String str) {
        str = str.toLowerCase().replaceAll("[^a-z ]", "");
        System.out.println(str);
        Set<Character> letters = new HashSet<>();
        for (char ch : str.toCharArray()) {
            letters.add(ch);
        }
        System.out.println("Is Pangram: " + (letters.size() == 26));  //Unique characters to be 26
    }

    // Task 28: Find duplicate characters in a string
    public static void findDuplicateCharacters(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        System.out.println("Duplicate characters:");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    // Task 29: Check if a number is a perfect number
    public static void checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
            	sum+=i;
            }
        }
        System.out.println(num + " is " + (sum == num ? "a perfect number." : "not a perfect number."));
       
    }

    
    /*
      🔸 Examples of Perfect Numbers:
		1. 6
		
		Divisors: 1, 2, 3
		Sum: 1 + 2 + 3 = 6
		✅ So, 6 is a perfect number.
     */
    
    // Task 30: Find sum of all elements in an array
    public static void sumOfArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println("Sum of array elements: " + sum);
    }

    public static void main(String[] args) {
        // Task 21
        System.out.println("\nGCD of 36 and 60: " + findGCD(36, 60));

        // Task 22
        System.out.println("\nLCM of 12 and 18: " + findLCM(12, 18));

        // Task 23
        swapNumbers(10, 20);

        // Task 24
        countVowelsAndConsonants("Hello World");

        // Task 25
        characterFrequency("banana");

        // Task 26
        reverseWords("Java is fun");

        // Task 27
        checkPangram("The quick brown fox jumps over the lazy dog");

        // Task 28
        findDuplicateCharacters("programming");

        // Task 29
        checkPerfectNumber(28);

        // Task 30
        int[] arr = {10, 20, 30, 40};
        sumOfArray(arr);
    }
}