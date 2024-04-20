import java.lang.IllegalStateException;
import java.util.ArrayList;

public class QueueArrays<T> {
    private ArrayList<T> queue;
    
    public QueueArrays() {
        queue = new ArrayList<>();   // Se crea un ArrayList vacío
    }
    
    public void enqueue(T element) { // Se añade un elemento al final de la cola
        queue.add(element);
    }
    
    public T dequeue() {             // Se elimina el primer elemento de la cola
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía!");
        }
        return queue.remove(0);
    }
    
    public T peek() {               // Se obtiene el primer elemento de la cola
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía!");
        }
        return queue.get(0);
    }
    
    public boolean isEmpty() {      // Se verifica si la cola está vacía
        return queue.isEmpty();
    }
    
    public int size() {             // Se obtiene el tamaño de la cola
        return queue.size();
    }
}