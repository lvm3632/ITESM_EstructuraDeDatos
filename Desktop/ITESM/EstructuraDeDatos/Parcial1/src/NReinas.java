
public class NReinas {

	private int[] reinas;
	
	public NReinas(int n) {
		this.reinas = new int[n];
		for(int i=0;i<this.reinas.length;i++) {
			this.reinas[i]=-1;
		}
	}
	
	public boolean valida(int fila, int columna) { //columna donde quiero poner la reina y fila
		
		for(int i=0;i<fila;i++) {
			if(this.reinas[i] == columna) {
				return false;
			}
			if(Math.abs(columna-this.reinas[i]) == Math.abs(fila-i)) { //|j-l| = |i-k|
				return false;
			} 
			
		}
		
		return true; // Si los argumentos no se meten a los if's entonces se puede tener una reina
	}
	
	public void imprimeSolucion() {
		for(int i=0;i<this.reinas.length;i++) {
			System.out.print(this.reinas[i]+",");
		}
		System.out.println();
	}
	
	
	private void busca(int fila) {
		for(int i=0;i<this.reinas.length;i++) {
			if(valida(fila,i) == true) {
				this.reinas[fila] = i;
				busca(fila+1);
				if(fila<this.reinas.length-1) {
					busca(fila+1);
				}else {
					imprimeSolucion();
				}
				
			}
		}
	}
	
	public void busca() {
		busca(0);
	}
	
	
	public static void main(String[] args) {
	
		NReinas tablero = new NReinas(5);
		tablero.busca();
		
	}
	
	
}
