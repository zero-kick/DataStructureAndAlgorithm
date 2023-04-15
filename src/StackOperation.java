import java.util.Stack;

public class StackOperation {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new Stack<Integer>();

        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);

        System.out.println(stackInt);

        stackInt.pop();
        System.out.println(stackInt);
        stackInt.pop();
        System.out.println(stackInt);
        stackInt.pop();
        System.out.println(stackInt);
    }
}
