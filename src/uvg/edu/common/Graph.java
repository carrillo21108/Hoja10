/**
 * 
 */
package uvg.edu.common;

public class Graph {
	
	private int n;
    private long[][] matriz;

    /**
     * Constructor
     * @param n
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
     * add
     * @param i
     * @param j
     */
    public void add(int i, int j, String data){
        matriz[i][j] = Integer.parseInt(data);
    }

    /**
     * remove
     * @param i 
     * @param j
     */
    public void remove(int i, int j){
        if(matriz[i][j]>0)
            matriz[i][j] -= 1;
    }

    /**
     * print
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
     * retorno
     * @return retorna matriz
     */
    public long[][] retorno(){
        return matriz;
    }

    /**
     * devuelve km
     * @param a
     * @param b
     * @return km
     */
    public long devolver(int ciudad1Index, int ciudad2Index){
        return matriz[ciudad1Index][ciudad2Index];
    }
    
    /**
     * devuelve km
     * @param a
     * @param b
     * @return km
     */
    public int tamaño(){
        return matriz.length;
    }
    
    public void modify(int i, int j, long value){
        matriz[i][j] = value;
    }
}