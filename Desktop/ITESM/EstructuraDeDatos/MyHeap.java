//Autor: Michel Lujano
//Fecha: 24/04/20
//Clase: MyHeap.java

import java.util.NoSuchElementException;

public class MyHeap<E extends Comparable<E>> {
	private E[] values;
	private int size; //Representa cuántos elementos hay guardados en el Heap
	
	public MyHeap(int length) {
		this.values=(E[])new Comparable[length];
		this.size=0;
	}
	
	public static void main(String[] args) {
		
		 Integer[] lista = {92,70,72,60,65,32,62,15,45,30,56};
		//Integer[] lista = {81,6,23,38,95,71,72,39,34,53};
		MyHeap test = new MyHeap(lista);
		System.out.println(test.toString());
		test.remove();
		System.out.println(test.toString());
		
	}
	
	
	
	public MyHeap(E[] data) {//Suponer que el arreglo se recibe lleno
		this.values=data;
		this.size=data.length;
		heapify();
		
	}
	
	public MyHeap() {
		this(10);
	}
	
	public void heapify() {
		heapify(this.values);
	}
	
	private void heapify(E[] datos) {
		
		
		//Tarea hacer que los datos del arreglo complan la condicion de heap.
		//O(nlog(n))

		if (this.size == 0) {
			throw new NoSuchElementException("Lista vacía");
		}

		if (this.size == 2) {
			if (this.values[0].compareTo(this.values[1]) < 0) {
				swap(values,0, 1);
			}
		}

		// poner el arreglo con las condiciones de heap
		// ultimo nodo padre con hijos

			int index = getParent(this.size);
			
			for (int i = index; i >= 0; i--) {
			
			if(getLeftChild(i) < this.size && getRightChild(i) < this.size) {
				if (this.values[i].compareTo(this.values[getLeftChild(i)]) < 0 || this.values[i].compareTo(this.values[getRightChild(i) ]) < 0) {
					if (this.values[getLeftChild(i)].compareTo(this.values[getRightChild(i) ]) > 0) {
						swap(values,i, getLeftChild(i));
						heapify(this.values);

					} else {
						swap(this.values,i, getRightChild(i));
						heapify(this.values);
					}
				}
			}else if(getLeftChild(i) < this.size ) {
				if(this.values[i].compareTo(this.values[getLeftChild(i)]) < 0) {
					swap(values,i, getLeftChild(i));
					heapify(this.values);
				}
			}
			}

	}
	
	public int getSize() {
		return this.size;
	}
	

	public void insert(E data) {
		//O(log(n))
		if(this.size==values.length) {
			E[] tmp=(E[])new Comparable[this.size*2];
			//Pasar todos los elementos de values a tmp
			for(int i=0;i<this.values.length;i++) {
				tmp[i]=this.values[i];
			}
			this.values=tmp;
		}
		this.values[this.size]=data;
		//Reacomodo
		int parent = getParent(this.size);
		int lastElement = this.size;
		
		while(parent > 0 && values[parent].compareTo(values[lastElement])<0) {
			//swap
			swap(values, lastElement, parent);
			lastElement=parent;
			parent=getParent(parent);
		}
		 
		this.size++;
	}
	

	public int getLeftChild(int index) {
		return 2*index+1;
	}
	
	public int getRightChild(int index) {
		return 2*index+2;
	}
	
	public int getParent(int index) {
		return (index-1)/2;
	}
	
	public void swap(E[] values, int i, int j) {
		E aux = values[i];
		values[i]=values[j];
		values[j]=aux;
	}
	
	
	public E remove() {
		//O(log(n))
		if(this.size>0) {
			//Completar
			E maxValor = values[0];
 			values[0] = values[--this.size];
 			values[this.size] = null;
 			
 		int i=getParent(0);
 	
 			while(getLeftChild(i)<this.size && getRightChild(i)<this.size) {
 				if(values[i].compareTo(values[getRightChild(i)])<0) {
 	 				swap(values, i, getRightChild(i)); 			
 	 			}else {
 	 				break;
 	 			}	
 				i = getRightChild(i);
 			}
	 
			return maxValor;
	
		}
		else {
			throw new NoSuchElementException("No se puede borrar de un Heap vacio");
		}
	}
	
	public String toString() {
		String res="";
		for(int i=0;i<this.size;i++) {
			res+=this.values[i]+",";
		}
		return res;
	}
	
	
}
