package Laboratorios.Laboratorio2;

public class Stack {
private int maxSize;
private int top;
private int[] stackArray;

public Stack(int size) {
    maxSize = size;
    stackArray = new int[maxSize];
    top = -1;
}

public boolean isEmpty() {
    return (top == -1);
}

public boolean isFull() {
    return (top == maxSize - 1);
}

public void push(int value) {
    if (isFull()) {
        System.out.println("Stack is full. Cannot push element.");
    } else {
        stackArray[++top] = value;
    }
}

public int pop() {
    if (isEmpty()) {
        System.out.println("Stack is empty. Cannot pop element.");
        return -1;
    } else {
        return stackArray[top--];
    }
}

public int peek() {
    if (isEmpty()) {
        System.out.println("Stack is empty. Cannot peek element.");
        return -1;
    } else {
        return stackArray[top];
    }
}
}