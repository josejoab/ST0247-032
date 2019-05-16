package ProyectoFinalFinalv4Remasterizada;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que se encarga de escribir la respuesta en un archivo.txt
 * @author Joab and Kevin
 */
public class Escritor {

    public void escribir(String str, String dataset) throws IOException {
        FileWriter fw;
        fw = new FileWriter("C:\\Users\\ASUS\\Documents\\UNIVERSIDAD\\semestre III\\estructura de datos y algoritmos II"
                    + "\\proyecto\\ProyectoFinalFinalv4Remasterizado\\src\\test\\"+dataset.substring(7, dataset.length())
        );
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(str);
        bw.close();
    }

}
