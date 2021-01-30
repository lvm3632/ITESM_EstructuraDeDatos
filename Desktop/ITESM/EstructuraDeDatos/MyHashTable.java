// Autor: Michel Lujano
// Matrícula: A01636172
// Clase: MyHashTable.java
// Fecha: 06/05/20

import java.util.Iterator;
import java.util.LinkedList;


public class MyHashTable<K,V> {
	
	
	public static void main(String[] args) {
		MyHashTable<String, Integer> tabla = new MyHashTable<>();

		tabla.put("hola", 2+5);
		System.out.println(tabla.get("hola"));
		
		tabla.delete("hola");
		System.out.println(tabla.get("hola"));
		System.out.println(tabla.containsKey("hola"));
		tabla.put("hola", 2+52);
		System.out.println(tabla.containsKey("hola"));
		System.out.println(tabla.get("hola"));
	}
	
	
	
	private int size;
	public static double LOADFACTOR = 0.75;
	
	private LinkedList<MyNodoHT<K,V>>[] tabla;
	
	public MyHashTable() {
		this(11);
	}
	
	public void put(K llave, V valor) {
		
		int pos = Math.abs(llave.hashCode() % this.tabla.length);
		
		this.tabla[pos].addFirst(new MyNodoHT(llave, valor));
		this.size++;
		
		if((double) this.size / this.tabla.length > MyHashTable.LOADFACTOR) {
			this.rehashing();
		}
		
	}
	
	private void rehashing() {
		
		MyHashTable<K,V> ht = new MyHashTable(2*this.tabla.length+1);
		
		for(LinkedList<MyNodoHT<K,V>> lista : this.tabla) {
			for(MyNodoHT<K,V> nodo : lista) {
				ht.put(nodo.llave, nodo.valor);
			}
		}
		
		this.tabla = ht.tabla;
		System.gc();
		
	}
	
	public MyHashTable(int length) {
		
		this.tabla = (LinkedList<MyNodoHT<K,V>>[]) new LinkedList[length];
		
		for(int i=0;i<tabla.length;i++) {
			this.tabla[i] = new LinkedList<MyNodoHT<K,V>>();
		}
		this.size=0;
	}
	
	public V get(K llave) {
		
		int pos = Math.abs(llave.hashCode()%this.tabla.length);
		
		Iterator <MyNodoHT<K,V>> it = this.tabla[pos].iterator();
		MyNodoHT<K,V> current;
		while(it.hasNext()) {
			current=it.next();
			if(llave.equals(current.llave)) {
				return current.valor;
			}
		}
		return null;
	}
	
	public V delete(K llave) {
		
		int pos = Math.abs(llave.hashCode()%this.tabla.length);
		
		Iterator <MyNodoHT<K,V>> it = tabla[pos].iterator();
		
		MyNodoHT<K,V> current;
		
		while(it.hasNext()) {
			current = it.next();
			
			if(llave.equals(current.llave)) {
				it.remove();
				this.size--;
				return current.valor;				
			}
		}
		return null;                       
	}
	
	public boolean containsKey(K llave) {
		return this.get(llave) != null;
	}
	
}

class MyNodoHT<K,V>{
	K llave;
	V valor;
	
	public MyNodoHT(K llave, V valor) {
		this.llave = llave;
		this.valor = valor;
	}
	
	public String toString() {
		String res;
		res = this.llave+ ":"+ this.valor;
		return res;
	}
}
