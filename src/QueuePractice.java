import java.util.ArrayList;

public class QueuePractice<T> {
    // ArryaList 클래스를 활용한 Queue 구현
    private ArrayList<T> queue = new ArrayList<T>();

    public void enqueue(T val) {
        queue.add(val);
    }

    public T dequeue() {
        if(queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    public static void main(String[] args) {

        QueuePractice<Integer> queInt = new QueuePractice<Integer>();

        queInt.enqueue(1);
        queInt.enqueue(2);
        queInt.enqueue(3);

        System.out.println(queInt.queue);
        System.out.println("dequeue : " +queInt.dequeue());
        System.out.println(queInt.queue);
        System.out.println("dequeue : " +queInt.dequeue());
        System.out.println(queInt.queue);
        System.out.println("dequeue : " +queInt.dequeue());
        System.out.println(queInt.queue);
    }

}
