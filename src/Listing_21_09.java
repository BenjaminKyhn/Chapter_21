import java.util.Map;
import java.util.TreeMap;

public class Listing_21_09 {
    public static void main(String[] args) {
        // Set text in a String
        String text = "Good morning. Have a good class. Have a good visit. Have fun!";

        // Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new TreeMap<>();

        String[] words = text.split("[\\s+\\p{P}]"); // \\s = white space, \\p = punctuation
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if (key.length() > 0){
                if (!map.containsKey(key)){
                    map.put(key, 1);
                }
                else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }

        // Display key and value for each entry
        map.forEach((k, v) -> System.out.println(k + "\t" + v));
    }
}
