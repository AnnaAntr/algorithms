package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

// LeetCode #20
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("[(())]"));
        System.out.println(isValid("[(}())]"));
    }


    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);
            if (currChar == '[' || currChar == '(' || currChar == '{')
                stack.push(currChar);

            else {
                if (stack.isEmpty())
                    return false;

                Character peekChar = stack.peek();
                if (peekChar == '[' && currChar != ']' ||
                    peekChar == '(' && currChar != ')' ||
                    peekChar == '{' && currChar != '}')
                    return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
