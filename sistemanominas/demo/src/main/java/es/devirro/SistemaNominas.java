package es.devirro;
// Clase principal para gestionar el sistema de nóminas
import java.util.*;

public class SistemaNominas {
    private List<Empleado> empleados;

    // Constructor
    public SistemaNominas() {
        this.empleados = new ArrayList<>();
    }

    // Métodos para las opciones del menú
    public void crearEmpleadoFijo(String nombre, String dni, double salario, double bonoAnual) {
        empleados.add(new EmpleadoFijo(nombre, dni, salario, bonoAnual));
    }

    public void crearEmpleadoEventual(String nombre, String dni, double salario, int duracionContrato) {
        empleados.add(new EmpleadoEventual(nombre, dni, salario, duracionContrato));
    }

    public Empleado consultarEmpleado(String dni) {
        return empleados.stream().filter(e -> e.getDni().equals(dni)).findFirst().orElse(null);
    }

    public boolean eliminarEmpleado(String dni) {
        return empleados.removeIf(e -> e.getDni().equals(dni));
    }

    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados);
    }

    public List<Empleado> listarEmpleadosPorSueldo() {
        List<Empleado> copia = new ArrayList<>(empleados);
        copia.sort(Comparator.comparingDouble(Empleado::calcularSalario).reversed());
        return copia;
    }

    public double consultarTotalSalarios() {
        return empleados.stream().mapToDouble(Empleado::calcularSalario).sum();
    }
}
