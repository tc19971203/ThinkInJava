package holdingObjects.stack;


import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for(String s : "My dog has fleas".split(" ")){
            stack.push(s);
        }

        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
