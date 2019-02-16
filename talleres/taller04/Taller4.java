import java.util.ArrayList;

public class Taller4
{
   //punto1
public static  boolean hayCamino(Digraph g, int o, int d){
   boolean visitados = new boolean[g.size()];    
   return hayCaminoAux(g, o, d, visitados);
}

private static boolean hayCaminoAux(Digraph g, int o, int d, boolean[] visitados) { 
    visitado[o] = true;
    if (o == d)
       return true;
    else {
       ArrayList<Integer> hijos = g.getSuccessors(o);          
          for (Integer hijo: hijos){
            if (!visitado[hijo] && hayCaminoAux(g, hijo, d, visitados))
               return true;
          return false;
         }      
    }

}

    //punto 2
       public static boolean hayCamino(Digraph g, int o, int d){
       boolean [] visitados = new boolean[g.size()];    
       return hayCaminoAux(g, o, d, visitados);
    }
     public static int costoMinimo(Digraph g, int o, int d){
       boolean [] visitados = new boolean[g.size()];    
       return costoMinimoAux(g, o, d, visitados);
    }

    public static boolean hayCaminoAux(Digraph g, int o, int d, boolean[] visitados) { 
        visitados[o] = true;
        if (o == d){
           return true;
        }
        else {
           ArrayList<Integer> hijos = g.getSuccessors(o);          
              for (Integer hijo: hijos)
                if (!visitados[hijo] && hayCaminoAux(g, hijo, d, visitados)) return true;
                    return false;

             }      

        }

    public static int costoMinimoAux(Digraph g, int o, int d, boolean[] visitados) { 
        visitados[o] = true;
        int costoCamino = 0;
        int costoCaminoAux = Integer.MAX_VALUE;
        if (o == d){

           return costoCamino;
        }
        else {
           ArrayList<Integer> hijos = g.getSuccessors(o);          
                for (Integer hijo: hijos){
                    if (!visitados[hijo]){
                        boolean [] arregloAux =  new boolean[g.size()]; 
                       costoCamino = costoMinimoAux(g, hijo, d,arregloAux)+ g.getWeight(o, hijo);
                       if(costoCamino<=costoCaminoAux){
                           costoCaminoAux = costoCamino;
                           System.out.println(costoCamino);
                       }
                    }
             } 
            return costoCaminoAux;
        }
    }


    
    
    //punto 3
    public static int hamiltonWay(Digraph g, int o){
        boolean[] visit = new boolean[g.size()];
        int vertices = 0;
        int[] costo = new int[1];
        costo[0] = Integer.MAX_VALUE;
        int tamaño = 0;
        hamiltonWayAux(g, o, o, visit, costo, tamaño, vertices);
        return costo[0] == Integer.MAX_VALUE ? 0 : costo[o];
    }
    
    public static boolean hamiltonWayAux(Digraph g, int o, int d, boolean[] visit,
                                  int[] costo, int tamaño, int vertices){
        
        System.out.println("tamaño: "+ tamaño);
        System.out.println("costo: " + costo[0]);
        System.out.println("vertices: " + vertices);
        System.out.println("g: " + g.size());
        
        if(o == d && g.size() == vertices){
            System.out.println("llegue");
            if(tamaño < costo[0]){
                costo[0] = tamaño;
                System.out.println("llegue222");
            }
            visit[o] = false;
            return true;
        }
                
        visit[o] = true;
        vertices++;
        
        ArrayList<Integer> hijos=g.getSuccessors(o);
        for (Integer hijo:hijos) {
            if((!visit[hijo] && tamaño+g.getWeight(o,hijo)<costo[0])|| (hijo == d && vertices == g.size())){
                tamaño += g.getWeight(o, hijo);
                System.out.println("hijo:" + hijo);
                System.out.println("padre: " + d);
                hamiltonWayAux(g, hijo, d, visit, costo, tamaño, vertices);
            }
        }
        visit[o] = false;
        System.out.println("salí");
        return false;
    }
}
