import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Run the program from commandline and pass the textfile as an argument using the following commands:
 * 1) "javac Exercise_21_03.java" to compile the class file
 * 2) "java Exercise_21_03 Students.txt" to run the program and pass Students.txt as an argument
 *
 * Missing the requirement: print last name if first name already exists in the set
 */

public class Exercise_21_03 {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("Usage: java fileName");
            System.exit(1);
        }

        File textFile = new File(args[0]);
        if (!textFile.exists()) {
            System.out.println("The file " + args[0] + " does not exist");
            System.exit(2);
        }

        TreeSet<String> set = new TreeSet<>();

        try (Scanner input = new Scanner(textFile)) {
            while (input.hasNext()) {

                String[] words = input.nextLine().split("[\\p{P}]");
                for (String word :
                        words) {
                    if (word.length() > 0){
                        String firstName = word.split("[\\s{P}]")[0];
                        if (!set.contains(firstName)){
                            set.add(firstName);
                        }
                        else
                            set.add(word);
                    }
                }
            }
        }

        System.out.println(set);
    }
}
