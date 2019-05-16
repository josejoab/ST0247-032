package ProyectoFinalFinalv4Remasterizada;
import java.io.*;

/**
 * Clase que se encarga de leer los datasets
 * @author Joab and Kevin
 */
public class Lector {

    double p; // Variable que indica el porcentaje de tiempo extra

    public int[][] leerArchivo(String filename) throws IOException{

        int[][] matricia= new int[0][0]; //Matriz de adyacencia

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String linea = br.readLine();
            String lineap = linea;
            String[] splitLineap = lineap.split(" ");
            p = Double.parseDouble(splitLineap[splitLineap.length-1]);

            linea = br.readLine();
            linea = br.readLine();
            linea = br.readLine();
            linea = br.readLine();

            int contador = 0;

            while(linea != null && !(linea.contains("Costo")) && !linea.isEmpty()) { //Se identifican los arcos
                contador++; //Se cuenta el numero de vertices
                linea = br.readLine();
            }


            linea = br.readLine();
            linea = br.readLine();
            linea = br.readLine();

            matricia= new int[contador+1][contador+1]; // Se crea la matriz de adyacencia con el numero de vertices que se identificaron


            while(linea != null){
                if(!linea.isEmpty()){
                    String[] coord = linea.split(" ");
                    matricia[Integer.parseInt(coord[0])][Integer.parseInt(coord[1])] = Integer.parseInt(coord[2]);
                    linea = br.readLine(); // Se llena la matriz con el tiempo de cada arco, donde la fila es el vertice inicio y la columna el vertice de llegada llegada
                }
            }

        }catch(FileNotFoundException ex) {
            System.out.println("Error: probablemente no se encontrÃ³ el archivo de lectura");
            System.out.println(ex);
        }
        return matricia;
    }
}