public record Cancion(String Nombre, String Artista, String Album, int Duracion) {

    public void imprimirInformacion() {
        System.out.println("Nombre: " + Nombre);
        System.out.println("Artista: " + Artista);
        System.out.println("Album: " + Album);
        System.out.println("Duración: " + Duracion + " segundos");
    }

    public boolean equals(Cancion cancion) {
        if (cancion != null) {
            if (cancion.Nombre() != Nombre()) {
                return false;
            } else if (cancion.Artista() != Artista()) {
                return false;
            } else if (cancion.Album() != Album()) {
                return false;
            } else if (cancion.Duracion() != Duracion()){
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}