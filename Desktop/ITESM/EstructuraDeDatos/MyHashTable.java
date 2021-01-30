import java.util.Iterator;
import java.util.LinkedList;

//Key y value
public class MyHashTable<K, V> {

	private int size;
	private LinkedList<NodoHT<K, V>>[] tabla;
	private final static double LOADFACTOR = 0.75; // Java optimiza constantes con final

	public MyHashTable() {
		this(11);
	}

	public MyHashTable(int length) {
		this.tabla = (LinkedList<NodoHT<K, V>>[]) new LinkedList[length];
		for (int i = 0; i < tabla.length; i++) {
			this.tabla[i] = new LinkedList<NodoHT<K, V>>();
		}
		this.size = 0;
	}

	private void rehashing() {

		MyHashTable<K, V> ht = new MyHashTable(2 * this.tabla.length + 1);

		for (LinkedList<NodoHT<K, V>> lista : this.tabla) { // Recorro todos los elementos de esa tabla (en bloques)
			for (NodoHT<K, V> elemento : lista) { // Entra a ese bloque, y recorre los elementos de esa LinkedList
				ht.put(elemento.llave, elemento.valor);
			}
		}

		this.tabla = ht.tabla;
		System.gc();
	}

	public void put(K llave, V valor) {
		System.out.println(llave.hashCode());
		int pos = Math.abs(llave.hashCode() % this.tabla.length);
		this.tabla[pos].addFirst(new NodoHT(llave, valor));
		this.size++;

		if ((double) this.size / this.tabla.length > MyHashTable.LOADFACTOR) {
			this.rehashing();
		}

	}

//Borrado si tiene iterador lista enlazada es lineal, y sino cuadrático
	public V delete(K llave) {
		int pos = Math.abs(llave.hashCode() % this.tabla.length);

		Iterator <NodoHT<K, V>> it = tabla[pos].iterator();

		NodoHT<K, V> current;
		while (it.hasNext()) {
			current = it.next();
			if (llave.equals(current.llave)) {
				it.remove(); // Borra el último elemento después que se regresó hacer un next.
				//Linkedlist ^
				this.size--;
				return current.valor;

			}
		}

		return null;

	}

	public V get(K llave) {
		int pos = Math.abs(llave.hashCode() % this.tabla.length);

		/*for (NodoHT<K, V> nodo : this.tabla[pos]) {
			if (nodo.llave.equals(llave)) {
				return nodo.valor;
			}
		}*/
		
		Iterator <NodoHT<K,V>> it = this.tabla[pos].iterator();
		NodoHT<K,V> current;
		
		
		while(it.hasNext()) {
			current=it.next();
			
			if(llave.equals(current.llave)) {
				return current.valor;
			}
		}
		return null;
	}

	public void flush() {
		this.tabla = (LinkedList<NodoHT<K, V>>[]) new LinkedList[11];
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

//Serviría para encontrar el valor, es mejor.
	public boolean containsKey(K llave) {

		for (LinkedList<NodoHT<K, V>> lista : this.tabla) { // Recorro todos los elementos de esa tabla (en bloques)
			for (NodoHT<K, V> elemento : lista) { // Entra a ese bloque, y recorre los elementos de esa LinkedList
				if (llave.equals(elemento.llave)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean containsKey2(K llave) {
		return this.get(llave) != null;
	}

//Más eficiente
	public boolean containsKey3(K llave) {

		int pos = Math.abs(llave.hashCode() % this.tabla.length);

		for (NodoHT<K, V> nodo : this.tabla[pos]) {
			if (nodo.llave.equals(llave)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
//System.out.println("Hola".hashCode()); //Llave con método hashCode

		MyHashTable<String, Integer> tabla = new MyHashTable<>();

		tabla.put("uno", 1);
		tabla.put("dos", 2);
		tabla.put("tres", 3);
		tabla.put("cuatro", 4);
		tabla.put("cinco", 5);
		tabla.put("seis", 6);
		tabla.put("siete", 7);
		tabla.put("ocho", 8);
		tabla.put("nueve", 9);
		tabla.put("diez", 10);
		tabla.put("once", 11);
		//System.out.println(tabla.containsKey("uno"));
		System.out.println(tabla.get("ocho"));
		System.out.println(tabla.get("cuatro"));
		tabla.delete("cuatro");
		System.out.println(tabla.get("cuatro"));

	}

}

class NodoHT<K, V> {
	K llave;
	V valor;

	public NodoHT(K llave, V valor) {
		this.llave = llave;
		this.valor = valor;
	}

	public String toString() {
		String res;
		res = this.llave + ":" + this.valor;
		return res;
	}

}
