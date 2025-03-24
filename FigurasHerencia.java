package herencia;

// Clase base Figura
class Figura {
    protected double x, y;

    public Figura(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Posición -> (x: " + x + ", y: " + y + ")";
    }

    protected double calcularArea() {
        return 0;
    }

    // Sobre escribe el método calcular perímetro de un rectangulo
    protected double calcularPerimetro() {
        return 0;
    }
}

// Subclase Rectángulo
class Rectangulo extends Figura {
    private double largo, ancho;

    // Constructor de la clase rectangulo
    public Rectangulo(double x, double y, double largo, double ancho) {
        super(x, y);
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

    @Override
    public String toString() {
        return "Rectángulo -> " + super.toString() +
               ", Ancho: " + ancho + ", Alto: " + largo +
               ", Área: " + calcularArea() +
               ", Perímetro: " + calcularPerimetro();
    }
}

// Subclase Círculo
class Circulo extends Figura {
    private double radio;

    // Constructor de la clase circulo
    public Circulo(double x, double y, double radio) {
        super(x, y);
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

    @Override
    public String toString() {
        return "Círculo -> " + super.toString() +
               ", Radio: " + radio +
               ", Área: " + calcularArea() +
               ", Perímetro: " + calcularPerimetro();
    }
}

// Clase principal
public class FigurasHerencia {
    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo(1,1,5, 3);
        Circulo circulo = new Circulo(5,5, 4);
        Figura figura = circulo;

        System.out.println("Area de la  figura:"+figura.calcularArea());

        System.out.println("Área del Rectángulo: " + rectangulo.calcularArea());
        System.out.println("Perímetro del Rectángulo: " + rectangulo.calcularPerimetro());

        System.out.println("Área del Círculo: " + circulo.calcularArea());
        System.out.println("Perímetro del Círculo: " + circulo.calcularPerimetro());
    }
}
