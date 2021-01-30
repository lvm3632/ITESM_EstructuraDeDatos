//Autor: A01636172 Michel Lujano
//Nombre de la clase: YaMeHiceBolas.java
//Fecha: 17/02/20
//Comentarios: Círculos.

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class YaMeHiceBolas extends JFrame {

	public static void main(String[] args) {
		YaMeHiceBolas test = new YaMeHiceBolas();
	}
	
	private int nivel;
	
	public YaMeHiceBolas() {
		super("YaMeHiceBolas");
		this.setPreferredSize(new Dimension(720,700));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.nivel = Integer.parseInt(JOptionPane.showInputDialog("Introduce un nivel: "));
		this.setVisible(true);
		this.pack();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.pintaCirculos(g,nivel,50,50,600);
	}
	
	public void pintaCirculos(Graphics g, int nivel, int x1, int y1, int largo) {
		if(nivel==0) {
			g.drawOval(x1, y1, largo, largo);
		}else {
			this.pintaCirculos(g, nivel-1, x1, y1+largo/4, largo/2);
			this.pintaCirculos(g, nivel-1, x1+largo/2, y1+largo/4, largo/2);
			g.drawOval(x1, y1, largo, largo);
		}
		
	}
	
	
	
}
