package es.devirro;

// Clase principal con el método main
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaNominas sistema = new SistemaNominas();
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Sistema de Nóminas ---");
            System.out.println("1. Crear empleado");
            System.out.println("2. Consultar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Listar empleados");
            System.out.println("5. Listar empleados por sueldo");
            System.out.println("6. Consultar total salarios");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Tipo de empleado (fijo/eventual): ");
                    String tipo = teclado.next();
                    System.out.print("Nombre: ");
                    String nombre = teclado.next();
                    System.out.print("DNI: ");
                    String dni = teclado.next();
                    System.out.print("Salario: ");
                    double salario = teclado.nextDouble();
                    
                    if (tipo.equalsIgnoreCase("fijo")) {
                        System.out.print("Bono anual: ");
                        double bonoAnual = teclado.nextDouble();
                        sistema.crearEmpleadoFijo(nombre, dni, salario, bonoAnual);
                    } else if (tipo.equalsIgnoreCase("eventual")) {
                        System.out.print("Duración del contrato (meses): ");
                        int duracionContrato = teclado.nextInt();
                        sistema.crearEmpleadoEventual(nombre, dni, salario, duracionContrato);
                    } else {
                        System.out.println("Tipo de empleado no válido. Debe ser 'fijo' o 'eventual'.");
                    }
                    break;
                case 2:
                    System.out.print("DNI del empleado: ");
                    String dniConsulta = teclado.next();
                    Empleado empleado = sistema.consultarEmpleado(dniConsulta);
                    System.out.println(empleado != null ? empleado : "Empleado no encontrado.");
                    break;
                case 3:
                    System.out.print("DNI del empleado: ");
                    String dniEliminar = teclado.next();
                    boolean eliminado = sistema.eliminarEmpleado(dniEliminar);
                    System.out.println(eliminado ? "Empleado eliminado." : "Empleado no encontrado.");
                    break;
                case 4:
                    System.out.println("\n--- Lista de Empleados ---");
                    sistema.listarEmpleados().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("\n--- Empleados Ordenados por Sueldo ---");
                    sistema.listarEmpleadosPorSueldo().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Total de salarios: " + sistema.consultarTotalSalarios());
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);
        teclado.close();
    }
}