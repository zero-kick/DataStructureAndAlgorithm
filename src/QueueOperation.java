import java.util.LinkedList;
import java.util.Queue;

public class QueueOperation {
    public static void main(String[] args) {
        Queue<Integer> queInt = new LinkedList<Integer>();

        queInt.add(1);
        queInt.offer(2);

        System.out.println(queInt);

        queInt.poll();
        System.out.println(queInt);
        queInt.remove();
        System.out.println(queInt);
    }
}
