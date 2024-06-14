package Implementacion;

public class Cancion {
    private String nombre;
    private int duracion;
    private int id;

    public Cancion(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre() { return nombre; }

    public int getDuracion() { return duracion; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}