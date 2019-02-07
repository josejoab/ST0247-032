	public static int nReinas(int n){
            return nReinas(0, n, new int[n]);
	}

	/**
	* Metodo devuelve el numero de soluciones que tiene el problema
	* 
	* @param  r fila
	* @param  n numero de reinas
	* @return numero de soluciones
	*/	
	private static int nReinas(int r, int n, int[] tablero) {
            for(int i = 0; i < n; i++){
                for (int j = 0; j < n; j++) {
                    tablero[i]=j;
                    if(!puedoPonerReina(i,tablero)) {
                        continue;
                    }
                    else break;
                }
                     
            }
	}
        
        
