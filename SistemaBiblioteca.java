package herencia;

import java.util.ArrayList;
import java.util.List;

// Clase base ItemBiblioteca
abstract class ItemBiblioteca {
    protected String titulo;
    protected int año;
    protected boolean prestado;

    public ItemBiblioteca(String titulo, int año) {
        this.titulo = titulo;
        this.año = año;
        this.prestado = false;
    }

    public void prestar() {
        if (!prestado) {
            prestado = true;
            System.out.println("El ítem '" + titulo + "' ha sido prestado.");
        } else {
            System.out.println("El ítem '" + titulo + "' ya está prestado.");
        }
    }

    public void devolver() {
        if (prestado) {
            prestado = false;
            System.out.println("El ítem '" + titulo + "' ha sido devuelto.");
        } else {
            System.out.println("El ítem '" + titulo + "' no estaba prestado.");
        }
    }

    public boolean estaPrestado() {
        return prestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract void mostrarInfo();
}

// Clase Libro
class Libro extends ItemBiblioteca {
    private String autor;
    private int nroEdicion;

    public Libro(String titulo, int año, String autor, int nroEdicion) {
        super(titulo, año);
        this.autor = autor;
        this.nroEdicion = nroEdicion;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Libro: " + titulo + " | Autor: " + autor + " | Año: " + año + " | Edición: " + nroEdicion + " | Prestado: " + prestado);
    }
}

// Clase Revista
class Revista extends ItemBiblioteca {
    private int nroEdicion;

    public Revista(String titulo, int año, int nroEdicion) {
        super(titulo, año);
        this.nroEdicion = nroEdicion;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Revista: " + titulo + " | Año: " + año + " | Edición: " + nroEdicion + " | Prestado: " + prestado);
    }
}

// Clase Tesis
class Tesis extends ItemBiblioteca {
    private String autor;
    private int añoDefensa;

    public Tesis(String titulo, int año, String autor, int añoDefensa) {
        super(titulo, año);
        this.autor = autor;
        this.añoDefensa = añoDefensa;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tesis: " + titulo + " | Autor: " + autor + " | Año Defensa: " + añoDefensa + " | Prestado: " + prestado);
    }
}

// Clase Biblioteca
class Biblioteca {
    private List<ItemBiblioteca> items;

    public Biblioteca() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemBiblioteca item) {
        items.add(item);
    }

    public void listarPrestados() {
        System.out.println("\n📚 Ítems Prestados:");
        for (ItemBiblioteca item : items) {
            if (item.estaPrestado()) {
                item.mostrarInfo();
            }
        }
    }

    public void buscarLibroPorAutor(String autor) {
        System.out.println("\n🔍 Buscando libros de " + autor + "...");
        boolean encontrado = false;
        for (ItemBiblioteca item : items) {
            if (item instanceof Libro) {
                Libro libro = (Libro) item;
                if (libro.getAutor().equalsIgnoreCase(autor)) {
                    libro.mostrarInfo();
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("❌ No se encontraron libros del autor '" + autor + "'.");
        }
    }
}

// Clase principal para pruebas
public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Agregando ítems
        Libro libro1 = new Libro("La mala hora", 1962, "Gabriel Garcia Marquez", 1);
        Libro libro2 = new Libro("Cien Años de Soledad", 1967, "Gabriel García Márquez", 3);
        Libro libro3 = new Libro("Ensayo sobre la ceguera", 1995, "José Saramago", 1);
        Revista revista1 = new Revista("National Geographic", 2023, 120);
        Tesis tesis1 = new Tesis("Redes Neuronales en IA", 2020, "Juan Pérez", 2021);

        biblioteca.agregarItem(libro1);
        biblioteca.agregarItem(libro2);
        biblioteca.agregarItem(libro3);
        biblioteca.agregarItem(revista1);
        biblioteca.agregarItem(tesis1);

        // Prestamos
        libro1.prestar();
        revista1.prestar();

        // Listar prestados
        biblioteca.listarPrestados();

        // Buscar libro por autor
        biblioteca.buscarLibroPorAutor("Gabriel García Márquez");
        biblioteca.buscarLibroPorAutor("J.K. Rowling");
    }
}
