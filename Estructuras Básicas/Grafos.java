import java.util.ArrayList;
import java.util.HashMap;

public class Grafos {

    // Clase de una arista
    
    public record Arista(String destino, int costo) {
    }

    // HashMap con la lista de adyacencia (Almacena la información del nodo y una lista de conexiones con otros nodos (aristas)).
    
    private HashMap<String, ArrayList<Arista>> listaAdyacencia;

    // Constructor

    public Grafos(String destino, int costo)  {
        listaAdyacencia = new HashMap<>();
    }

    // Método que crea una arista (con su respectivo origen, destino y costo).

    public void agregarConexion(String origen, String destino, int costo) {

        // ComputeIfAbsent: Si ya existe conexion, no crea nuevamente, si no, la crea).
        
        listaAdyacencia.computeIfAbsent(origen, k -> new ArrayList<>()).add(new Arista(destino, costo));
        listaAdyacencia.computeIfAbsent(destino, k -> new ArrayList<>()).add(new Arista(origen, costo));
    }

    // Getter de todas las arista de un nodo.

    public ArrayList<Arista> obtenerConexiones(String vertice) {
        return listaAdyacencia.getOrDefault(vertice, new ArrayList<>());
    }

    public ArrayList<String> obtenerVertices() {
        return new ArrayList<>(listaAdyacencia.keySet());
    }

    // Imprimir la información del grafo.

    public void imprimirGrafo() {
        System.out.println("Grafo:");
        for (String vertice : listaAdyacencia.keySet()) {
            System.out.print(vertice + " -> ");
            ArrayList<Arista> conexiones = listaAdyacencia.get(vertice);
            for (Arista conexion : conexiones) {
                System.out.print(conexion.destino + " ");
            }
            System.out.println();

        }
    }
}
