import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashMap;


public class Dijkstra {
    private class Node implements Comparable<Node> {
        String nombre;
        int costo;
        ArrayList<String> camino;

        public Node(String nombre, int costo, ArrayList<String> camino) {
            this.nombre = nombre;
            this.costo = costo;
            this.camino = camino;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.costo, other.costo);
        }
    }

    public Dijkstra(){
    }

    public String caminoMasCorto(Graph graph, String comienzo, String destino) {
        PriorityQueue<Node> colaPrioridad = new PriorityQueue<>();

        HashMap<String, Integer> distancias = new HashMap<>();
        HashMap<String, String> anteriores = new HashMap<>();

        colaPrioridad.add(new Node(comienzo, 0, new ArrayList<>()));
        distancias.put(comienzo, 0);

        while(!colaPrioridad.isEmpty()) {
            Node current = colaPrioridad.poll();

            if(current.nombre.equals(destino)) {
                return construirPalabra(graph, anteriores, comienzo, destino);
            }

            if(current.costo > distancias.getOrDefault(current.nombre, Integer.MAX_VALUE)) {
                continue;
            }

            for(var arista : graph.obtenerConexiones(current.nombre)) {
                String destinoArista = arista.destino();
                int costoArista = arista.costoArista();
                int nuevoCosto = current.costo + costoArista;
                if(nuevoCosto < distancias.getOrDefault(destinoArista, Integer.MAX_VALUE)) {
                    distancias.put(destinoArista, nuevoCosto);
                    anteriores.put(destinoArista, current.nombre);
                    ArrayList<String> nuevoCamino = new ArrayList<>(current.camino);
                    nuevoCamino.add(destinoArista);
                    colaPrioridad.add(new Node(destinoArista, nuevoCosto, nuevoCamino));
                }
            }

        }

        return null;
    }

    private String construirPalabra(Graph graph, HashMap<String, String> anteriores, String comienzo, String destino) {
        StringBuilder palabra = new StringBuilder();
        String actual = destino;

        while(!actual.equals(comienzo)) {
            String anterior = anteriores.get(actual);
            for(var arista : graph.obtenerConexiones(anterior)) {
                if(arista.destino().equals(actual)) {
                    palabra.insert(0, arista.letra());
                    break;
                }
            }
            actual = anterior;
        }

        return palabra.toString();
    }
}