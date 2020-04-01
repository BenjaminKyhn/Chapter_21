import java.io.File;
import java.util.*;

/**
 * Enter absolute path and remember to add .txt to the filename
 */

public class Exercise_21_04 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a text source file: ");
        String filename = input.nextLine();

        File file = new File(filename);
        if (file.exists()) {
            System.out.println("The number of vowels in " + filename + " is " + countChars(file)[0]);
            System.out.println("The number of consonants in " + filename + " is " + countChars(file)[1]);
        } else {
            System.out.println("File " + filename + " does not exist");
        }
    }

    public static int[] countChars(File file) throws Exception {
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
        int[] chars = {0, 0}; // Store vowel count in index 0 and consonant count in index 1

        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String line = input.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (vowelSet.contains(Character.toUpperCase(line.charAt(i))))
                    chars[0]++; // increase vowels
                else if (Character.isLetter(line.charAt(i)))
                    chars[1]++; // increase consonants
            }
        }
        return chars;
    }
}
