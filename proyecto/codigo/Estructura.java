package ProyectoFinalFinalv4Remasterizada;

import java.util.*;

/**
 * clase que se encargará de crear las estructuras de datos y asignar los vehiculos 
 * @author Joab and Kevin 
 */
public class Estructura {

    int [][] matricia;  //matriz de adyacencia
    double p;           //porcentaje de tiempo extra

    public Estructura(int [][] matricia, double p){
        this.matricia = matricia;
        this.p = p;
    }

    /**
     * este método se encarga de crear un arreglo con los vértices extraidos de la matriz de adyacencia 
     * @return arregloVertices
     */
    public Vertices[] asignarObjetoEnArreglo() {

        Vertices[] arregloVertices = new Vertices[matricia.length-2];

        for (int i = 2; i < matricia.length; i++) {
            int pesollegado = matricia[i][1];
            Vertices nuevoVert = new Vertices(i, pesollegado);
            arregloVertices[i-2] = nuevoVert;
        }
        return arregloVertices;
    }

    /**
     * este método se encarga de crear los arcos de cada uno de los vértices 
     * @param arregloVertices
     * @return arregloVertices
     */
    public Vertices[] asignarEnObjeto(Vertices[] arregloVertices){
        for(int i = 2; i<matricia.length; i++){
            for (int j = 2; j<matricia[i].length; j++){
                if(i!=j){
                    Arcos nuevoArco = new Arcos(j, matricia[i][j], matricia[j][1]);
                    arregloVertices[i-2].listica.add(nuevoArco);
                }
            }
        }

        return arregloVertices;
    }

    /**
     * este método se encarga de ordenar el arreglo de vertices de mayor a menor con respecto a la distancia que hay entre ellos hacia el 
     * destino (vertice 1)
     * @param arregloVertices
     * @return arregloVertices
     */
    public Vertices[] ordenarArregloVertices(Vertices[] arregloVertices) {
        Arrays.sort(arregloVertices, Comparator.comparing(Vertices::getCostoDestino).reversed());

        return arregloVertices;
    }
    
    /**
     * este metodo se encarga de ordenar el linkedlist de los arcos de cada vértice de menor a mayor
     * con respecto a la distancia de cada arco
     * @param arregloVertices
     * @return 
     */
    public Vertices[] ordenarLinkedList(Vertices[] arregloVertices){
        for (int i = 0; i<arregloVertices.length; i++) {
            Collections.sort(arregloVertices[i].listica, Comparator.comparingInt(Arcos::getCosto));
        }

        return arregloVertices;
    }


    /**
     * este metodo se encargar de crear un hashmap que nos ayudará a encontrar la posición de un vértice en el arreglo de vértices (ahora ordenado)
     * @param arregloVertices
     * @return asignarCoches(mapita, arregloVertices)
     */
    public String direccionEnHashMap(Vertices[] arregloVertices) {


        HashMap<Integer, Integer> mapita = new HashMap<>();

        for (int i = 0; i < arregloVertices.length; i++) {
            mapita.put(arregloVertices[i].id, i);
        }

        return asignarCoches(mapita, arregloVertices);

    }

    /**
     * este metodo se encarga de asignar los vertices a cada vehiculo
     * @param mapita
     * @param arregloVertices
     * @return strRespuesta
     */
    public String asignarCoches(HashMap<Integer, Integer> mapita, Vertices[] arregloVertices){

        String strRespuesta = "P= "+p+"\n";
        boolean[] visitados = new boolean[arregloVertices.length+2];
        int contador = 1;

        for (int i = 0; i<arregloVertices.length; i++){
            if (!visitados[arregloVertices[i].getId()]){
                LinkedList<Integer> verticesEnCoche = new LinkedList<>();
                int acomulado = 0;
                int k = i;
                double condicion = arregloVertices[k].costoDestino * p;
                int currentCoche = 0;
                strRespuesta += "---------------NUEVO COCHE----#" + contador + "---------------" + "\n";
                while(acomulado + arregloVertices[k].costoDestino  <= condicion && verticesEnCoche.size() < 5 ) {
                    verticesEnCoche.add(arregloVertices[k].id);
                    if (verticesEnCoche.getLast() != currentCoche) {
                        currentCoche = verticesEnCoche.getLast();
                        strRespuesta += "Id: " + arregloVertices[k].id + "\n";
                        visitados[arregloVertices[k].getId()] = true;
                        for (Arcos listica : arregloVertices[k].listica) {
                            if (!visitados[listica.getIdlleg()]) {
                                if (verticesEnCoche.size() < 5) {
                                    acomulado += listica.costo;
                                } else if (verticesEnCoche.size() == 5) {
                                    acomulado += arregloVertices[k].costoDestino;
                                }
                                k = mapita.get(listica.getIdlleg());
                                break;
                            }
                        }
                    }
                }
                contador++;
            }
        }
        strRespuesta += "------------------------------------------------";
        return strRespuesta;
    }
}
