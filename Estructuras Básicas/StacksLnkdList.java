import java.util.EmptyStackException;

public class StacksLnkdList {

    private Node top;

    private class Node {  // Se crea una clase interna Node
        int value;
        Node next;
    }

    public void push(int value) { // Se añade un elemento al tope de la pila
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = top;
        top = newNode;
    }

    public int pop() { // Se elimina el elemento del tope de la pila
        if (top == null) {
            throw new EmptyStackException();
        }
        int value = top.value;
        top = top.next;
        return value;
    }

    public int peek() { // Se obtiene el elemento del tope de la pila
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public boolean isEmpty() { // Se verifica si la pila está vacía
        return top == null;
    }
}