public class Punto1{
 public static int CaminoVoraz(Digraph grafo){
    boolean[] visitados = new boolean[grafo.size()];
    int[] suma= new int[1]; 
    int[] sumaCamino= new int[1]; 
    suma[0] = 0;
    return caminoVorazAux(grafo, visitados, 0 , 0, suma,sumaCamino); 
  }

  public static int caminoVorazAux(Digraph grafo, boolean[] visitados, int inicio, int destino, int[] nVisitados,int[] sumaCamino){
    if(destino==inicio && nVisitados[0] == grafo.size()){
      return sumaCamino[0];
    }
    visitados[inicio] = true;
    nVisitados[0] += 1;
    int menor = Integer.MAX_VALUE;
    int vertex=-1;
    for(int i : grafo.getSuccessors(inicio)){
      if(!visitados[i] || (i == destino && nVisitados[0] == grafo.size())){
        if(grafo.getWeight(inicio, i) < menor){
          menor = grafo.getWeight(inicio, i);
          vertex = i;
        }
      }
    }
      System.out.println("vertex "+vertex);
    sumaCamino[0]+=grafo.getWeight(inicio, vertex);
     return caminoVorazAux(grafo,visitados,vertex,destino,nVisitados,sumaCamino); 
  }
}
