package es.devirro;
// Clase principal para gestionar el sistema de nóminas
import java.util.*;

/**
 * Clase principal para gestionar el sistema de nóminas.
 * @author Irene RODRIGUEZ RODRIGUEZ
 * @version 1.0
 */
public class SistemaNominas {
    private TreeSet<Empleado> empleados;

    // Constructor
    public SistemaNominas() {
        this.empleados = new TreeSet<>();
    }

    // Métodos para las opciones del menú

    /**
     * Sirve para crear un empleado fijo.
     * @param nombre
     * @param dni
     * @param salario
     * @param bonoAnual
     */
    public void crearEmpleado(String tipo, String nombre, String dni, double salario, double bonoOduracion) {
        Empleado nuevoEmpleado;
        if (tipo.equalsIgnoreCase("fijo")) {
            nuevoEmpleado = new EmpleadoFijo(nombre, dni, salario, bonoOduracion);
        } else if (tipo.equalsIgnoreCase("eventual")) {
            nuevoEmpleado = new EmpleadoEventual(nombre, dni, salario, (int) bonoOduracion);
        } else {
            System.out.println("Tipo de empleado no válido. Debe ser 'fijo' o 'eventual'.");
            return;
        }
        if (empleados.add(nuevoEmpleado)) {
            System.out.println("Empleado creado con éxito.");
        } else {
            System.out.println("El empleado con DNI " + dni + " ya existe.");
        }
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
    public TreeSet<Empleado> listarEmpleados() {
        return new TreeSet<>(empleados);
    }

    /**
     * Sirve para listar los empleados por sueldo.
     * @return empleados
     */
    public List<Empleado> listarEmpleadosPorSueldo() {
        List<Empleado> lista = new ArrayList<>(empleados);
        lista.sort(Comparator.comparingDouble(Empleado::calcularSalario).reversed());
        return lista;
    }

    /**
     * Sirve para consultar el total de salarios.
     * @return total
     */
    public double consultarTotalSalarios() {
        return empleados.stream().mapToDouble(Empleado::calcularSalario).sum();
    }
}
