import adminproyectos.GestorProyectos;
import adminproyectos.Proyecto;
import adminusuarios.GestorUsuarios;
import reportes.GeneradorReportes;

import java.util.List;
import java.util.Scanner;

public class Main {

    //Generando instancias de cada clase
    private static final Scanner scanner = new Scanner(System.in);
    private static final GestorProyectos GESTOR_PROYECTOS = new GestorProyectos();
    private static final GestorUsuarios GESTOR_USUARIOS = new GestorUsuarios();
    private static final GeneradorReportes GENERADOR_REPORTES = new GeneradorReportes();

    //Renderiza los metodos
    public static void main(String[] args) {
        cargarDatosDesdeCSV();
        mostrarMenuLogeo();
    }

    
    private static void cargarDatosDesdeCSV() {
        GESTOR_PROYECTOS.cargarProyectosDesdeCSV("src/resources/proyectos.csv");
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
        boolean autenticado = GESTOR_USUARIOS.autenticarUsuario(email, contraseña);

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
        int idUsuario = GESTOR_USUARIOS.obtenerNuevoIdUsuario();
        GESTOR_USUARIOS.crearUsuario(idUsuario, nombre, email,pass);

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
                    GESTOR_PROYECTOS.crearProyecto();
                    break;
                case 2:
                    // Implementar la lógica para editar un proyecto
                    System.out.print("\nIngrese el ID del Proyecto: ");
                    int id = scanner.nextInt();
                    GESTOR_PROYECTOS.editarProyecto(id);
                    break;
                case 3:
                    //ELMINAR UN PROYECTO
                    System.out.print("\nIngrese el ID del Proyecto: ");
                    int idProyecto = scanner.nextInt();
                    GESTOR_PROYECTOS.eliminarProyecto(idProyecto);
                    break;
                case 4:
                //CAMBIAR ETAPA DE UN PROYECTO
                    System.out.print("\nIngrese el ID del Proyecto: ");
                    int idProyectoEtapa = scanner.nextInt();
                    GESTOR_PROYECTOS.cambiarEtapaProyecto(idProyectoEtapa);
                    break;
                case 5:
                    // Implementar la lógica para buscar un proyecto
                    System.out.print("\nIngrese el nombre del Proyecto: ");
                    String nombreDeProyecto = scanner.nextLine();
                    GESTOR_PROYECTOS.buscarProyectos(nombreDeProyecto);    
                    break;
                case 6:
                    GESTOR_PROYECTOS.listarProyectos();
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

            List<Proyecto> proyectos = GESTOR_PROYECTOS.getProyectos();

            switch (opcion) {
                case 1:
                    GENERADOR_REPORTES.generarReporteProyectosEnProceso(proyectos);
                    break;
                case 2:
                    GENERADOR_REPORTES.generarReporteProyectosTerminados(proyectos);
                    break;
                case 3:
                    GENERADOR_REPORTES.generarReporteResumen(proyectos);;
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