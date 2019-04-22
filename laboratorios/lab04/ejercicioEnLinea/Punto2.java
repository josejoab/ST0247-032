public class Punto2{
public static void punto2(){
      ArrayList<Integer> horas = new ArrayList();
      while(true){
      int suma=0;
      Scanner teleo = new Scanner(System.in);
      String entrada= teleo.nextLine();
      if(entrada.equals("000")) break;
      String[] entrada2 = entrada.split(" ");
      int n = Integer.parseInt(entrada2[0]),d= Integer.parseInt(entrada2[1]),r= Integer.parseInt(entrada2[2]);
      Scanner teleo2 = new Scanner(System.in);
      int [] mañana = new int[n];
      int [] tarde = new int[n];
      for(int i =0 ; i<n ; i++){
        mañana[i]=teleo2.nextInt();
      }
      for(int i =0 ; i<n ; i++){
        tarde[i]=teleo2.nextInt();    
      }
      teleo2.reset();
      for(int i = 0; i<n ; i++){
      if(mañana[i]+tarde[i]>d){
        suma+=(mañana[i]+tarde[i]-d)*r;
      }
      }
      horas.add(suma);
      suma=0;
    }
          System.out.println(horas.toString());
  }
}
