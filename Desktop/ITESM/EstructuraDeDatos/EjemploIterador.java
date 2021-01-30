import java.util.Iterator;
import java.util.NoSuchElementException;

public class EjemploIterador implements Iterable<Integer> {
	
	private Integer[] valores;
	private int size;
	
	public EjemploIterador(Integer[] valores) {
		this.valores=valores;
		this.size=this.valores.length;
		//arreglo supoenr lleno
	}
	
	
	

	@Override
	public Iterator<Integer> iterator() {
		
		
		
		return new Iterator<Integer>() {
			//apuntador a current si lista enlazada
			int pos=0;
			
			public boolean hasNext() {
				//si la pos es menor a mii size eso regresa
				return pos<size;
			}
			
			public Integer next() {
				
				if(hasNext()) {
					return valores[pos++];
				}else {
					throw new NoSuchElementException("No hay elementos por regresar");
				}
				
			}
			
			public void remove() {
				
			}
			
		};
		
	}
	
	public static void main(String[] args) {
		
		Integer[] valores  = {10,9,8,7,6,5,4,3,2,1};
		
		EjemploIterador ei = new EjemploIterador(valores);
		
		for (Integer x:valores) {
			System.out.println(x);
			System.out.println(ei.iterator().hasNext());
		}
		
		Iterator<Integer> iterator = ei.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		//System.out.println(iterator.next()); regresa excepcion
		
		
		
		
	}

}
