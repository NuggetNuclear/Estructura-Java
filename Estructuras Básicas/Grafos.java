import java.util.ArrayList;
import java.util.HashMap;

public class Grafos {
    public record Arista(String destino, int costo) {
    }

    private HashMap<String, ArrayList<Arista>> listaAdyacencia;

    public Grafos(String destino, int costo)  {
        listaAdyacencia = new HashMap<>();
    }

    public void agregarConexion(String origen, String destino, int costo) {
        listaAdyacencia.computeIfAbsent(origen, k -> new ArrayList<>()).add(new Arista(destino, costo));
        listaAdyacencia.computeIfAbsent(destino, k -> new ArrayList<>()).add(new Arista(origen, costo));
    }

    public ArrayList<Arista> obtenerConexiones(String vertice) {
        return listaAdyacencia.getOrDefault(vertice, new ArrayList<>());
    }

    public ArrayList<String> obtenerVertices() {
        return new ArrayList<>(listaAdyacencia.keySet());
    }

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