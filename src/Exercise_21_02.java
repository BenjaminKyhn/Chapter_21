import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/** Run the program from commandline and pass the textfile as an argument using the following commands:
 * 1) "javac Exercise_21_02.java" to compile the class file
 * 2) "java Exercise_21_02 Students.txt" to run the program and pass Students.txt as an argument
 * */

public class Exercise_21_02 {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1){
            System.out.println("Usage: java fileName");
            System.exit(1);
        }

        File textFile = new File(args[0]);
        if (!textFile.exists()){
            System.out.println("The file " + args[0] + " does not exist");
            System.exit(2);
        }

        TreeSet<String> set = new TreeSet<>();

        try (Scanner input = new Scanner(textFile)){
            while (input.hasNext()){
                String[] words = input.nextLine().split("[\\s+\\p{P}]");
                for (String word :
                        words) {
                    if (word.length() > 0)
                        set.add(word.toLowerCase());
                }
            }
        }

        System.out.println(set);
    }
}
