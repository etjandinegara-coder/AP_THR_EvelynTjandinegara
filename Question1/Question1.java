import java.time.Month;
import java.util.*;

public class Question1 {
    public static void main(String[] args) {
         try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Masukkan inputan: ");

            String input = sc.nextLine();
        String[] words = input.split(" ");

        List<String[]> pairs = new ArrayList<>();
        for (int i = 0; i < words.length; i += 2) {
            pairs.add(new String[]{words[i], words[i + 1]});
        }

        pairs.sort(Comparator.comparingInt(pair ->
                Month.valueOf(pair[1].toUpperCase()).getValue()
        ));

        Stack<String> stack = new Stack<>();
        for (String[] pair : pairs) {
            stack.push(pair[0]);
            stack.push(pair[1]);
        }

        String[] output = stack.toArray(String[]::new);

        System.out.println(Arrays.toString(output));
        }
    }
}
