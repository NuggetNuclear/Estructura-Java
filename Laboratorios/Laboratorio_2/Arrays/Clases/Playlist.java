

public class Playlist {
    private String Nombre;
    private Cancion[] Canciones;
    private int indice;

    public Playlist(String Nombre) {
        this.Nombre = Nombre;
        Canciones = new Cancion[10];
        indice = 0;
    }

    // Getters y Setters

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Cancion[] getCanciones() {
        return Canciones;
    }

    public Cancion getCancion(int index){
        return Canciones[index];
    }

    public int size() {
        return indice - 1;
    }

    // Métodos principales

    public void anadirCancion(Cancion c) {
        if (indice >= Canciones.length) {
            Cancion[] arregloAuxiliar = new Cancion[(int) (Canciones.length * 1.5)];
            System.arraycopy(Canciones, 0, arregloAuxiliar, 0, Canciones.length);
            Canciones = arregloAuxiliar;
        }
        Canciones[indice] = c;
        indice++;
    }

    public boolean eliminarCancion(Cancion c) {
        for (int i = 0; i < Canciones.length; i++) {
            if (Canciones[i].equals(c)) {
                Canciones[i] = null;

                if (i < Canciones.length - 1) {
                    for(int j = i; j < Canciones.length - 1; j++) {
                        Canciones[j] = Canciones[j + 1];
                    }
                    Canciones[Canciones.length - 1] = null;
                }
            
                indice--;

                return true;
            }
        }
        return false;
    }

    public void editarPlaylist(int i, int j) {
        if(i < indice && j < indice && i >= 0 && j >= 0) {
            Cancion temp = Canciones[i];

            Canciones[i] = Canciones[j];
            Canciones[j] = temp;
        } else {
            return;
        }
    }

    // Métodos auxiliares

    public void compactarArreglo()
    {
        Cancion[] nuevoArreglo = new Cancion[Canciones.length];
        int indiceNuevo = 0;

        for (int i = 0; i < indice; i++) {
            if (Canciones[i] != null) {
                nuevoArreglo[indiceNuevo] = Canciones[i];
                indiceNuevo++;
            }
        }

        Canciones = nuevoArreglo;
        indice = indiceNuevo;
    }
}
