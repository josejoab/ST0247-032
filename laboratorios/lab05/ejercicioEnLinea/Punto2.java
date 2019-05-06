public class Punto2 {
    
    public static void main(String[] args) {
        Pair<String[][], Pair<Integer, Integer>> coordenadas = entrada();
        System.out.println("The shortest path has length " + buscar(coordenadas.getKey(), coordenadas.getValue()));

    }
    
         public static int buscar(String[][] matriz, Pair<Integer, Integer> coordenadas) {
        int contador = 0;
        for (int i = 0; i < matriz.length; ++i) {
            for (int j = 0; j < matriz[0].length; ++j) {
                if (!matriz[i][j].equals("K") && !matriz[i][j].equals("R")) {
                    int value = Math.abs(i - coordenadas.getKey()) + Math.abs(j - coordenadas.getValue());
                    matriz[i][j] = Integer.toString(value);
                } else {
                    //if (!matriz[i][j].equals("K")) {
                        matriz[i][j] = "V";
                        int value = 0;
                        Pair<Integer, Integer> coorRad = new Pair(i, j);
                        if(matriz[i][j + 1].equals("R")==false){
                        if ((!matriz[i + 1][j].equals("0") || !matriz[i - 1][j].equals("0") || !matriz[i][j + 1].equals("0") || !matriz[i][j - 1].equals("0"))
                                && (i > 0 && i < matriz.length - 1 && i > 0 && i < matriz.length - 1)) {
                            System.out.println("1 "+Integer.parseInt(matriz[i - 1][j]));
                            System.out.println("2 "+matriz[i][j + 1]);
                            value = Math.min(Integer.parseInt(matriz[i][j - 1]), Math.min(Integer.parseInt(matriz[i + 1][j]),
                                    Math.min(Integer.parseInt(matriz[i - 1][j]), Integer.parseInt(matriz[i][j + 1])))) + 1;
                        }
                     //   }
                        return buscar(matriz, coorRad) + value;
                    } else {
                        if (contador > 0) {
                            return 0;
                        }
                        contador++;
                    }
                }
            }
            System.out.println();
        }
        return 0;
    }

    public static Pair<String[][], Pair<Integer, Integer>> entrada() {
        
        Scanner entrada = new Scanner(System.in);

        Pair<String[][], Pair<Integer, Integer>> respuesta = null;
        String[][] matriz = null;
            int escenarios = entrada.nextInt();
            while (escenarios > 0) {
                int tamX = entrada.nextInt(), tamY = entrada.nextInt();
                matriz = new String[tamY][tamX];
                int iniX = entrada.nextInt(), iniY = entrada.nextInt();
                matriz[iniY - 1][iniX - 1] = "K";
                int numDesechos = entrada.nextInt();
                while (numDesechos > 0) {
                    int radX = entrada.nextInt(), radY = entrada.nextInt();
                    matriz[radY - 1][radX - 1] = "R";
                    --numDesechos;
                }
                Pair<Integer, Integer> coordenadas = new Pair(iniY - 1, iniX - 1);
                respuesta = new Pair(matriz, coordenadas);
                --escenarios;
            }
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (matriz[i][j] == null) {
                        matriz[i][j] = "0";
                    }
                }
            }
        return respuesta;
    }

}
