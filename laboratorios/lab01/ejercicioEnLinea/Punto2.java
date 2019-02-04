public class Punto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
       while(true){
        Scanner vertex = new Scanner(System.in);
        Scanner linea = new Scanner(System.in);
        int nroV= vertex.nextInt();
        if(nroV==0) break;
        int nroArc = vertex.nextInt();
        int[][] grafo = new int[nroV][nroV];
        for (int i = 0; i < nroArc; i++) {
            
            String cadenaVertex = linea.nextLine();
            String[] partes= cadenaVertex.split(" ");
            int vertice1 = Integer.parseInt(partes[0]);
            int vertice2 = Integer.parseInt(partes[1]);
            grafo[vertice1][vertice2]=1;
        }
        if(verificador(grafo,nroV,0)){
            System.out.println("Bicolorable");
        }
        else{
            System.out.println("Not Colorable");
        }
       }
    }
    
    

    public static boolean verificador (int grafo[][],int nroV,int firstV){
    
        int [] colores = new int[nroV];
        
        
        for (int i = 0; i < nroV; i++) {
            colores[i]=-1;
        }
        
        colores[firstV]=1;
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(firstV);
        
        while(lista.size()!=0){
        int origen=lista.poll();
        
            for (int i = 0; i < nroV; i++) {
                
                if(grafo[origen][i]==1 && colores[i]==-1){
                   colores[i]= 1-colores[origen];
                   lista.add(i);
                }
                else if(grafo[origen][i]==1 && colores[i]==colores[origen]){
                return false;
                }
            }
        
        }
        
        return true;
    }
    
}
