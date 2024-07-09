public class Tree {

    // Clase interna que representa un nodo, contiene la información y referencias a los nodos hijos "left" y "right").
    
    public static class Node {
        private int data;
        private Node left, right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }

        // Getters y Setters

        public int getData(){ return data; }

        public Node getLeft(){ return left; }

        public Node getRight(){ return right; }

        public void setLeft(Node left){ this.left = left; }

        public void setRight(Node right){ this.right = right; }
    }

    // Crea el nodo raiz (primer nodo del arbol).

    private Node root;

    // Constructor (inicializa la raiz en null).
    
    public Tree(){
        root = null;
    }

    // Getter (raiz).

    public Node getRoot(){ return root; }

    // Método para insertar en el arbol.

    public Node insertar(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        Node current = root;
        Node parent = null;

        // Recorre el arbol hacia abajo para encontrar espacio.
        
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

        // Inserta el nuevo nodo en el lugar correcto.
        
        if (data.getNombre().compareTo(parent.getData().getNombre()) < 0) {
            parent.setLeft(new Node(data));
        } else {
            parent.setRight(new Node(data));
        }

        // Retorna la raiz del árbol.

        return root;
    }
}
