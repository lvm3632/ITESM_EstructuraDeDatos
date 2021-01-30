//Autor: A01636172 Michel Lujano
//Nombre de la clase: YaMeHiceBolas.java
//Fecha: 26/08/19
//Comentarios: Es una buena forma de implementar recursividad, mediante los gráficos porque se entiende más.
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class YaMeHiceBolas extends JFrame {

	
	private int x1,
	  y1,
	  largo;

	
	int nivel;
	
		public YaMeHiceBolas() {
			
			super("Ya me hice bolas");
			this.setPreferredSize(new Dimension(700,720));
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			this.x1 = 50;
			this.y1 = 350;
			this.largo = 600;
			
			this.nivel = Integer.parseInt(JOptionPane.showInputDialog("Introduce el nivel de profundidad"));
			this.setVisible(true);
			this.pack();
		}

	
		public void paint(Graphics g) {
			super.paint(g);
			this.pintaCirculos(g, nivel, x1, y1, largo);
		}
	

		
	public void pintaCirculos(Graphics g, int nivel, int x1, int y1, int largo) {

		pintaLineas(g, x1, y1-largo/2, largo);
		
		if(nivel == 0) {
			
		}else {
			
			
			 this.pintaCirculos(g, nivel-1, x1, y1, largo/2);
			 
			 
			 this.pintaCirculos(g, nivel-1, x1+largo/2, y1, largo/2);
		}
	}
	
	public void pintaLineas(Graphics g, int x1, int y1, int largo) {
		
		g.drawOval(x1, y1, largo, largo);
	}

	
	
	public static void main(String[] args) {
		YaMeHiceBolas prueba = new YaMeHiceBolas();
	}
}
