package Implementaciones;

public class cola<E> extends ListaEnlazada<E>{
    
    public cola() {
    }

    public void encolar(E data) {
        add(data);
    }

    public E desencolar() {
        return remove();
    }

    public E frente() {
        return get(0);
    }
}