package programs.java.Amit;

public class JavaTasks4 {

    // Task 16: Check if a number is prime
    public static void checkPrime(int num) {
        boolean isPrime = num > 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {   //sqrt(29)=5.3
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(num + " is " + (isPrime ? "a prime number." : "not a prime number."));
    }

    // Task 17: Find factorial of a number
    public static void findFactorial(int num) {
        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + num + " is " + factorial);
    }

    // Task 18: Find the sum of digits of a number
    public static void sumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        System.out.println("Sum of digits: " + sum);
    }

    // Task 19: Reverse an integer
    public static void reverseInteger(int num) {
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        System.out.println("Reversed number: " + reversed);
    }

    // Task 20: Check Armstrong number
    public static void checkArmstrong(int num) {
        int original = num, sum = 0;
        while (num != 0) {
            int digit = num % 10;
            sum += Math.pow(digit, 3);
            num /= 10;
        }
        System.out.println(original + " is " + (sum == original ? "an Armstrong number." : "not an Armstrong number."));
    }
    
    /*
		     🔹 For 3-digit numbers:
		Each digit is raised to the power of 3.
		Example: 153
		
		Digits: 1, 5, 3
		Calculation:
		13+53+33=1+125+27=1531^3 + 5^3 + 3^3 = 1 + 125 + 27 = 15313+53+33=1+125+27=153
		✅ So, 153 is an Armstrong number.
     */
    
    
    public static void Interleave_Characters_From_Two_Strings(String str1,String str2)
    {
    	  
     
        
                StringBuilder result_SB = new StringBuilder();
                String result_Method2="";
                int maxLength = Math.max(str1.length(), str2.length());

                for (int i = 0; i < maxLength; i++) {
                    if (i < str1.length()) {
                        result_SB.append(str1.charAt(i));
                        result_Method2=result_Method2+str1.charAt(i);
                    }
                    if (i < str2.length()) {
                        result_SB.append(str2.charAt(i));
                        result_Method2=result_Method2+str2.charAt(i);
                    }
                }
                
                System.out.println("Interleave characters using the StringBuilder method : "+result_SB.toString());
                System.out.println("Interleave characters using the Normal String method: "+result_Method2);

    }
    
  

    public static void main(String[] args) {
        // Task 16
        checkPrime(29);

        // Task 17
        findFactorial(5);

        // Task 18
        sumOfDigits(1234);

        // Task 19
        reverseInteger(12345);

        // Task 20
        checkArmstrong(153);
        
        
        //Interleave Characters from Two Strings         
       Interleave_Characters_From_Two_Strings("Deepak", "Kavya");
      

    

        
    }}
