package laboratorio3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Punto1 {
    
    public static void main(String[] args) {
        lector();
    }
     public static void lector() {
        try {
            ArrayList<Integer> vertices = new ArrayList();
            ArrayList<Integer> arcos = new ArrayList();
            boolean a = false;
            Scanner input = new Scanner(new File("../laboratorio3/puentesColgantes.txt"));   
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if(line.contains("V")){
                    continue;
                }
                if(line.contains("A")){
                    a=true;
                    continue;
                }
                if(a==false){
                    String[] datos= line.split(" ");
                    if(datos.length!=1){
                        vertices.add(Integer.parseInt(datos[0]));
                    }
                }
                else{
                    String[] datos= line.split(" ");
                    if(datos.length!=1){
                        arcos.add(Integer.parseInt(datos[0]));
                        arcos.add(Integer.parseInt(datos[1]));
                        String aux="";
                        for (int i = 0; i < datos[2].length(); i++) {
                            if(datos[2].charAt(i)=='.') break;
                            aux+=datos[2].charAt(i);
                        }
                        arcos.add(Integer.parseInt(aux));
                    }
                }
                  
                 // System.out.println(line);
            }
             ArrayList<Integer> respuesta =iniciar(vertices,arcos);
            for (int i = 0; i < respuesta.size(); i++) {
                System.out.print(respuesta.get(i)+" ");
            }

            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    }
     
     public static ArrayList iniciar(ArrayList<Integer> vertex,ArrayList<Integer> arcs){
         DigraphAL grafito = new DigraphAL(5); //Creamos el grafo
         for (int i = 0; i < arcs.size(); i++) {
             grafito.addArc(arcs.get(i),arcs.get(i+1),arcs.get(i+2));
             i+=2;
         }
         Scanner datos = new Scanner(System.in);
         System.out.println("ingrese origen ");
         int origen = datos.nextInt();
         System.out.println("ingrese destino ");
         int destino = datos.nextInt();
        return  irHaciaNAux(grafito,origen,destino);
     }
     
     public static ArrayList irHaciaNAux(Digraph unGrafo,int origen,int destino){
  int[] vertex = new int[unGrafo.size()];
  int[] suma = new int[1];
  int[] vertexF = new int[unGrafo.size()];
  boolean[] visitados= new boolean[unGrafo.size()];
  suma[0]=99999999;
  vertex[0]=origen;
  visitados[0]=true;
  int[] respuesta = irHaciaN(origen,destino,unGrafo,vertex,1,suma,0,visitados,vertexF);
  ArrayList<Integer> respuesta2 = new ArrayList();
      for (int i = 0; i < respuesta.length; i++) {
          respuesta2.add(respuesta[i]);
          if(respuesta[i]==destino) break;
      }
      return respuesta2;
}

private static int[] irHaciaN(int origen,int n,Digraph unGrafo,int[] vertex,int indice,int[] suma,int sumaP,boolean[] visitados,int[] vf){
  if(origen==n){
    suma[0]=sumaP;
    vf=vertex.clone();
    visitados[origen]=false;
    return vf;
  }
  else{
    for(int i: unGrafo.getSuccessors(origen)){
        if(sumaP+unGrafo.getWeight(origen,i)<suma[0]&& !visitados[i]){ 
           vertex[indice]=i;
           visitados[i]=true;
           vf=irHaciaN(i,n,unGrafo,vertex,indice+1,suma,sumaP+unGrafo.getWeight(origen,i),visitados,vf);
        }
    }
      visitados[origen]=false;
    return vf;
  }
}

     
}
