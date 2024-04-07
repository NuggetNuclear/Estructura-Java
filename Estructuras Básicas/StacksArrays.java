import java.lang.IllegalStateException;
import java.util.ArrayList;


public class StacksArrays {

    public class Stack<T> {
        private ArrayList<T> elements;

        public Stack() {
            elements = new ArrayList<>();
        }

        public void push(T element) {
            elements.add(element);
        }

        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return elements.remove(elements.size() - 1);
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }

            return elements.get(elements.size() - 1);
        }

        public boolean isEmpty() {
            return elements.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hola mundo");
    }
}
