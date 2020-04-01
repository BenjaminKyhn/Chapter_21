import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Enter absolute path and remember to add .txt to the filename
 */

public class Exercise_21_06 {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: txt fileName");
            System.exit(1);
        }

        File textFile = new File(args[0]);
        if (!textFile.exists()) {
            System.out.println("The file " + args[0] + " does not exist");
            System.exit(2);
        }

        Map<String, Integer> map = new TreeMap<>();
        String[] names = getWords(textFile);

        for (int i = 0; i < names.length; i++) {
            String key = names[i];

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

        map.forEach((k, v) -> System.out.println(k + ":\t\t\t" + v));
    }

    public static String[] getWords(File textFile) throws FileNotFoundException {
        try (Scanner input = new Scanner(textFile)){
            while (input.hasNext()){
                String[] words = input.nextLine().split("[\\p{P}]");
                return words;
            }
        }
        return null;
    }
}