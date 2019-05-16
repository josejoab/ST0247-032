package ProyectoFinalFinalv4Remasterizada;

import java.util.LinkedList;

/**
 * Clase que almacena los datos de cada vertice
 * @author Joab and Kevin
 */
public class Vertices {

    LinkedList<Arcos> listica; //Lista que almacena todos los arcos del vertice
    int id;  //Atributo que indica el id del vertice
    int costoDestino;  //Atributo que indica el tiempo que toma viajar del nodo hasta el destino

    public Vertices(int id, int costoDestino) {
        this.id = id;
        this.costoDestino = costoDestino;
        listica = new LinkedList<>();
    }
    
    /**
     * Metodo que retorna el id del vertice
     * @return 
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Metodo que retorna el tiempo que tarda en ir desde el vertice hacia el destino
     * @return 
     */
    public int getCostoDestino(){ return this.costoDestino; }

}
