//Autor: A01636172, Michel Lujano
//Nombre de la clase: Laberinto.java
//Fecha:13/01/2020
//Comentarios:Me gustó el tema de backtracking, creo que es ver la programación de otra manera


import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Laberinto {

 private Point inicio, fin;
 private boolean laberinto[][];
 private boolean pasado[][][];

 public Laberinto(String archivo) {

  FileReader fr = null;
  BufferedReader br = null;

  try {

   fr = new FileReader(archivo);
   br = new BufferedReader(fr);

   String[] lab = null;
   String linea;
   int datos[][] = new int[3][2]; //Array para guardar los datos 
   int i = 0,
    j = 0;

   while ((linea = br.readLine()) != null) { //Cargar archivo
    String[] arr = linea.split(" ");
    if (i < 3) {
     datos[i][0] = Integer.parseInt(arr[0]); //inicioX
     datos[i][1] = Integer.parseInt(arr[1]); //finX
     if (i == 2) {
      lab = new String[datos[2][0]];
     }
    }
    if (i >= 3 && j <= lab.length - 1) {
     lab[j] = linea;
     j++;
    }

    i++;
   }
   //Fin cargar archivo

   int filas = datos[2][0],
    columnas = datos[2][1],
    inicioX = datos[0][0],
    inicioY = datos[0][1],
    finX = datos[1][0],
    finY = datos[1][1];

   String[][] salida = new String[filas][columnas];
   char[][] mapa = new char[filas][columnas];

   this.inicio = new Point(inicioX, inicioY);
   this.fin = new Point(finX, finY);
   this.laberinto = new boolean[filas][columnas]; 
   this.pasado = new boolean[filas][columnas][2];

   for (int k = 0; k < filas; k++) {
    for (int l = 0; l < columnas; l++) {
     mapa[k][l] = lab[k].charAt(l);

     if (mapa[k][l] == '0') {
      laberinto[k][l] = false;
     } else if (mapa[k][l] == '1') {
      laberinto[k][l] = true;
     }
    }
   }

   buscar(inicioX, inicioY);

   try {
    FileWriter fw = new FileWriter("Salida.txt");
    for (int k = 0; k < filas; k++) {
     for (int l = 0; l < columnas; l++) {
      if (k == inicioX && l == inicioY) {
       if (l == columnas - 1) {
        fw.write("I");
       } else {
        fw.write("I" + ",");
       }
      } else if (k == finX && l == finY) {
       if (l == columnas - 1) {
        fw.write("F");
       } else {
        fw.write("F" + ",");
       }
      } else if (l == columnas - 1) {
       if (laberinto[k][l]) {
        fw.write("P");
       } else if (pasado[k][l][1]) {
        fw.write("Y");
       } else if (pasado[k][l][0] == !pasado[k][l][1]) {
        fw.write("X");
       } else if (!pasado[k][l][0] && !pasado[k][l][1]) {
        fw.write(" ");
       }
      } else {
       if (laberinto[k][l]) {
        fw.write("P" + ",");
       } else if (pasado[k][l][1]) {
        fw.write("Y" + ",");
       } else if (pasado[k][l][0] == !pasado[k][l][1]) {
        fw.write("X" + ",");
       } else if (!pasado[k][l][0] && !pasado[k][l][1]) {
        fw.write(" " + ",");
       }
      }
     }
     fw.write("\n");
    }
    fw.close();
   } catch (IOException e) {
    System.out.println("File was not created.");
    e.printStackTrace();
   }

  } catch (FileNotFoundException e) {
   System.out.println("Archivo no encontrado");
  } catch (IOException e) {
   System.out.println("Error: " + e.getMessage());
  }
  /*Fin creando archivo Salida.txt */
 }


 public static void main(String[] args) {
  Laberinto test1 = new Laberinto("EjemploEntrada.txt");
 }


 public boolean buscar(int x, int y) {

	  if (x == this.fin.x && y == this.fin.y) {
	   return true;
	  }
	  pasado[x][y][0] = true;
	  //Derecha
	  if (validar(x, y+1)) {
		  if(buscar(x,y+1)) {
			  pasado[x][y][1] = true;
			   return true;
		  }	
	  }
	  //Abajo
	  if (validar(x+1, y)) {
		  if(buscar(x+1,y)) {
			  pasado[x][y][1] = true;
			   return true;
		  }
	  }
	  //Izquierda
	  if (validar(x, y-1)) {
		  if(buscar(x,y-1)) {
			  pasado[x][y][1] = true;
			   return true;
		  }
	  }
	  //Arriba
	  if (validar(x-1, y)) {
		  if(buscar(x-1,y)) {
			  pasado[x][y][1] = true;
			   return true;
		  }
	  }

	  return false;
	  
	 }


 private boolean validar(int x, int y) {

  if (x < 0 || x >= laberinto.length || y < 0 || y >= laberinto[0].length) { //Bordes del laberinto
   return false;
  }
  if(laberinto[x][y] || pasado[x][y][0]) { //Pared y Camino Visitado
	  return false;
  }
  return true;
 }

}