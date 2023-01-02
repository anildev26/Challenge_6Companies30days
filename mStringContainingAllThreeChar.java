package challenge_6Company_30Days;

import java.util.HashMap;
import java.util.Map;

public class mStringContainingAllThreeChar {
    //1st Code (54ms TC)
    public static int numberOfSubstrings(String s){
        Map<Character,Integer> freqMap = new HashMap<Character,Integer>();
        int leftPointer =0, result =0;
        for(int rightPointer=0; rightPointer<s.length(); rightPointer++) {

            char rc = s.charAt(rightPointer);
            freqMap.put(rc, freqMap.getOrDefault(rc, 0) + 1);

            while (freqMap.getOrDefault('a', 0) > 0 &&
                   freqMap.getOrDefault('b', 0) > 0 &&
                   freqMap.getOrDefault('c', 0) > 0) {
                char leftCharacter = s.charAt(leftPointer);
                freqMap.put(leftCharacter, freqMap.get(leftCharacter) - 1);
                leftPointer++;
            }

            result = result + leftPointer;
        }
        return result;
    }

    // 2nd Similar code (9ms TC)
    public static int numberOfSubstrings2(String s){
        int count = 0;
        int[] map = new int[3];
        int left = 0;
            for(int right = 0;right < s.length() ; right++){
                map[s.charAt(right) - 'a']++;
            while(map[0] > 0 && map[1] > 0 && map[2] > 0){
                map[s.charAt(left++) - 'a']--;
            }
                count+= left;
            }
            return count;
    }

    public static void main(String[] args) {
        String s = "aaacb";
        System.out.println(numberOfSubstrings2(s));


    }

}
