import Implementaciones.listaEnlazada;
import Implementaciones.cola;

import java.util.Random;

public class Reproductor {

    private listaEnlazada<Cancion> listaPlaylists = new listaEnlazada<>();
    private cola<Cancion> colaReproduccion = new cola<>();

    Reproductor() {
    }

    // Getters

    public listaEnlazada<Cancion> getListaPlaylists() {
        return listaPlaylists;
    }

    public cola<Cancion> getColaReproduccion() {
        return colaReproduccion;
    }

    // Métodos

    public void agregarCancionCola(Cancion c) {
        colaReproduccion.encolar(c);
    }

    public void eliminarCancionCola(Cancion c) {
        colaReproduccion.desencolar();
    }

    public void reproducirColaEnOrden() {
        while (!colaReproduccion.isEmpty()) {
            colaReproduccion.desencolar().imprimirInformacion();
        }
    }

    public void reproducirPlaylistEnOrden(Playlist p) {
        for (int i = 0; i < p.getCanciones().size(); i++) {
            p.getCancion(i).imprimirInformacion();
        }
    }

    public void reproducirPlaylistAleatorio(Playlist p) {
        if (p.getCanciones().isEmpty()) {
            System.out.println("La playlist está vacía");
            return;
        } else {
            Random random = new Random();
            int n = p.getCanciones().size();
            for (int i = n - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                Cancion temp = p.getCanciones().get(i);
                p.getCanciones().set(i, p.getCanciones().get(j));
                p.getCanciones().set(j, temp);
            }

            for (int i = 0; i < n; i++) {
                p.getCancion(i).imprimirInformacion();
            }
        }
    }

    public void reproducirIntercalandoAleatorio(Playlist p1, Playlist p2) {
        if (p1.getCanciones().isEmpty() || p2.getCanciones().isEmpty()) {
            System.out.println("Alguna de las playlists está vacía");
        } else {
            cola<Cancion> colaIntercalada = new cola<>();

            cola<Cancion> cola1 = new cola<>();
            cola<Cancion> cola2 = new cola<>();

            for (int i = 0; i < p1.getCanciones().size(); i++) {
                cola1.encolar(p1.getCancion(i));
            }

            for (int i = 0; i < p2.getCanciones().size(); i++) {
                cola2.encolar(p2.getCancion(i));
            }

            cola1 = desordenarCola(cola1);
            cola2 = desordenarCola(cola2);

            while (!cola1.isEmpty() && !cola2.isEmpty()) {
                colaIntercalada.encolar(cola1.desencolar());
                colaIntercalada.encolar(cola2.desencolar());
            }

            while (!colaIntercalada.isEmpty()) {
                colaIntercalada.desencolar().imprimirInformacion();
            }
        }
    }

    // Metodos auxiliares

    public cola<Cancion> desordenarCola(cola<Cancion> Cola) {
        cola<Cancion> listaDesordenada = new cola<>();
        Random random = new Random();

        while (!Cola.isEmpty()) {
            int n = Cola.size();
            int i = random.nextInt(n);
            Cancion cancion = Cola.desencolar();
            listaDesordenada.addAt(i, cancion);
        }

        return listaDesordenada;
        }
    }