import java.lang.IllegalStateException;
import java.util.ArrayList;

public class QueueArrays<T> {
    private ArrayList<T> queue;
    
    public QueueArrays() {
        queue = new ArrayList<>();
    }
    
    public void enqueue(T element) {
        queue.add(element);
    }
    
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.remove(0);
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.get(0);
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public int size() {
        return queue.size();
    }
}