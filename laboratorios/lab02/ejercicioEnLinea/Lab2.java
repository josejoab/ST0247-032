import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Lab2 {

    public static void main(String[] args) {
        leer_Tablero();
    }
//------- ejercicio 2
public static void leer_Tablero(){

  Scanner sc  = new Scanner(System.in);
  LinkedList<Integer> resultados = new LinkedList<>();
  int num = sc.nextInt();
  String[] fila = new  String[num];
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

public static int nReinas(int reinas, int[][] tablero){
  int[] posicion = new int[reinas];
  int[] suma = new int[1];
   return nReinas_Aux(reinas, tablero, 0, posicion, suma);
}

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
       //System.out.println("suma :"+suma[0]);
      // imprimirTablero(posicion);
       return suma[0];
 }


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
