package herencia.abstracta;

// Clase abstracta base Figura
abstract class Figura {
    // Calcula el area
    public abstract double calcularArea();
    // calcula el perímetro
    public abstract double calcularPerimetro();
}

// Subclase Rectángulo
class Rectangulo extends Figura {
    private double largo, ancho;
    // Constructor de la clase rectangulo
    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    // Sobre escribe el método calcular área de un rectangulo
    @Override
    public double calcularArea() {
        return largo * ancho;
    }

    // Sobre escribe el método calcular perímetro de un rectangulo
    @Override
    public double calcularPerimetro() {
        return 2 * (largo + ancho);
    }
}

// Subclase Círculo
class Circulo extends Figura {
    private double radio;

    // Constructor de la clase circulo
    public Circulo(double radio) {
        this.radio = radio;
    }

    // Sobre escribe el método calcular area de un circulo
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    // Sobre escribe el método calcular area de un circulo
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

// Clase principal
public class Figuras{
    public static void main(String[] args) {
        Figura rectangulo = new Rectangulo(5, 3);
        Figura circulo = new Circulo(4);

        System.out.println("Área del Rectángulo: " + rectangulo.calcularArea());
        System.out.println("Perímetro del Rectángulo: " + rectangulo.calcularPerimetro());

        System.out.println("Área del Círculo: " + circulo.calcularArea());
        System.out.println("Perímetro del Círculo: " + circulo.calcularPerimetro());
    }
}
