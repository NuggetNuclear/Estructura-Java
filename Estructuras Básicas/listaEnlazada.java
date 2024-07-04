public class ListaEnlazada<E> {

    private Node<E> head;
    private int tamano;

    public static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    public listaEnlazada() {
        head = null;
        tamano = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return tamano;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        tamano++;
    }

    public void addAt(int index, E data) {
        if (index < 0 || index > tamano) {
            return;
        } else {
            Node<E> newNode = new Node<>(data);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node<E> current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
            tamano++;
        }
    }

    public E remove() {
        if (isEmpty()) {
            return null;
        } else {
            E data = head.data;
            head = head.next;
            return data;
        }
    }

    public boolean remove(E data) {
        if (!isEmpty()) {
            Node<E> current = head;

            if (current.data == data) {
                head = head.next;
                tamano--;
                return true;
            }

            while (current.data != data && current.next != null) {
                current = current.next;
            }

            if (current.data == data) {

                if (current.next == null) {
                    current = null;
                } else {
                    current.data = current.next.data;
                    current.next = current.next.next;
                    tamano--;
                }
                return true;

            }

        }
        return false;
    }

    public E get(int index) {
        if (index < 0 || index >= tamano) {
            return null;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }
    }

    public void set(int index, E data) {
        if (index < 0 || index >= tamano) {
            return;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.data = data;
        }
    }
}