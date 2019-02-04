public class Vertice {
    String  ID;
    String x; // coordenada en el eje x
    String y; // coordenada en el eje y
    String nombre; // nombre del vértice

    public Vertice (String ID, String x, String y, String nombre) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.nombre = nombre;      
    }
     public Vertice (String ID, String x, String y) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.nombre = "desconocido";      
    }


}
