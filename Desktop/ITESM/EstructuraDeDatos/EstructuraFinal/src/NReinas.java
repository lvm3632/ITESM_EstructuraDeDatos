
public class NReinas {
	private int[] tablero;
	
	public NReinas(int n) {
		this.tablero = new int[n];
	}
	
	
	public static void main(String[] args) {
		NReinas reinas = new NReinas(4);
		reinas.busca();
	}
	
	private boolean valida(int fila, int columna) {
		
		//Revisar que no haya otra reina en esa misma fila
		for(int i=0;i<columna;i++) {
			if(tablero[i]==fila) {
				return false;
			}
			//que no haya otra reina en la misma diagonal
			if(Math.abs(columna-i)==Math.abs(fila-tablero[i])) {
				return false;
		}
	}
		
		return true;
	}
	
	public void busca() {
		busca(0);
	}
	
	private void busca(int columna) {
		for (int i = 0; i < tablero.length; i++) {
			if(valida(i,columna)) {
				this.tablero[columna]=i;
				if(columna==this.tablero.length-1) {
					imprimeTablero();
				}else {
					busca(columna+1);
				}
			}
		}
	}
	
	
	public void imprimeTablero() {
		
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(this.tablero[i]+",");
		}
		System.out.println();
	}
	
}
