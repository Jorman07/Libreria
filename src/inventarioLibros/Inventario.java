package inventarioLibros;
import java.util.ArrayList;


public class Inventario {
private ArrayList<Libro> libros = new ArrayList<Libro>();
private int cantidad;
	
	public void almacenar(Libro libro) {
		libros.add(libro);
	}
	
	public Libro getLibrobyIsbn(String isbn) {
		for(Libro l: libros) {
			if(l.getIsbn().equals(isbn)) {
				return l;
			}
		}
		return null;
	}
	
	public Libro getVentaLibro(String isbn) {
		for(Libro l: libros) {
			if(l.getIsbn().equals(isbn)) {
				this.cantidad = l.getCantidad();
				this.cantidad--;
				if(this.cantidad <0) {
					return null;
				}else {
					l.setCantidad(cantidad);
					return l;
				}
			}		
		}
		return null;
	}
	
	public ArrayList<Libro> getLibros() {
		return libros;
	}
}
