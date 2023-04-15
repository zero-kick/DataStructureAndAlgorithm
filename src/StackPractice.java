import java.util.ArrayList;

public class StackPractice<T> {

    private ArrayList<T> stack = new ArrayList<T>();

    public void push(T val) {
        stack.add(val);
    }

    public T pop() {
        if(stack.isEmpty()) return null;

        return stack.remove(stack.size()-1);
    }

    public static void main(String[] args) {

        StackPractice<Integer> stackInt = new StackPractice<Integer>();

        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);

        System.out.println(stackInt.stack);

        stackInt.pop();
        System.out.println(stackInt.stack);
        stackInt.pop();
        System.out.println(stackInt.stack);
        stackInt.pop();
        System.out.println(stackInt.stack);

    }

}
