package es.devirro;

/**
 * Clase para representar empleados eventuales.
 * @author Irene RODRIGUEZ RODRIGUEZ
 * @version 1.0
 */
// Subclase de Empleado para empleados eventuales
public class EmpleadoEventual extends Empleado {
    private int duracionContrato; // en meses

    // Constructor
    public EmpleadoEventual(String nombre, String dni, double salario, int duracionContrato) {
        super(nombre, dni, salario);
        this.duracionContrato = duracionContrato;
    }

    // Getters y Setters
    public int getDuracionContrato() {
        return duracionContrato;
    }

    public void setDuracionContrato(int duracionContrato) {
        this.duracionContrato = duracionContrato;
    }

    // Implementación del método abstracto
    @Override
    public double calcularSalario() {
        return getSalario(); // No incluye bonos para eventuales
    }

    @Override
    public String toString() {
        return super.toString() + ", duracionContrato=" + duracionContrato + " meses}";
    }
}