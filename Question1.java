
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Question1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan inputan string : ");

            String input = scanner.nextLine();
            String[] words = input.split(" ");

            Stack<String[]> stack = new Stack<>();

            for (int i = 0; i < words.length; i = i + 2) {
                String[] pair = {words[i], words[i+1]};
                stack.push(pair);
            }

            List<String> result = new ArrayList<>();
            
            while (!stack.isEmpty()){
                String[] pair = stack.pop();
                result.add(pair[0]);
                result.add(pair[1]);
            }

            System.out.println("Outputnya :" + result);
        }
    }
}