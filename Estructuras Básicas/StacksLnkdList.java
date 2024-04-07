import java.util.EmptyStackException;

public class StacksLnkdList {

    private Node top;

    private class Node {
        int value;
        Node next;
    }

    public void push(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        int value = top.value;
        top = top.next;
        return value;
    }

    public int peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}