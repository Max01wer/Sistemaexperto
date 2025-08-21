import java.util.Scanner;

public class DiagnosticCars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n==============================================");
            System.out.println("   SISTEMA EXPERTO - DIAGNÓSTICO AUTOMÓVIL");
            System.out.println("==============================================");
            System.out.println("1. Diagnosticar un automóvil");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                String diagnostico = diagnosticar(scanner);

                System.out.println("\n==============================================");
                System.out.println("              DIAGNÓSTICO FINAL");
                System.out.println("==============================================");
                System.out.println(diagnostico);
                System.out.println("==============================================");

                System.out.print("\n¿Desea realizar otro diagnóstico? (si/no): ");
                String respuesta = scanner.nextLine().trim().toLowerCase();
                if (!respuesta.equals("si")) {
                    continuar = false;
                }

            } else if (opcion.equals("2")) {
                System.out.println("\nSaliendo del sistema... ¡Hasta pronto!");
                continuar = false;
            } else {
                System.out.println("\n⚠️ Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    public static String diagnosticar(Scanner scanner) {
        System.out.print("¿El auto arranca? (si/no): ");
        String arranca = scanner.nextLine().trim().toLowerCase();

        String diagnostico = "No se pudo determinar la causa. Revisa con un mecánico especializado.";

        if (arranca.equals("no")) {
            System.out.print("¿Las luces del tablero están encendidas? (si/no): ");
            String luces = scanner.nextLine().trim().toLowerCase();

            if (luces.equals("no")) {
                diagnostico = "Posible causa: Batería descargada.";
            } else if (luces.equals("si")) {
                diagnostico = "Posible causa: Fallo en el motor de arranque.";
            }

        } else if (arranca.equals("si")) {
            System.out.print("¿El auto se apaga al acelerar? (si/no): ");
            String seApaga = scanner.nextLine().trim().toLowerCase();

            if (seApaga.equals("si")) {
                diagnostico = "Posible causa: Problema en el suministro de combustible.";
            } else {
                System.out.print("¿Sale humo negro por el escape? (si/no): ");
                String humoNegro = scanner.nextLine().trim().toLowerCase();

                if (humoNegro.equals("si")) {
                    diagnostico = "Posible causa: Mezcla rica de combustible.";
                } else {
                    System.out.print("¿Sale humo blanco constante por el escape? (si/no): ");
                    String humoBlanco = scanner.nextLine().trim().toLowerCase();

                    if (humoBlanco.equals("si")) {
                        diagnostico = "Posible causa: Falla en la junta de culata.";
                    }
                }
            }
        }

        return diagnostico;
    }
}
