import java.util.LinkedHashSet;
import java.util.Set;

public class StringTasks {
    public static void main(String[] args) {
        String input = "Kamal";

        String result = removeDuplicates(input);
        System.out.println("Output: " + result);  // Expected: Kml
    }

    public static String removeDuplicates(String str) {
        Set<Character> seen = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                sb.append(c);
            }
        }

        return sb.toString();
    }
}