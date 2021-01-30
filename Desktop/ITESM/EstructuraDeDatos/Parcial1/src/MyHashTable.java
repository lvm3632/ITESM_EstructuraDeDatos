import java.util.LinkedList;
public class MyHashTable <K,V> {
	

	private  LinkedList<MyNodoHT<K, V>>[] tabla;
	private int size;
	private static final double loadFactor=0.75;
	
	
	// Comstructor, se crea la tabla de tamaño 11
	public MyHashTable() {
		this.tabla=(LinkedList<MyNodoHT<K, V>>[]) new LinkedList[11];
		
		for(int i=0;i<this.tabla.length;i++) {
			this.tabla[i]=new LinkedList<>();
		}
		
		this.size=0;
	}
	// put(llave, valor)
	public void put(K llave, V valor) {
		if(((double)this.size)/this.tabla.length > MyHashTable.loadFactor) {
			rehasing();
		}
			int pos=Math.abs(llave.hashCode()%this.tabla.length);
			this.tabla[pos].add(new MyNodoHT<K,V>(llave,valor));
			this.size++;
	}
	//get(llave): valor
	
	public K get(K llave) {
		return llave;
	}
	
	private void rehasing() {
		//private rehasing(): Incrementa el tamaño de la lista al doble+1 cuando se exceda el loadFactor
		
	}
	//containsKey(llave): boolean true si la llave esta en la HT
	
	/*public V remove(K llave) {
		//Borra de la tabla el elemento que tiene esa llave y regresa el valor asociado
		//Si la llave no está arroja NoSuchElementException
	}*/
	
	public static void main(String[] args) {
		MyHashTable<String,Integer> ht = new MyHashTable<>();
	}

}

//K key, V value
class MyNodoHT<K, V>{
	K llave;
	V valor;
	
	public MyNodoHT(K llave, V valor) {
		this.llave = llave;
		this.valor = valor;
		
	}
	
	public String toString() {
		return "Key: " + this.llave + ", value:"+this.valor;
	}
	
	
	
}