import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FractalSG extends JFrame {
			
	private Point a=new Point(400,100),
		  		  b=new Point(50,550),
		          c=new Point(750,550);
	private int nivel;
	
	
	public static void main(String[] args) {
		FractalSG ventana = new FractalSG();
	}
	
	private void pintaLineas(Graphics g, Point a, Point b) {
		g.drawLine(a.x,a.y,b.x,b.y);
	}
	
	private Point puntoMedio(Point a, Point b) {
		int xM=(a.x+b.x)/2;
		int yM=(a.y+b.y)/2;
		return new Point(xM, yM);
	}
	

	private void pintaTriangulos(Graphics g,int n,Point a,Point b,Point c) {
	
		if(n==0) {
			this.pintaLineas(g, a,b);
			this.pintaLineas(g, b,c);
			this.pintaLineas(g, c,a);
		}else {
			Point pmab=this.puntoMedio(a, b);
			Point pmbc=this.puntoMedio(b, c);
			Point pmca=this.puntoMedio(c, a);
			this.pintaTriangulos(g, n-1, a,pmab,pmca);
			this.pintaTriangulos(g, n-1, pmab,b,pmbc);
			this.pintaTriangulos(g, n-1, pmca,pmbc,c);
			
		}
		
		
		
	
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		pintaTriangulos(g,nivel,this.a,this.b,this.c);
	}
	
	
	public FractalSG() {
		
		super("Fractal SierpinskiGasket");
		this.setSize(800,600);
		this.nivel = Integer.parseInt(JOptionPane.showInputDialog("Ingresa nivel: "));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
