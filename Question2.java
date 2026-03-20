import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Question2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Masukkan nama stand: ");

            String user = sc.nextLine();
            String[] names = sc.nextLine().split(" ");

            Queue<String> queue = new LinkedList<>(Arrays.asList(names));

            Stack<String> tertangkap = new Stack<>();

            Stand stand;
            stand = switch (user) {
                case "Josuke" -> new Josuke();
                case "Jotaro" -> new Jotaro();
                case "Okuyasu" -> new Okuyasu();
                case "Koichi" -> new Koichi();
                case "Rohan" -> new Rohan();
                default -> new Stand();
            };

            boolean exposed = false;

            while (!queue.isEmpty()) {
                String name = queue.poll();

                if (stand.tertangkap(name)) {
                    tertangkap.push(name);
                    exposed = true;
                }
            }

            if (exposed) {
                System.out.println(user + " exposed someone!");
            } else {
                System.out.println(user + " exposed no one.");
            }

            System.out.println("Arrested: " +tertangkap);
        }
    }
}
    

    class Stand {
        public boolean tertangkap(String name) {
            return false;
        }
    }

    class Josuke extends Stand {
        @Override
        public boolean tertangkap(String name) {
            return name.startsWith("k");
        }
    }

    class Jotaro extends Stand {
        @Override
        public boolean tertangkap(String name) {
            return name.length() <=3;
        }
    }

    class Okuyasu extends Stand {
        @Override
        public boolean tertangkap(String name) {
            for (int i = 0; i < name.length() - 1; i++) {
                if (name.charAt(i) == name.charAt(i + 1)) {
                    return true;
                }  
            }
            return false;
        }
    }

    class Koichi extends Stand {
        @Override
        public boolean tertangkap(String name) {
            int count = 0;
        for (char c : name.toCharArray()) {
            if ("aeiou".contains(String.valueOf(c))) {
                count++;
            }
        }
            return count >= 3;
        }
    }

    class Rohan extends Stand {
        public boolean expose(String name) {
            String reversed = new StringBuilder(name).reverse().toString();
                return name.equals(reversed);
        }
    }    