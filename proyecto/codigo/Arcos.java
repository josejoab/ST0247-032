package ProyectoFinalFinalv4Remasterizada;
/**
 * Clase que guarda los destinos desde un nodo inicio 
 * @author Joab and Kevin
 */
public class Arcos {

    int costoDestino; //Atributo que guarda el tiempo del nodo hacia el destino
    int idlleg;	      //Atributo que indica el id del vertice
    int costo;        //Atributo que almacena el tiempo desde el nodo inicio hasta el nodo destino
    
    public Arcos(int idlleg, int costo, int costoDestino){

        this.idlleg=idlleg;
        this.costo=costo;
        this.costoDestino=costoDestino;
    }
    
    /**
     * Metodo que retorna el id del vertice
     * @return 
     */
    public int getIdlleg(){
        return this.idlleg;
    }

    /**
     * Metodo que retorna el costo desde el vertice inicio hasta el vertice destino
     * @return 
     */
    public int getCosto(){
        return this.costo;
    }

}
