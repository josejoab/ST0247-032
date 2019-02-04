public class Arco {

    String inicio;
    String llegada; 
    String distancia;
    String nombre; // nombre del vértice

      public Arco (String ID1, String ID2, String distancia, String nombre) {
        this.inicio = ID1;
        this.llegada = ID2;
        this.distancia = distancia;
        this.nombre = nombre;      
    }
    
}
