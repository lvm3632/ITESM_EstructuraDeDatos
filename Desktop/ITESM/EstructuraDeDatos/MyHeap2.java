
//Autor: A01636172, Michel Lujano
//Nombre de la clase: MyHeap.java
//Fecha:28/01/2020
//Comentarios: Un heap. 

import java.util.NoSuchElementException;

public class MyHeap<E extends Comparable<E>> {

	private E[] heap;
	private int size;
	
	public static void main(String[] args) {
		Integer[] arr = {15,60,72,70,56,32,62,92,45,30,65};

		MyHeap<Integer> test = new MyHeap<>(arr);
		System.out.println(test);
	}

	public MyHeap() {
		this.heap = (E[]) new Comparable[20];
		this.size = 0;
	}

	public MyHeap(E[] datos) {
		// Instanciando objeto
		this();
		// Inicializando arreglo
		for (int i = 0; i < datos.length; i++) {
			this.heap[i] = datos[i];
		}
		//// Suponer que siempre esta lleno
		this.size = datos.length;

		// Hacer heapify
		heapify(datos);

	}

	private void heapify(E[] datos) {

		if (this.size == 0) {
			throw new NoSuchElementException("Lista vacía");
		}

		if (this.size == 2) {
			if (this.heap[0].compareTo(this.heap[1]) < 0) {
				swap(0, 1);
			}
		}

		// poner el arreglo con las condiciones de heap
		// ultimo nodo padre con hijos

			int index = this.size/2-1;
			for (int i = index; i >= 0; i--) {
				int izq = 2*(i)+1; // nodo izq
				int der = 2*(i)+2; // nodo der
			
			if(hijoIzq(i) && hijoDer(i)) {
				if (this.heap[i].compareTo(this.heap[izq]) < 0 || this.heap[i].compareTo(this.heap[der]) < 0) {
					if (this.heap[izq].compareTo(this.heap[der]) > 0) {
						swap(i, izq);
						heapify(this.heap);

					} else {
						swap(i, der);
						heapify(this.heap);
					}
				}
			}else if(hijoIzq(i)) {
				if(this.heap[i].compareTo(this.heap[izq]) < 0) {
					swap(i, izq);
					heapify(this.heap);
				}
			}
			}
				
		
	}
	
	private boolean hijoIzq(int i) {
		return this.heap[2*(i)+1]!=null;
	}
	private boolean hijoDer(int i) {
		return this.heap[2*(i)+2]!=null;
	}

	
	public void push(E dato) {
		
		this.heap[this.size] = dato;
		this.size++;
		if (this.size == this.heap.length) {
			E[] aux = (E[]) new Comparable[this.heap.length + 20];
			for (int i = 0; i < heap.length; i++) {
				aux[i] = this.heap[i];
			}
			this.heap = aux;
		}
		heapify(this.heap);
		
	}

	private void swap(int pos1, int pos2) {
		E aux = this.heap[pos1];
		this.heap[pos1] = this.heap[pos2];
		this.heap[pos2] = aux;
	}

	public String toString() {

		String res = "";

		for (int i = 0; i < this.size; i++) {
			res += this.heap[i] + ",";
		}
		return res;
	}

	public E pop() {

		E dato = this.heap[0];
		swap(0, this.size-1);
		this.heap[this.size-1] = null;
		this.size--;
		heapify(this.heap);

		
		return dato;
	}

}
