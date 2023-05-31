package Map;

import java.util.Map;
import java.util.TreeMap;

public class CountMap {
    public static void main(String[] args) {
        String str = "CodeGym for life! Bye bye for good!";
        String str1 = str.toLowerCase();
        Map<Character, Integer> treeMap = new TreeMap<>();

        for (Character character : str1.toCharArray()){
            if (! treeMap.containsKey(character)) {
                treeMap.put(character, 1);
            } else {
                int count = treeMap.get(character);
                treeMap.replace(character, ++count);
            }
        }
        System.out.println(treeMap.entrySet());
    }
}
