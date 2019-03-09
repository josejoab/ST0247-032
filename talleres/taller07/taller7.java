import greedy.Digraph;
import java.util.Arrays;

public class taller7 {
    
  private int[] llenarUnArregloConInfinitos(int n, int v){
    int[] a = new int[n];
    Arrays.fill(a, Integer.MAX_VALUE);
    a[v] = 0;
    return a;
  }   
  
  private int elMasPequenoNoVisitado(Digraph g, boolean[] visitados, int[] tabla){
   // María Sofía
    int menorAux = Integer.MAX_VALUE;
    int aux = -1;
    for(int i = 0; i < tabla.length; i++){
      if(!visitados[i] && tabla[i] < menorAux){
        menorAux = tabla[i];
        aux = i;
      }
    }
    return aux;
  }

  private void actualizarLosPesosDeLaTablaConElValorActual(Digraph g, int actual, int[] tabla){
  // Alejandro peadzo de puto   
    for(int destino: g.getSuccessors(actual)){
      if(tabla[destino] != Integer.MAX_VALUE){
        tabla[destino] += g.getWeight(actual, destino);
      }
      else{
        tabla[destino] = g.getWeight(actual,destino);
      }
    }
  }
  
  // dale con moral
public int[] dijkstra(Digraph g, int v){
    int[] tabla = llenarUnArregloConInfinitos(g.size(),v);
    int actual = v;
    boolean[] visitados = new boolean[g.size()];
    for (int i = 0; i < g.size(); i++) {
      actual = elMasPequenoNoVisitado(g, visitados, tabla);
      visitados[actual] = true;
      actualizarLosPesosDeLaTablaConElValorActual(g, actual, tabla);
    }
    return tabla;      
  }  
  
  // encuentra el costo total del subconjunto de aristas de costo mínimo que conservan el grafo conectado
    private static void Aux(Grafo g) {
        boolean[] visitados = new boolean[g.size()];
        int[] respuesta = llenarInfinitos(g.size());
        prim(g, 0, visitados, respuesta, 0);
    }

    public static int[] prim(Grafo g, int v, boolean[] visitados, int[] respuesta, int contador) {
        if (contador == g.size() - 1) {
            return respuesta;
        }

        int menorAux = Integer.MAX_VALUE;
        visitados[v] = true;
        int vertice = -1;
        int verticeInicio = -1;
        for (int i = 0; i < g.size(); i++) {
            if (visitados[i]) {
                for (int j : g.getSuccessors(i)) {
                    int menor = g.getWeight(i, j);
                    if (menor < menorAux) {
                        menorAux = menor;
                        vertice = j;
                        verticeInicio = i;
                    }
                }
            }
        }
        if (respuesta[vertice] == Integer.MAX_VALUE) {
            respuesta[vertice] = g.getWeight(verticeInicio, vertice);
        } else {
            respuesta[vertice] += g.getWeight(verticeInicio, vertice);
        }
        return prim(g, vertice, visitados, respuesta, contador + 1);
    }
}
