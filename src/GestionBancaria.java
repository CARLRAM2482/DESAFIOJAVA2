import java.util.Scanner;

public class GestionBancaria {
    static Scanner scanner = new Scanner(System.in);

    // Variables de instancia para el saldo y el nombre del cliente
    private double saldo;
    private String nombreCliente;

    // Constructor que acepta el saldo inicial y el nombre del cliente
    public GestionBancaria(double saldoInicial, String nombreCliente) {
        this.saldo = saldoInicial;
        this.nombreCliente = nombreCliente;
    }

    // Método para consultar el saldo y mostrar el nombre del cliente
    public void consultarSaldo() {
        System.out.println("\nNombre del cliente: " + nombreCliente);
        System.out.println("Su saldo actual es: $" + saldo);
    }

    // Método para depositar dinero
    public void depositar() {
        System.out.print("Ingrese la cantidad a depositar: $");
        double cantidad = scanner.nextDouble();
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito realizado correctamente. Saldo actual: $" + saldo);
        } else {
            System.out.println("No se puede depositar una cantidad negativa.");
        }
    }

    // Método para retirar dinero
    public void retirar() {
        System.out.print("Ingrese la cantidad a retirar: $");
        double cantidad = scanner.nextDouble();
        if (cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro realizado correctamente. Saldo actual: $" + saldo);
        } else {
            System.out.println("Fondos insuficientes para realizar el retiro.");
        }
    }

    // Método main para ejecutar el programa
    public static void main(String[] args) {
        // Solicitar el nombre del cliente al iniciar el programa
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        // Crear una cuenta con saldo inicial de $1000 y el nombre del cliente
        GestionBancaria cuenta = new GestionBancaria(1000, nombre);
        int opcion;

        // Menú interactivo
        do {
            System.out.println("\n*** Gestión Bancaria ***");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Retirar dinero");
            System.out.println("3 - Depositar dinero");
            System.out.println("9 - Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cuenta.consultarSaldo(); // Llama al método para consultar el saldo
                    break;
                case 2:
                    cuenta.retirar(); // Llama al método para retirar dinero
                    break;
                case 3:
                    cuenta.depositar(); // Llama al método para depositar dinero
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
                    break;
            }
        } while (opcion != 9); // El bucle continúa hasta que el usuario elija la opción de salir
    }
}
