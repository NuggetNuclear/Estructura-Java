package Implementacion;

public class Tree {
    public static class Node {
        private Cancion data;
        private Node left, right;

        public Node(Cancion data){
            this.data = data;
            left = right = null;
        }

        public Cancion getData(){ return data; }

        public Node getLeft(){ return left; }

        public Node getRight(){ return right; }

        public void setLeft(Node left){ this.left = left; }

        public void setRight(Node right){ this.right = right; }
    }

    private Node root;

    public Tree(){
        root = null;
    }

    public Node getRoot(){ return root; }

    public Node insertar(Node root, Cancion data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (data.getNombre().compareTo(current.getData().getNombre()) < 0) {
                current = current.getLeft();
            } else if (data.getNombre().compareTo(current.getData().getNombre()) > 0) {
                current = current.getRight();
            } else {
                return null;
            }
        }

        // Inserta el nuevo nodo en el lugar correcto
        if (data.getNombre().compareTo(parent.getData().getNombre()) < 0) {
            parent.setLeft(new Node(data));
        } else {
            parent.setRight(new Node(data));
        }

        return root;
    }

    public Node buscarPorNombre(Node root, String nombre){
        if (root == null || root.getData().getNombre().equals(nombre)) {
            return root;
        }

        if (nombre.compareTo(root.getData().getNombre()) < 0) {
            return buscarPorNombre(root.getLeft(), nombre);
        }

        return buscarPorNombre(root.getRight(), nombre);
    }

    public Node buscarPorDuracion(Node root, int duracion){
        if (root == null || root.getData().getDuracion() == duracion) {
            return root;
        }

        if (duracion < root.getData().getDuracion()) {
            return buscarPorDuracion(root.getLeft(), duracion);
        }

        return buscarPorDuracion(root.getRight(), duracion);
    }
}
