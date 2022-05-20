/**
 * 
 */
package uvg.edu.common;

/**
 * @author Carlos Lopez
 *
 */
public class Graph {
	private int n;
    private int[][] matriz;

    /**
     * Constructor
     * @param n
     */
    public Graph(int n) {
        this.n = n;
        matriz = new int[this.n][this.n];
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                matriz[i][j] = 0;
            }
        }
    }

    /**
     * add
     * @param i
     * @param j
     * @param data 
     */
    public void add(int i, int j, String data){
        matriz[i][j] = Integer.parseInt(data);;
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
            System.out.print("||\t");
            for(int j=0; j< n; j++){
                System.out.print( matriz[i][j] + "\t" );
            }
            System.out.print("||");
            System.out.println();
        }
    }

    /**
     * printInf
     */
    public void printInf(){
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                if (matriz[i][j]==0){
                    matriz[i][j]=999999;
                }
            }

        }
        for(int i=0; i< n; i++){
            System.out.print("||\t");
            for(int j=0; j< n; j++){
                System.out.print( matriz[i][j] + "\t" );
            }
            System.out.print("||");
            System.out.println();
        }
    }

    /**
     * retorno
     * @return retorna matriz
     */
    public int[][] retorno(){
        return matriz;
    }

    /**
     * devuelve km
     * @param a
     * @param b
     * @return km
     */
    public int devolver(int ciudad1Index, int ciudad2Index){
        return matriz[ciudad1Index][ciudad2Index];
    }


}
