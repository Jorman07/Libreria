package inventarioLibros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Libro l1 = new Libro("001", "Alpha", 10, 3);
		Libro l2 = new Libro("002", "Beta", 24, 4);
		Libro l3 = new Libro("003", "Omega", 21, 2);
		Libro l4 = new Libro("004", "Gama", 4, 1);
		
		Inventario inventario = new Inventario();
		
		inventario.almacenar(l1);
		inventario.almacenar(l2);
		inventario.almacenar(l3);
		inventario.almacenar(l4);
		
		ArrayList<Libro> libros = inventario.getLibros();
		Scanner sc=new Scanner(System.in);
		int op = -1;
		while(op!=0) {
			System.out.println("<1> Ingresar libro");
			System.out.println("<2> Buscar libro por isnb");
			System.out.println("<3> Venta de Libro");
			System.out.println("<4> Tres libro mas caros");
			System.out.println("<5> Todos los libros");
			System.out.println("<0> Salir");
			
			System.out.println("Ingrese opción: ");
			op = sc.nextInt();  
			
			switch (op) {
			case 1: {
				boolean correct = true;
				while (correct) {
					Scanner sc1=new Scanner(System.in);
					System.out.println("Ingrese el ISBN del libro: ");
					String isbn = sc1.nextLine();
					Libro busc = inventario.getLibrobyIsbn(isbn);
					if (busc != null) {
						System.out.println("El ISBN del libro ya existe: " + busc);
					}else {
						System.out.println("Ingrese el Titulo del libro: ");
						String tic = sc1.nextLine();
						
						System.out.println("Ingrese el precio del libro: ");
						double prec = sc1.nextDouble();
						
						System.out.println("Ingrese la cantidad de libros con los mismos datos: ");
						int cant = sc1.nextInt();
						
						inventario.almacenar(new Libro(isbn, tic, prec, cant));
						correct = false;
					}		
				}
				break;
			}
			
			case 2: {
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Ingrese el ISBN del libro que desea buscar : ");
				String isbn = sc2.nextLine();
				Libro busc = inventario.getLibrobyIsbn(isbn);
				if(busc != null) {
					System.out.println(busc);
				}else {
					System.out.println("No se encontro el libro con el ISBN "+ isbn);
				}
				break;
			}
			
			case 3:{
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Ingrese el ISBN del libro que desea vender: ");
				String isbn = sc1.nextLine();
				Libro vendido = inventario.getVentaLibro(isbn);
				if(vendido != null) {
					System.out.println("Estos son los datos despues de la venta: ");
					System.out.println(vendido);
				}else {
					System.out.println("No hay mas libros o el ISBN es incorrecto... ");
				}
				break;
			}
			
			case 4:{
				System.out.println("Estos son los 3 libros mas caros: ");
				Collections.sort(libros, Collections.reverseOrder());
				for(int i = 0;i<3;i++) {
					Libro l = libros.get(i);
					System.out.println(l);
				}
				break;
			}
			
			case 5:{
				System.out.println("Estos son todos los libros del inventario: ");
				Collections.sort(libros);
				for(Libro l: libros) {
					
					System.out.println(l);
				}
				break;
			}
			
			default:
				break;
			}
		}
	}
}
