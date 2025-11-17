// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.LinkedHashMap;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {
    
    String name = "Praveen Kumar";
    
    Map<Character,Integer> charWithRepeation = new LinkedHashMap<>();
    
    for(int i=0; i<name.length();i++)
    {
        char iterateEachLetter = name.charAt(i);
        if(!Character.isWhitespace(iterateEachLetter))
         charWithRepeation.put(iterateEachLetter,charWithRepeation.getOrDefault(iterateEachLetter, 0)+1);
    }
    
	 System.out.println("The Character count :");

    for(Map.Entry<Character,Integer> iterateMap1 : charWithRepeation.entrySet())
    {
    	if(iterateMap1.getValue()>=1)
    	System.out.println( "Letter :"+iterateMap1.getKey()+" repeated for "+iterateMap1.getValue()+" times");
    }
        
    }
    
}