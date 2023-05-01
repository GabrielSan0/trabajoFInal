package com.mycompany.trabajofinaldelcurso;

import java.util.Scanner;

public class TrabajoFinalDelCurso {

    public static void main(String[] args) {
        // Arreglos de clientes
        Cliente[] clientes = {
                new Cliente("77889900", "clave1"),
                new Cliente("11223344", "clave2"),
                new Cliente("55667788", "clave3"),
                new Cliente("99001122", "clave4"),
                new Cliente("33445566", "clave5")
        };

        // Solicitar DNI y contraseña al cliente
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Perú Bank");

        int intentos = 0;
        String dni = "";
        String password = "";

        while (intentos < 3) {
            System.out.print("DNI: ");
            dni = scanner.nextLine();
            System.out.print("PASSWORD: ");
            password = scanner.nextLine();

            // Validar credenciales del cliente
            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getDni().equals(dni) && c.getPassword().equals(password)) {
                    cliente = c;
                    break;
                }
            }

            if (cliente == null) {
                System.out.println("Credenciales incorrectas. Intentos restantes: " + (2 - intentos));
                intentos++;
            } else {
                break;
            }
        }

        if (intentos == 3) {
            System.out.println("Se ha alcanzado el máximo de intentos. La aplicación se cerrará.");
            return;
        }

        // Mostrar menú principal
        System.out.println("Bienvenido " + dni);
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("Elija la operación que desea realizar:");
            System.out.println("[1] Depósito");
            System.out.println("[2] Retiro");
            System.out.println("[3] Consulta de Saldo");
            System.out.println("[4] Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica para realizar depósito
                    System.out.println("Realizando depósito...");
                    break;
                case 2:
                    // Lógica para realizar retiro
                    System.out.println("Realizando retiro...");
                    break;
                case 3:
                    // Lógica para consultar saldo
                    System.out.println("Consultando saldo...");
                    break;
                case 4:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}

class Cliente {
    private String dni;
    private String password;

    public Cliente(String dni, String password) {
        this.dni = dni;
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public String getPassword() {
        return password;
    }
}
