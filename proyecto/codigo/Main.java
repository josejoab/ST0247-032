package ProyectoFinalFinalv4Remasterizada;
//j117

import java.io.IOException;

/**
 * clase main encargada de llamar los metodos del proyecto
 * @author Joab and Kevin
 */
public class Main {

    public static void main(String[] args) throws IOException {

        try{
            System.out.println("--------------INICIO DEL PROCESO---------------");
            long TInicio, TFin, tiempo;
            TInicio = System.currentTimeMillis();

            Lector nuevoLector = new Lector(); // instancia de la clase lector
            Escritor nuevoEscritor = new Escritor(); // instancia de la clase escritor
            String dataset = "dataset-ejemplo-U=205-p=1.3.txt";

            int[][] matrAux = nuevoLector.leerArchivo("C:\\Users\\ASUS\\Documents\\UNIVERSIDAD\\semestre III\\estructura de datos y algoritmos II"
                    + "\\proyecto\\ProyectoFinalFinalv4Remasterizado\\src\\test\\"+dataset
            ); // matriz de adyacencia

            double p = nuevoLector.p; //porcentaje de tiempo extra

            Estructura est = new Estructura(matrAux, p); // instancia de la clase estructura

            Vertices[] arrVertAux = (est.ordenarLinkedList(est.ordenarArregloVertices(est.asignarEnObjeto(
                    est.asignarObjetoEnArreglo())))
            ); // metodos que realizan la estructura de datos y obtienen la solución

            nuevoEscritor.escribir(est.direccionEnHashMap(arrVertAux), dataset); //escribir la respuesta

            System.out.println("--------------PROCESO TERMINADO----------------");

            TFin = System.currentTimeMillis();
            tiempo = TFin - TInicio;
            System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
        }
        catch(Exception e){
            System.out.println("No se realizó el proceso");
            System.out.println("error: "+e);
        }
    }
}
