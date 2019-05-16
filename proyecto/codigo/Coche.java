package ProyectoFinalFinalv4Remasterizada;

import java.util.LinkedList;

/**
 * Clase que se encarga de almacenar los vertices
 * @author Joab and Kevin
 */
public class Coche {

    LinkedList<Integer> verticesEnCoche; //Lista donde se almacenan los vertices
    int costoMaximo;	//Atributo que almacena el tiempo del recorrido total

    public Coche(LinkedList<Integer> verticesEnCoche, int costoMaximo){
        this.verticesEnCoche = verticesEnCoche;
        this.costoMaximo = costoMaximo;
    }

}
