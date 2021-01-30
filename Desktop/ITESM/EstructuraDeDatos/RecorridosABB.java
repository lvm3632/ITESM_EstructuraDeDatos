//Autor: A01636172, Michel Lujano
//Nombre de la clase: MyABB.java
//Fecha:28/01/2020
//Comentarios: Recorridos de un arbol en PreOrden, PostOrden, InOrder y por Nivel. 


import java.util.LinkedList;
import java.util.Queue;

public class RecorridosABB<E extends Comparable<E>> {

	private MyNodoABB<E> root;
	private int size;

	public RecorridosABB() {
		root = null;
	}

	public static void main(String[] args) {
		RecorridosABB test = new RecorridosABB<>();

	

		System.out.print("preOrder: ");
		test.preOrder();
		System.out.println();
		System.out.print("inOrder: ");
		test.inOrder();
		System.out.println();
		System.out.print("postOrder: ");
		test.postOrder();
		System.out.println();
		
		System.out.println();
		System.out.print("Por Nivel: ");
		test.porNivel(test.root);
		test.print();

		System.out.println();

	}

	public void insert(E info) {
		insert(this.root, info);
	}

	public void preOrder() {
		preOrder(this.root);
	}

	private void porNivel(MyNodoABB<E> root) {

		Queue<MyNodoABB> queue = new LinkedList<MyNodoABB>();

		if (root == null) {
			return;
		}

		queue.add(this.root);

		while (!queue.isEmpty()) {

			MyNodoABB<E> current = queue.poll();

			System.out.print(current.info + ",");
			if (current.izq != null)
				queue.add(current.izq);
			if (current.der != null)
				queue.add(current.der);

		}

	}

	public void preOrder(MyNodoABB<E> parent) {

		MyNodoABB<E> current = parent;
		if (this.root == null) {
			return;
		}

		if (current == this.root) {
			System.out.print(current.getInfo() + ",");
		}

		if (current.izq == null) {
			System.out.print("");
		} else {
			System.out.print(current.izq.info + ",");
			preOrder(current.izq);
		}

		if (current.der == null) {
			System.out.print("");
		} else {
			System.out.print(current.der.info + ",");
			preOrder(current.der);
		}

	}

	public void postOrder() {
		postOrder(this.root);
	}

	public void postOrder(MyNodoABB<E> parent) {
		MyNodoABB<E> current = parent;

		if (this.root == null) {
			return;
		}

		if (current.izq == null) {
			System.out.print("");
		} else {
			postOrder(current.izq);
			System.out.print(current.izq.getInfo() + ",");
		}

		if (current.der == null) {
			System.out.print("");
		} else {
			postOrder(current.der);
			System.out.print(current.der.getInfo() + ",");
		}

		if (current == this.root) {
			System.out.print(current.getInfo() + ",");
		}

	}

	public void inOrder() {
		inOrder(this.root);
	}

	public void inOrder(MyNodoABB<E> parent) {

		MyNodoABB<E> current = parent;

		if (current == null) {
			return;
		}
		inOrder(current.izq);
		System.out.print(current.getInfo() + ",");
		inOrder(current.der);

	}

	private void preOrden(MyNodoABB<E> current) {
		if (current != null) {
			preOrden(current.izq);
			System.out.print(current.getInfo() + ",");
			preOrden(current.der);
		}
	}

	public void insert(MyNodoABB<E> parent, E info) {

		if (this.root == null) {
			// System.out.println("UNA");
			this.root = new MyNodoABB<>(info);
		} else {

			if (parent.getInfo().compareTo(info) > 0) {

				if (parent.izq == null)
					parent.izq = new MyNodoABB<>(info);
				else
					insert(parent.izq, info);

			}

			if (parent.getInfo().compareTo(info) <= 0) {

				if (parent.der == null)
					parent.der = new MyNodoABB<>(info);
				else
					insert(parent.der, info);

			}

		}

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Método para insertar un nodo en el arbol
	public void insertNode(E info) {
		MyNodoABB<E> nvo = new MyNodoABB<>(info);
		if (root == null) {
			this.root = nvo;
			return;
		}

		MyNodoABB<E> parent = null;
		MyNodoABB<E> current = this.root;

		while (current != null) {
			parent = current;
			if (info.compareTo(current.info) > 0) {
				current = current.der;
			} else if (info.compareTo(current.info) < 0) {
				current = current.izq;
			} else {
				return;
			}
		}

		if (info.compareTo(parent.getInfo()) >= 0) {
			parent.der = nvo;
		} else if (info.compareTo(parent.getInfo()) < 0) {
			parent.izq = nvo;
		}

	}

	public int size() {
		return this.size;
	}

	private int getHeight(MyNodoABB<E> current) {
		if (current == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(current.getIzq()), getHeight(current.getDer()));
	}

	
	
	
	
	
	
	
	
	
	
	
	public void print() {
		MyNodoABB[] nodes = { this.root };
		if (this.root == null) {
			return;
		}
		int height = Math.max(getHeight(this.root.getIzq()), getHeight(this.root.getDer()));

		while (haveNodesToPrint(nodes)) {
			int offset = (int) Math.pow(2, height + 2);

			for (MyNodoABB node : nodes) {
				printSpace(offset); // offset before every number
				if (node != null) {
					System.out.print(node.getInfo());
				} else {
					System.out.print("  ");
				}
				printSpace(offset - 2); // minus 2 because we expect the number to have length of 2

			}
			// print the spaces
			for (int i = 0; i <= height; i++) {
				System.out.println();
			}

			// prepare for printing next line
			MyNodoABB[] newNodes = new MyNodoABB[nodes.length * 2]; // every node have 2 childs
			int index = 0;
			for (MyNodoABB node : nodes) {
				if (node != null) {
					newNodes[index] = node.getIzq();
					index++;
					newNodes[index] = node.getDer();
					index++;
				} else {
					// even if it is null you need to print spaces
					newNodes[index] = null;
					index++;
					newNodes[index] = null;
					index++;
				}
			}

			nodes = newNodes;
			height--;
		}
	}

	private boolean haveNodesToPrint(MyNodoABB[] nodes) {
		for (MyNodoABB node : nodes) {
			if (node != null) {
				return true;
			}
		}
		return false;
	}

	private void printSpace(int n) {
		while (n != 0) {
			System.out.print(" ");
			n--;
		}
	}

	// Si es Comparable, evita que sea de lo que sea, y con Comparable se pueden
	// comparar
	class MyNodoABB<E extends Comparable<E>> {

		MyNodoABB<E> izq, der;
		E info;

		public MyNodoABB(E info, MyNodoABB<E> izq, MyNodoABB<E> der) { // Constructor
			this.izq = izq;
			this.der = der;
			this.info = info;
		}

		public MyNodoABB(E info) { // Nodo hoja
			this(info, null, null);
		}

		public MyNodoABB<E> getIzq() {
			return izq;
		}

		public void setIzq(MyNodoABB<E> izq) {
			this.izq = izq;
		}

		public MyNodoABB<E> getDer() {
			return der;
		}

		public void setDer(MyNodoABB<E> der) {
			this.der = der;
		}

		public E getInfo() {
			return info;
		}

		public void setInfo(E info) {
			this.info = info;
		}

	}

}
