import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Laboratorio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
   // Digraph grafito2= iniciador();
    DigraphAL grafito = new DigraphAL(5); //Creamos el grafo
    grafito.addArc(0, 1,2);
    grafito.addArc(0,3,1);
    grafito.addArc(1,0,2);
    grafito.addArc(1, 2,4);
    grafito.addArc(1, 4,5);
    grafito.addArc(2,1,4);
    grafito.addArc(2,4,1);
    grafito.addArc(2,3,3);
    grafito.addArc(3,0,1);
    grafito.addArc(3,2,3);
    grafito.addArc(4,1,5);
    grafito.addArc(4,2,1);
    DigraphAL grafito3 = new DigraphAL(7); //Creamos el grafo
    grafito3.addArc(0,1,1);
    grafito3.addArc(1,0,1);
    grafito3.addArc(0,2,2);
    grafito3.addArc(2,0,2);
    grafito3.addArc(1,4,3);
    grafito3.addArc(4,1,3);
    grafito3.addArc(1,3,2);
    grafito3.addArc(3,1,2);
    grafito3.addArc(2,3,1);
    grafito3.addArc(3,2,1);
    grafito3.addArc(2,5,3);
    grafito3.addArc(5,2,3);
    grafito3.addArc(5,6,4);
    grafito3.addArc(6,5,4);
    grafito3.addArc(4,6,4);
    grafito3.addArc(6,4,4);

    
    ArrayList<Integer> respuesta=irHaciaNAux(grafito);
        System.out.println("RESPUESTA ");
        boolean vacio=true;
        for (int i = 0; i < respuesta.size(); i++) {
            if(respuesta.get(i)!=0){
               vacio=false;
            }
        }
        if(vacio==false){
        for (int i = 0; i < respuesta.size(); i++) {
            System.out.print(respuesta.get(i)+" ");
        }
        }
        else System.out.println("-1");
    
    /**
        System.out.println("RESPUESTA");
    ArrayList<Integer> respuestaA=irHaciaNAux2(grafito3);
        for (int i = 0; i < respuestaA.size(); i++) {
            System.out.println(respuestaA.get(i));
        }
    **/
  } 
  public static ArrayList irHaciaNAux(Digraph unGrafo){
  int[] vertex = new int[unGrafo.size()];
  int[] suma = new int[1];
  int[] vertexF = new int[unGrafo.size()];
  boolean[] visitados= new boolean[unGrafo.size()];
  suma[0]=9999;
  vertex[0]=0;
  visitados[0]=true;
  int[] respuesta = irHaciaN(0,unGrafo.size()-1,unGrafo,vertex,1,suma,0,visitados,vertexF);
  ArrayList<Integer> respuesta2 = new ArrayList();
      for (int i = 0; i < respuesta.length; i++) {
          respuesta2.add(respuesta[i]);
          if(respuesta[i]==unGrafo.size()-1) break;
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


 
public static Digraph iniciador(){
     Scanner teclado = new Scanner(System.in);
    int vertices = teclado.nextInt();
    int arcos = teclado.nextInt();
    DigraphAL grafito = new DigraphAL(vertices); //Creamos el grafo
    for(int i = 0; i < arcos; i++){
      int origen = teclado.nextInt();
      int destino = teclado.nextInt();
      int peso = teclado.nextInt();
      grafito.addArc(origen,destino,peso);
      grafito.addArc(destino, origen, peso);
    }
    teclado.close();
    for(int i = 0; i < grafito.size; i++){
        System.out.println(grafito.getSuccessors(i).toString());

    }
    return grafito;
}

}
