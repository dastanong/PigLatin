import java.util.Arrays;
import java.util.ArrayList;

public class PigLatin {
    static String convert(String word){
        Character[] vowel = {'a', 'e', 'i', 'o', 'u'};
        char[] wordChars = word.toCharArray();

        int firstVowelIndex = -1;
        for(int i = 0; i < wordChars.length; i++) {
            Character currentChar = wordChars[i];
            boolean isVowel = Arrays.asList(vowel).contains(currentChar);
            //System.out.println("Char : " + currentChar + " - " + isVowel);

            if(isVowel) {
                firstVowelIndex = i;
                break;
            }
        }

        if(firstVowelIndex == 0){
            return word;
        }else if(firstVowelIndex > 0){
            Character tempVowel = wordChars[firstVowelIndex];
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder finalWord = new StringBuilder();

            for(int j = 0; j < wordChars.length; j++) {
               if(wordChars[j] != tempVowel && j < firstVowelIndex) {
                    sb.append(wordChars[j]);
               }
               if(wordChars[j] != tempVowel && j > firstVowelIndex) {
                    sb2.append(wordChars[j]);           
                }
            }
            //System.out.println("First sb : " + sb);
            //System.out.println("Second sb : " + sb2);

            finalWord.append(tempVowel);
            finalWord.append(sb2);
            finalWord.append(sb);
            System.out.println("Modified word : " + finalWord);
            
            word = finalWord.toString();
            return word + "ay";
        } else {
            return word + "ay";
        }
    }
    public static void main(String[] args) {
        System.out.println(convert("art").equals("art"));
        System.out.println(convert("vowel").equals("owelvay"));
        System.out.println(convert("nginx").equals("inxngay"));
        System.out.println(convert("hello").equals("ellohay"));
        System.out.println(convert("Dr").equals("Dray"));
    }
}