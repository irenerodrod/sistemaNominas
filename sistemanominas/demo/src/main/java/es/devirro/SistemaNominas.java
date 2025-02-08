package es.devirro;
// Clase principal para gestionar el sistema de nóminas
import java.util.*;

/**
 * Clase principal para gestionar el sistema de nóminas.
 * @author Irene RODRIGUEZ RODRIGUEZ
 * @version 1.0
 */
public class SistemaNominas {
    private Map<String, Empleado> empleados;

    // Constructor
    public SistemaNominas() {
        this.empleados = new TreeMap<>();
    }

    // Métodos para las opciones del menú

    /**
     * Sirve para crear un empleado fijo.
     * @param tipo
     * @param nombre
     * @param dni
     * @param salario
     * @param bonoAnual
     */
    public void crearEmpleado(String tipo, String nombre, String dni, double salario, double bonoAnual) {
        Empleado nuevoEmpleado;
        if (tipo.equalsIgnoreCase("fijo")) {
            nuevoEmpleado = new EmpleadoFijo(nombre, dni, salario, bonoAnual);
        } else if (tipo.equalsIgnoreCase("eventual")) {
            nuevoEmpleado = new EmpleadoEventual(nombre, dni, salario, (int) bonoAnual);
        } else {
            System.out.println("Tipo de empleado no válido. Debe ser 'fijo' o 'eventual'.");
            return;
        }

        if (empleados.containsKey(dni)) {
            System.out.println("El empleado con DNI " + dni + " ya existe.");
        } else {
            empleados.put(dni, nuevoEmpleado);
            System.out.println("Empleado creado con éxito.");
        }
    }

    /**
     * Sirve para consultar un empleado.
     * @param dni
     * @return
     */
    public Empleado consultarEmpleado(String dni) {
        return empleados.get(dni);
    }

    /**
     * Sirve para eliminar un empleado.
     * @param dni
     * @return
     */
    public boolean eliminarEmpleado(String dni) {
        if (empleados.containsKey(dni)) {
            empleados.remove(dni);
            return true;
        }
        return false;
    }

    /**
     * Sirve para listar los empleados.
     * @return empleados
     */
    public Collection<Empleado> listarEmpleados() {
        return empleados.values();
    }

    /**
     * Sirve para listar los empleados por sueldo.
     * @return empleados
     */
    public List<Empleado> listarEmpleadosPorSueldo() {
        List<Empleado> lista = new ArrayList<>(empleados.values());
        lista.sort(Comparator.comparingDouble(Empleado::calcularSalario).reversed());
        return lista;
    }

    /**
     * Sirve para consultar el total de salarios.
     * @return total
     */
    public double consultarTotalSalarios() {
        return empleados.values().stream().mapToDouble(Empleado::calcularSalario).sum();
    }
}