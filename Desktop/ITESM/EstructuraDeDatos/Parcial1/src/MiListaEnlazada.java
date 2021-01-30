//Autor: A01636172 Michel Lujano
//Nombre de la clase: MiListaEnlazada.java
//Fecha: 05/09/19
//Comentarios: Es interesante, la forma de agregar datos en una lista dinámica, ya que es más flexible y puedes usar génericos, para cualquier tipo de dato. 

import java.util.NoSuchElementException;

public class MiListaEnlazada <E> {

 private NodoLE <E> first,
 last;

 private int size;
 E elemento;


 public MiListaEnlazada() {
  //this.first=this.last=null;
  //this.size=0;
  super(); //Es lo mismo que los de arriba
 }

 public MiListaEnlazada(E elemento) {
  this.elemento = elemento;
 }

 //Tarea
 public MiListaEnlazada(E[] valores) {

	 //MiListaEnlazada<E> lista_nueva = new MiListaEnlazada<E>();

	 

  //Una lista enlazada
 }

 public void ImprimirLista(E[] lista) {
  //NodoLE<E> nodos = new NodoLE<E>(null);
  for (int i = 0; i < lista.length; i++) {
	  System.out.print(lista[i] + ",");
  }

 }

 public E first() throws NoSuchElementException {
  // return this.first.getDato();
	 
	 try {
		  return this.first.getDato();
		 
	 }catch(NullPointerException ex) {
		 throw new NoSuchElementException("No se puede obtener el primer dato de una lista vacía");
	 }
 }
 
 

 public E last() throws NoSuchElementException {
	 try {
		  return this.last.getDato();
		 
	 }catch(NullPointerException ex) {
		 throw new NoSuchElementException("No se puede obtener el primer dato de una lista vacía");
	 }
 }

 public int size() {
  return this.size;
 }


 public boolean isEmpty() {
  //return this.first==null;
  return this.size == 0;
 }

 //Afuera de la lista siempre manejamos datos, no nodos. 
 public void insertAtFirst(E dato) {
  //NodoLE<E> nvo=new NodoLE<>(dato,this.first); //Dos pasos en uno referencia el dato y el next this.first
  //this.first=nvo;
  //Es lo mismo las dos lineas de arriba
  this.first = new NodoLE <> (dato, this.first);
  if (this.size == 0) {
   this.last = this.first;
  }
  this.size++;

 }

 //Tarea
 public void insertAtLast(E dato) {
  NodoLE <E> newNode = new NodoLE <> (dato);

  if (last == null) {
   first = last = newNode;
  } else {
   last.next = newNode;
   last = last.next;
  }
  size++;
 }

 //Tarea
 public void insertAt(E dato, int pos) throws IndexOutOfBoundsException {
  try {

   if (pos >= 0 || pos < this.size) {

    if (pos == 0) {
     insertAtFirst(dato);
    } else if (pos >= this.size) {
     insertAtLast(dato);	
    } else {
     //NodoLE<E> actual = new NodoLE(first);
     NodoLE <E> actual = first;
     for (int i = 1; i < pos; i++) {
      actual = actual.next;
     }
     NodoLE <E> temp = actual.next;
     actual.next = new NodoLE <E> (dato);
     (actual.next).next = temp;
     size++;
    }

   }
  } catch (NullPointerException e) {
   throw new NoSuchElementException("No se encuentra una posición correcta");
  }


 }


 @Override
 /*public String toString() {
  StringBuilder result = new StringBuilder("[");

  NodoLE <E> current = first;
  for (int i = 0; i < size; i++) {
   result.append(current.dato);
   current = current.next;
   if (current != null) {
    result.append(", "); 
   } else {
    result.append("]"); 
   }
  }

  return result.toString();
 }*/
 
 public String toString() {
	 String res = "";
	 NodoLE<E> current=this.first;
	 for (int i = 0; i < this.size; i++) {
		res+=current.getDato()+",";
		current=current.getNext();
	}
	 
	 return res;
 }
 
 
 
 
 
 
 
 
 
 

 public E removeFirst() {

  //Falta; terminar en clase; falta que pasa si la lista tiene un sólo elemento

  try {

   E dato = this.first();
   this.first = this.first.next;
   this.size--;
   if(this.size==0) {
	   this.last=null;
   }
   return dato;

  } catch (NullPointerException e) {
   throw new NoSuchElementException("No se puede borrar el inicio de una lista vacía");

  }

 }
//Tarea
 	public E removeLast() throws NoSuchElementException {
			
 			if(this.size<=1) {
 				return removeFirst();
 			}else {
 		 		NodoLE<E> current = this.first;
 	 	 		E dato = this.last();
 	 	 		for (int i = 0; i < this.size-2; i++) {
 	 				current=current.getNext();
 	 			} 
 	 	 		current.next=null;	 		
 	 	 		this.last=current;
 	 			this.size--;
 	 	 		return dato;
 			}
 		
 	}
 	
 	
//Tarea
 	public E removeAt(int pos) throws NoSuchElementException{
 		
 		if(this.size<=1) {
 			return 	this.removeFirst();
 		}
 		else if(pos==this.size-1) {
 			return this.removeLast();
 		}else {
 			NodoLE<E> current = this.first;
 			E dato;
 			for (int i = 0; i < pos-1; i++) {
				current=current.getNext();
			}
 			
 			dato=current.getNext().getDato();
 			current.setNext(current.getNext().getNext());
 			this.size--;
 			return dato;
 		}
 		
 }
 
//Insertar es insertar y set es cambiar los valores.
	public void setAt(E dato, int pos) throws IndexOutOfBoundsException {
			if(pos<0 || pos>= this.size) {

				throw new IndexOutOfBoundsException("No se puede colocar un valor en la posición" + pos+ "en una lista de tamaño" + this.size);
			}else {
				NodoLE<E> current=this.first;
				for (int i = 0; i < pos; i++) {
					current=current.getNext();
				}
				current.setDato(dato);
			}
			
}
 
 public static void main(String[] args) {

 
	 
	 Integer[] valores = {1,2,3,56,9};
  MiListaEnlazada lista = new MiListaEnlazada();



  lista.insertAtFirst(2);

  lista.insertAtFirst(3);

  
  System.out.println(lista.toString());


 }

 


}

//Nodo de lista enlazada
class NodoLE <E> {
 E dato;
 NodoLE <E> next;


 public NodoLE(E dato, NodoLE <E> next) {
  this.dato = dato;
  this.next = next;
 }
 public NodoLE() {

 }

 public E getDato() {
  return dato;
 }


 public void setDato(E dato) {
  this.dato = dato;
 }


 public NodoLE <E> getNext() {
  return next;
 }


 public void setNext(NodoLE <E> next) {
  this.next = next;
 }


 public NodoLE(E dato) {
  this(dato, null);
 }

}