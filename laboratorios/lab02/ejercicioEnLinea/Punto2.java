import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Joab and Kevin
 */
public class Punto2 {

    public static void main(String[] args) {
        leer_Tablero();
    }

/**
 * este metodo controla la entrada de casos y recibe el numero de reinas con 
 * el que trabajara cada uno
 */
public static void leer_Tablero(){

  Scanner sc  = new Scanner(System.in);
  LinkedList<Integer> resultados = new LinkedList<>();
  int num = sc.nextInt();
  int cont=0;
  while(cont < 10 || num != 0){
     int[][] tablero = leer_Tablero_Aux(num);
     resultados.add(nReinas(num,tablero));     
      num = sc.nextInt();
     cont++;
  }
  int j=0;
  for(Integer i : resultados){
      System.out.println("caso " + j + ": " + i);
       ++j;
  }
}

/**
 * este metodo crea una matriz n*n, siendo n la cantidad de reinas, y 
 * lee las lineas ingresadas por cada caso, identificando las posiciones donde no se pueden
 * poner reinas y retorna la matriz
 * 
 * 
 * @param nReinas
 * @return 
 */
private static int[][] leer_Tablero_Aux(int nReinas){
  Scanner sc  = new Scanner(System.in);
  int[][] tablero = new int[nReinas][nReinas];
    for(int i = 0; i < nReinas; i++){
       String fila = sc.nextLine();
         for(int j = 0; j < fila.length(); j++){
           if(fila.charAt(j) == '*'){
             tablero[i][j] = -1 ;
            }	
          }
      }
  return tablero;
}

/**
 * este metodo recibe el numero de reinas y la matriz con la que se trabajara
 * y lo envia a un metodo auxiliar
 * @param reinas numero de reinas
 * @param tablero matriz que representa el tablero
 * @return 
 */
public static int nReinas(int reinas, int[][] tablero){
  int[] posicion = new int[reinas];
  int[] suma = new int[1];
   return nReinas_Aux(reinas, tablero, 0, posicion, suma);
}

/**
 * este metodo calcula el numero de soluciones que puede tener el problema de las n reinas 
 * con un n numero determinado y sin usar las posiciones malas
 * @param nReinas numero de reinas
 * @param tablero matriz que representa el tablero de ajedrez
 * @param col numero que controla el indice del arreglo "posicion" y representa las columnas de la matriz
 * @param posicion arreglo que contendra el numero de filas en el que se encuentran las reinas
 * @param suma arreglo que se utiliza como contador de cada solucion 
 * @return la cantidad de soluciones
 */
private static int nReinas_Aux(int nReinas, int[][] tablero, int col, int[] posicion,int[] suma){
  if(col>= nReinas && seAtacan(posicion,nReinas)){
    suma[0] += 1;
  }
  if(col<nReinas){
    for(int f = 0; f < nReinas; f++){
        if(tablero[f][col] != -1){
           posicion[col] = f;
           nReinas_Aux( nReinas, tablero,col+1,posicion,suma);
        }
    }
  }

       return suma[0];
 }

/**
 * metodo que verifica si en la matriz las reinas se atacan
 * @param tablero arreglo que representa el tablero (matriz)
 * @param elI numero de posiciones
 * @return true si no se atacan
 */
     private static boolean seAtacan(int [ ] tablero, int elI){
        for(int i = 0; i <= elI-1; i++){
            for(int j = i+1; j < elI; j++){
                if((Math.abs(tablero[i]-tablero[j])==Math.abs(i-j))||(tablero[i]==tablero[j])){
                    return false;
                }
            }
        }
        return true;
    }
     /**
      * metodo que imprime el tablero de juego
      * @param tablero 
      */
      public static void imprimirTablero(int[] tablero) {
    int n = tablero.length;
    System.out.print("    ");
    for (int i = 0; i < n; ++i)
       System.out.print(i + " ");
       System.out.println("\n");
    for (int i = 0; i < n; ++i) {
    System.out.print(i + "   ");
	for (int j = 0; j < n; ++j)
	    System.out.print((tablero[i] == j ? "Q" : "#") + " ");
	    System.out.println();
	}
    System.out.println();
  }
}
