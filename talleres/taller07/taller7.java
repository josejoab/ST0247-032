import java.util.Arrays;

/**
 * 
 * @author Kevin Herrera, Jose Joab
 */

public class Taller7 {

    public static void main(String[] args) {
        DigraphAL g1 = new DigraphAL(6);
		g1.addArc(0, 1, 5);
		g1.addArc(0, 2, 8);
		g1.addArc(0, 3, 4);
		g1.addArc(1, 0, 5);
		g1.addArc(1, 2, 2);
		g1.addArc(2, 3, 3);
		g1.addArc(2, 4, 3);
		g1.addArc(2, 5, 7);
		g1.addArc(3, 0, 4);
		g1.addArc(3, 2, 3);
		g1.addArc(4, 2, 3);
		g1.addArc(4, 5, 2);
		g1.addArc(5, 2, 7);
		g1.addArc(5, 4, 2);
		g1.addArc(2, 1, 2);
        Taller7 s = new Taller7();
        int[] a = s.prim(g1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + ": " + a[i]);
        }
    }
    
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
    public int[] prim(Digraph g) {
        boolean[] visitados = new boolean[g.size()];
        int[] respuesta = llenarUnArregloConInfinitos(g.size(),0);
        return primAux(g, 0, visitados, respuesta, 0);
    }

    private int[] primAux(Digraph g, int v, boolean[] visitados, int[] respuesta, int contador) {
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
                    if(!visitados[j] && menor < menorAux) {
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
        return primAux(g, vertice, visitados, respuesta, contador + 1);
    }
}
