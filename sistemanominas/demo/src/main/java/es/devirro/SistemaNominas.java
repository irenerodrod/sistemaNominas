package es.devirro;
// Clase principal para gestionar el sistema de nóminas
import java.util.*;

/**
 * Clase principal para gestionar el sistema de nóminas.
 * @author Irene RODRIGUEZ RODRIGUEZ
 * @version 1.0
 */
public class SistemaNominas {
    private List<Empleado> empleados;

    // Constructor
    public SistemaNominas() {
        this.empleados = new ArrayList<>();
    }

    // Métodos para las opciones del menú

    /**
     * Sirve para crear un empleado fijo.
     * @param nombre
     * @param dni
     * @param salario
     * @param bonoAnual
     */
    public void crearEmpleadoFijo(String nombre, String dni, double salario, double bonoAnual) {
        empleados.add(new EmpleadoFijo(nombre, dni, salario, bonoAnual));
    }

    /**
     * Sirve para crear un empleado eventual.
     * @param nombre
     * @param dni
     * @param salario
     * @param duracionContrato
     */
    public void crearEmpleadoEventual(String nombre, String dni, double salario, int duracionContrato) {
        empleados.add(new EmpleadoEventual(nombre, dni, salario, duracionContrato));
    }

    /**
     * Sirve para consultar un empleado.
     * @param dni
     * @return
     */
    public Empleado consultarEmpleado(String dni) {
        return empleados.stream().filter(e -> e.getDni().equals(dni)).findFirst().orElse(null);
    }

    /**
     * Sirve para eliminar un empleado.
     * @param dni
     * @return
     */
    public boolean eliminarEmpleado(String dni) {
        return empleados.removeIf(e -> e.getDni().equals(dni));
    }

    /**
     * Sirve para listar los empleados.
     * @return empleados
     */
    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados);
    }

    /**
     * Sirve para listar los empleados por sueldo.
     * @return empleados
     */
    public List<Empleado> listarEmpleadosPorSueldo() {
        List<Empleado> copia = new ArrayList<>(empleados);
        copia.sort(Comparator.comparingDouble(Empleado::calcularSalario).reversed());
        return copia;
    }

    /**
     * Sirve para consultar el total de salarios.
     * @return total
     */
    public double consultarTotalSalarios() {
        return empleados.stream().mapToDouble(Empleado::calcularSalario).sum();
    }
}
