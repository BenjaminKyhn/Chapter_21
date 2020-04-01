import java.util.HashSet;
import java.util.Set;

public class Exercise_21_01 {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("Chemistry");
        set1.add("Mathematics");
        set1.add("Biology");
        set1.add("English");

        Set<String> set2 = new HashSet<>();
        set2.add("Biology");
        set2.add("English");
        set2.add("Geography");
        set2.add("Physics");

        Set<String> set3 = new HashSet<>(set1);
        Set<String> set4 = new HashSet<>(set2);
        set3.removeAll(set4);
        System.out.println("(1) Elements that are only present in set1 are " + set3);

        set3 = new HashSet<>(set1);
        set4 = new HashSet<>(set2);
        set4.removeAll(set3);
        System.out.println("(2) Elements that are only present in set2 are " + set4);

        set3 = new HashSet<>(set1);
        set4 = new HashSet<>(set2);
        set3.retainAll(set4);
        System.out.println("(3) Elements that are present in both stacks are: " + set3);
    }
}
