package tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Duplicates {
    public static void main(String[] args) {

        String string = "Programming";
        char[] characters = string.toCharArray();

        Map<Character, Integer> charMap = new HashMap<>();
        for(Character ch: characters){
            if(charMap.containsKey(ch)){
                charMap.put(ch,charMap.get(ch)+1);
            }else charMap.put(ch,1);
        }

        Set<Map.Entry<Character,Integer>> entrySet= charMap.entrySet();
        for(Map.Entry<Character,Integer> entry:entrySet){
            if(entry.getValue()>1){
                System.out.printf("%s :%d %n",entry.getKey(), entry.getValue());
            }
        }

    }
}
