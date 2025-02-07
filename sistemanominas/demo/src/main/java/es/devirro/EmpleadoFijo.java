package es.devirro;

/**
 * Clase para representar empleados fijos.
 * @author Irene RODRIGUEZ RODRIGUEZ
 * @version 1.0
 */

// Subclase de Empleado para empleados fijos
public class EmpleadoFijo extends Empleado {
    private double bonoAnual;

    // Constructor
    public EmpleadoFijo(String nombre, String dni, double salario, double bonoAnual) {
        super(nombre, dni, salario);
        this.bonoAnual = bonoAnual;
    }

    // Getters y Setters
    public double getBonoAnual() {
        return bonoAnual;
    }

    public void setBonoAnual(double bonoAnual) {
        this.bonoAnual = bonoAnual;
    }

    // Implementación del método abstracto
    @Override
    public double calcularSalario() {
        return getSalario() + bonoAnual;
    }

    @Override
    public String toString() {
        return super.toString() + ", bonoAnual=" + bonoAnual + '}';
    }
}