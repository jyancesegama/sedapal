import adminproyectos.GestorProyectos;
import adminproyectos.Proyecto;
import adminusuarios.GestorUsuarios;
import reportes.GeneradorReportes;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final GestorProyectos gestorProyectos = new GestorProyectos();
    private static final GestorUsuarios gestorUsuarios = new GestorUsuarios();
    private static final GeneradorReportes generadorReportes = new GeneradorReportes();

    public static void main(String[] args) {
        cargarDatosDesdeCSV();
        mostrarMenuLogeo();
    }

    private static void cargarDatosDesdeCSV() {
        gestorProyectos.cargarProyectosDesdeCSV("src/resources/proyectos.csv");
        //gestorUsuarios.cargarUsuariosDesdeCSV("src/resources/usuarios.csv");
    }

    private static void mostrarMenuLogeo() {
        int opcion;
        do {
            System.out.println("Bienvenido al sistema de administración de proyectos y usuarios.");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Crear usuario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer de entrada

            switch (opcion) {
                case 1:
                    login();
                    break;
                case 2:
                    crearUsuario();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void login() {
        System.out.print("\nIngrese su correo electrónico: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su contraseña: "); // En una aplicación real, debería ocultarse la contraseña
        String contraseña = scanner.nextLine();

        // Lógica para autenticar al usuario
        boolean autenticado = gestorUsuarios.autenticarUsuario(email, contraseña);

        if (autenticado) {
            System.out.println("¡Inicio de sesión exitoso!");
            mostrarMenuPrincipal();
            // Aquí podrías mostrar el menú de opciones disponibles para el usuario autenticado
        } else {
            System.out.println("Inicio de sesión fallido. Verifique sus credenciales.");
            mostrarMenuLogeo();
        }
    }

    private static void crearUsuario() {
        System.out.print("\nIngrese el nombre del nuevo usuario: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el correo electrónico del nuevo usuario: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese la contraseña del nuevo usuario: ");
        String pass = scanner.nextLine();

        // Aquí podrías implementar más campos del usuario según tus necesidades

        // Crear el usuario y agregarlo al gestor de usuarios
        int idUsuario = gestorUsuarios.obtenerNuevoIdUsuario();
        gestorUsuarios.crearUsuario(idUsuario, nombre, email,pass);

        System.out.println("Usuario creado correctamente.");

        mostrarMenuLogeo();
    }

    private static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n*** MENÚ PRINCIPAL ***");
            System.out.println("1. Administrar Proyectos");
            System.out.println("2. Generar Reportes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer de entrada

            switch (opcion) {
                case 1:
                    mostrarMenuProyectos();
                    break;
                case 2:
                    mostrarMenuReportes();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void mostrarMenuProyectos() {
        int opcion;
        do {
            System.out.println("\n*** MENÚ DE ADMINISTRACIÓN DE PROYECTOS ***");
            System.out.println("1. Crear Proyecto");
            System.out.println("2. Editar Proyecto");
            System.out.println("3. Eliminar Proyecto");
            System.out.println("4. Cambiar Etapa de Proyecto");
            System.out.println("5. Buscar Proyecto");
            System.out.println("6. Listar Proyectos");
            System.out.println("7. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer de entrada

            switch (opcion) {
                case 1:
                    gestorProyectos.crearProyecto();
                    break;
                case 2:
                    // Implementar la lógica para editar un proyecto
                    break;
                case 3:
                    System.out.print("\nIngrese el ID del Proyecto: ");
                    int idProyecto = scanner.nextInt();
                    gestorProyectos.eliminarProyecto(idProyecto);
                    break;
                case 4:
                    System.out.print("\nIngrese el ID del Proyecto: ");
                    int idProyectoEtapa = scanner.nextInt();
                    gestorProyectos.cambiarEtapaProyecto(idProyectoEtapa);
                    break;
                case 5:
                    // Implementar la lógica para buscar un proyecto
                    break;
                case 6:
                    gestorProyectos.listarProyectos();
                    break;
                case 7:
                    return; // Volver al menú principal
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (true);
    }

    private static void mostrarMenuReportes() {
        int opcion;
        do {
            System.out.println("\n*** MENÚ DE REPORTES ***");
            System.out.println("1. Proyectos en Proceso");
            System.out.println("2. Proyectos Terminados");
            System.out.println("3. Resumen");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer de entrada

            List<Proyecto> proyectos = gestorProyectos.getProyectos();

            switch (opcion) {
                case 1:
                    generadorReportes.generarReporteProyectosEnProceso(proyectos);
                    break;
                case 2:
                    generadorReportes.generarReporteProyectosTerminados(proyectos);
                    break;
                case 3:
                    generadorReportes.generarReporteResumen(proyectos);;
                    break;
                case 4:
                    return; // Volver al menú principal
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (true);
    }
}