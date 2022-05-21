/**
 * 
 */
package uvg.edu.common;

public class Graph {
	
	private int n;
    private long[][] matriz;

    /**
	 * Este metodo evalua una expresion en notacion infija y retorna la notacion posfija
	 * Precondicion:
	 * @param expresion: es la expresion simple "1 + 2" (String)
	 * Postcondicion:
	 * @return String: " 1 2 + "
	 * 
	 */
    public Graph(int n) {
        this.n = n;
        matriz = new long[this.n][this.n];
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                if(i!=j) {
                	matriz[i][j] = 999999999;
                }else {
                	matriz[i][j] = 0;
                }
            }
        }
    }

    /**
	 * Este método se utiliza para data a la matriz
	 * Precondicion:
	 * @param i: fila de la matriz
	 * @param j: columna de la matriz
	 * @param data: data a insertar
	 * 
	 * @see Integer#parseInt(String)
	 * 
	 */
    public void add(int i, int j, String data){
        matriz[i][j] = Integer.parseInt(data);
    }

    /**
	 * Este método se utiliza remover una posicion
	 * Precondicion:
	 * @param i: fila de la matriz
	 * @param j: columna de la matriz
	 * 
	 */
    public void remove(int i, int j){
        if(matriz[i][j]>0)
            matriz[i][j] -= 1;
    }

    /**
	 * Este método se utiliza para imprimir la data de la matriz
	 * 
	 * @see System.out#println()
	 * 
	 */
    public void print(){

        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                System.out.print( matriz[i][j] + ", " );
            }
            System.out.println();
        }
    }

    /**
	 * Este método se utiliza para retornar la matriz
	 * Postcondicion:
	 * @return matriz: matriz con la data que se esta manipulando
	 * 
	 */
    public long[][] retorno(){
        return matriz;
    }

    /**
	 * Este método se utiliza para devolver los kilometros entre ciudades
	 * Precondicion:
	 * @param ciudad1Index: fila de la matriz
	 * @param ciudad2Index: columna de la matriz
	 * Postcondicion:
	 * @return km: kilometros entre ciudades
	 * 
	 */
    public long devolver(int ciudad1Index, int ciudad2Index){
        return matriz[ciudad1Index][ciudad2Index];
    }
    
    /**
	 * Este método se utiliza para devolver el tamaño de la matriz
	 * Postcondicion:
	 * @return matriz.length: largo de la matriz
	 * 
	 */
    public int tamaño(){
        return matriz.length;
    }
    
    /**
	 * Este método se utiliza para modificar el valor de una posicion de la matriz
	 * Precondicion:
	 * @param i: fila de la matriz
	 * @param j: columna de la matriz
	 * @param value: nuevo valor
	 * 
	 */
    public void modify(int i, int j, long value){
        matriz[i][j] = value;
    }
}