package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> brackets = new ArrayDeque<>();

        boolean notBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (currentSymbol == '(' || currentSymbol == '[' || currentSymbol == '{') {
                brackets.push(currentSymbol);
            } else {
                if (brackets.isEmpty()) {
                    notBalanced = true;
                    break;
                }

                char poppedSymbol = brackets.pop();

                if (currentSymbol == ')' && poppedSymbol != '(') {
                    notBalanced = true;
                    break;
                } else if (currentSymbol == ']' && poppedSymbol != '[') {
                    notBalanced = true;
                    break;
                } else if (currentSymbol == '}' && poppedSymbol != '{') {
                    notBalanced = true;
                    break;
                }
            }

        }

        if (notBalanced || !brackets.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }
}
