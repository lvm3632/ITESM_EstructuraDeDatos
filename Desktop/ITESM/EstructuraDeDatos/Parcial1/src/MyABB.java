import java.util.NoSuchElementException;

public class MyABB <E extends Comparable<E>> {
	
	private NodoABB<E> root;
	private int size;
	
	public MyABB() {
		super();
	}
	
	public E search(E value) {
	
		//Considerar si el arbol esta vacio
		NodoABB<E> current=this.root;
		
		
		while(current!=null) {
			if(current.value.equals(value)){				
				return current.value;
			}/*else if(value.compareTo(current.value)<0) {
				current=current.left;
			}else {
				current=current.right;
			}*/
			else {
				current=value.compareTo(current.value)<0?current.left:current.right;
			}
		
		}
		
		throw new NoSuchElementException("No se encuentra el valor" + value + "en el arbol");	
	}
	
	public void preorden() {
		
		preorden(this.root);
		
	}
	
	private void preorden(NodoABB<E> current) {
		
		if(current!=null) {
			System.out.println(current.value+",");
			preorden(current.left);
			preorden(current.right);
		}
		
	}
	
	public void inorden() {
		inorden(this.root);
	}
	
	private void inorden(NodoABB<E> current) {
		
		if(current!=null) {
			inorden(current.left);
			System.out.println(current.value+",");
			inorden(current.right);
		}
	
	}
	
	
	public void postorden() {
		postorden(this.root);
		
	}
	
	private void postorden(NodoABB<E> current) {
		if(current!=null) {
			postorden(current.left);
			postorden(current.right);
			System.out.println(current.value+",");
		}
	}
	
	public void nivel() {
		//imprime los nodos separados
	}
	
	public E remove(E value) {
		
		//Considerar si el arbol esta vacio
				NodoABB<E> current=this.root,
						parent=null;
				
			try {
				while(!current.value.equals(value)) {	
					parent = current;
					current=value.compareTo(current.value)<0?current.left:current.right;
			}
				
				// Si aquí llego es porque o encontré el valor a borrar o no estuvo
				// Current esta en valor a borrar y parent en el padre del nodo a borrar
				
				if(current.left == null && current.right == null) {
					if(parent.left == current) {
						parent.left = null;
					}else {
						parent.right = null;
					}
					return current.value;
				}
				
			}catch(NullPointerException ex) {
				throw new NoSuchElementException("No se encuentra el valor" + value + "en el arbol");
			}
				
				
				
			return current.value;
				
	}

	
	public void insert(E value) {
		
	}
	
	
	public static void main(String[] args) {
		
		MyABB<Integer> arbol = new MyABB<>();
		arbol.root = new NodoABB<>(50);
		arbol.root.left=new NodoABB<>(25);
		arbol.root.right=new NodoABB<>(75);
		arbol.root.right.left=new NodoABB<>(60);
		
		System.out.println(arbol.search(85));
		
	}

}




class NodoABB<E extends Comparable<E>>{
	
	
	 //La clase my ABB puede accesar de manera directa o podemos usar setters y getters
	final E value;
	NodoABB<E> left,
			  right;
	public NodoABB(E value, NodoABB<E> left, NodoABB<E> right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public NodoABB(E value) {
		super();
		this.value = value;
	}
	public E getValue() {
		return value;
	}

	public NodoABB<E> getLeft() {
		return left;
	}
	public void setLeft(NodoABB<E> left) {
		this.left = left;
	}
	public NodoABB<E> getRight() {
		return right;
	}
	public void setRight(NodoABB<E> right) {
		this.right = right;
	}
	
	
}