import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; //por teclado
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import javafx.util.Pair;

public class Punto1 {

    /**
     * El metodo debe de leer el archivo y construir la estrcutura de datos con
     * el mapa
     *
     */
    public static void makeMap() throws IOException {
        HashMap<String, Pair<Vertice, LinkedList<Arco>>> vertices = new HashMap<String, Pair<Vertice, LinkedList<Arco>>>();
        boolean ver = true;
        String nombreDelArchivo = "C:\\Users\\Tiago\\OneDrive\\Escritorio\\medellin_colombia-grande.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            lineaActual = br.readLine();
            while (lineaActual != null) {
               // System.out.println(lineaActual);

                if (lineaActual.isEmpty())lineaActual = br.readLine();
                if (lineaActual.contains("Arcos"))ver = false;
                
                if (ver) {
                    String[] cadenaParticionada = lineaActual.split(" ");
                    if (cadenaParticionada.length > 3) {
                        String aux = cadenaParticionada[3];
                        for (int i = 4; i < cadenaParticionada.length; i++) {
                            aux += " " + cadenaParticionada[i];
                        }
                        Vertice vertice = new Vertice(cadenaParticionada[0], cadenaParticionada[1], cadenaParticionada[2], aux);
                        LinkedList<Arco> list = new LinkedList();
                        Pair<Vertice, LinkedList<Arco>> pareja = new Pair(vertice, list);
                        vertices.put(cadenaParticionada[0], pareja);
                    } else {
                        Vertice vertice = new Vertice(cadenaParticionada[0], cadenaParticionada[1], cadenaParticionada[2]);
                        LinkedList<Arco> list = new LinkedList();
                        Pair<Vertice, LinkedList<Arco>> pareja = new Pair(vertice, list);
                        vertices.put(cadenaParticionada[0], pareja);
                    }
                } else {
                    String[] cadenaParticionada = lineaActual.split(" ");
                    if (cadenaParticionada.length > 3) {
                        String aux = cadenaParticionada[3];
                        for (int i = 4; i < cadenaParticionada.length; i++) {
                            aux += " " + cadenaParticionada[i];
                        }
                        Arco arco = new Arco(cadenaParticionada[0], cadenaParticionada[1], cadenaParticionada[2], aux);
                        if (vertices.get(cadenaParticionada[0]) != null) {
                            vertices.get(cadenaParticionada[0]).getValue().add(arco);
                        }
                    } else {
                        Arco arco = new Arco(cadenaParticionada[0], cadenaParticionada[1], cadenaParticionada[2], "desconocido");
                        if (vertices.get(cadenaParticionada[0]) != null) {
                            vertices.get(cadenaParticionada[0]).getValue().add(arco);
                        }
                    }
                }

                lineaActual = br.readLine();

            }
        } catch (IOException ioe) {
            System.out.println("Error leyendo el archivo de entrada");
        }
      
        
    }

    /**
     * Metodo principal del programa
     *
     * @param args un array de argumentos
     */
    public static void main(String[] args) throws IOException {
        makeMap();

    }
}
