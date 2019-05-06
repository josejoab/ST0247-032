public class Punto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DigraphAL grafito = new DigraphAL(4); //Creamos el grafo
        grafito.addArc(0, 1,7);
        grafito.addArc(0, 2,15);
        grafito.addArc(0, 3,6);
        grafito.addArc(1, 0,2);
        grafito.addArc(1,2,7);
        grafito.addArc(1,3,3);
        grafito.addArc(2, 0,9);
        grafito.addArc(2,1,6);
        grafito.addArc(2,3,12);
        grafito.addArc(3,0,10);
        grafito.addArc(3,1,4);
        grafito.addArc(3,2,8);
        System.out.println(heldKarp(grafito));
    }
    
    

  public static int heldKarpAux(Digraph grafo ,int[][] DistanciaAcum, int antecesores[][], int vertice, int binarySet) {
        int maskCond=0;
        int set=0;
        if (DistanciaAcum[vertice][binarySet] == -1) {
            int Aux = -1;
            for (int i = 0; i < grafo.size(); i++) {
                maskCond = (int)Math.pow(2, grafo.size()) - (int) Math.pow(2, i)  - 1;
                set = binarySet & maskCond;
                if (set != binarySet) {
                    int temp = grafo.getWeight(vertice,i) + heldKarpAux(grafo,DistanciaAcum,antecesores,i, set);
                    if (Aux == -1 || Aux > temp) {
                        Aux = temp;
                        antecesores[vertice][binarySet] = i;
                    }
                }
            }
            DistanciaAcum[vertice][binarySet] = Aux;
            return Aux;
        } else {
            final int i = DistanciaAcum[vertice][binarySet];
            return i;
        }
    }

    public static int heldKarp(Digraph grafo) {
        
        int[][] distanciaAcum;
        distanciaAcum = new int[grafo.size][(int) Math.pow(2, grafo.size)];
        
        int[][] antecesores;
        antecesores = new int[grafo.size][(int) Math.pow(2, grafo.size)];


        for (int i = 0; i < grafo.size;i++) {
            
            for (int j = 0;j < (int) Math.pow(2, grafo.size);j++) {
                antecesores[i][j] = -1;
                if (j ==0) {
                    distanciaAcum[i][0] = grafo.getWeight(i,0);
                } else distanciaAcum[i][j] = -1;
            }
        }

        return heldKarpAux(grafo,distanciaAcum,antecesores, 0, (int) Math.pow(2, grafo.size) - 2);
    }
}
