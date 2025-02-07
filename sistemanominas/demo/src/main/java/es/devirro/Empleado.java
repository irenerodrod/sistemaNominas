package es.devirro;

/**
 * Clase base para representar empleados.
 * @author Irene RODRIGUEZ RODRIGUEZ
 * @version 1.0
 * @since 1.0
 */

// Clase base Empleado
public abstract class Empleado {
    private String nombre;
    private String dni;
    private double salario;

    // Constructor
    public Empleado(String nombre, String dni, double salario) {
        this.nombre = nombre;
        this.dni = dni;
        this.salario = salario;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método abstracto para calcular el salario final
    public abstract double calcularSalario();

    @Override
    public String toString() {
        return "Empleado{" +
               "nombre='" + nombre + '\'' +
               ", dni='" + dni + '\'' +
               ", salario=" + salario +
               '}';
    }
}
