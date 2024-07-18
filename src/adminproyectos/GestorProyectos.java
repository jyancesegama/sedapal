package adminproyectos;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GestorProyectos {
  private List<Proyecto> proyectos;

  public GestorProyectos() {
    this.proyectos = new ArrayList<>();
  }

  // Método para obtener el próximo ID de proyecto disponible
  private int obtenerNuevoIdProyecto() {
    if (proyectos.isEmpty()) {
      return 1;
    } else {
      return proyectos.get(proyectos.size() - 1).getIdProyecto() + 1;
    }
  }

  public void buscarProyectos (int idProyecto) {
      Proyecto proyecto = buscarProyectoPorId(idProyecto);

      if (proyecto != null) {
              System.out.println("Proyecto encontrado");
              System.out.println("Nombre: " + proyecto.getNombreProyecto());
              System.out.println("Provincia: " + proyecto.getProvincia());
              System.out.println("Distrito: " + proyecto.getDistrito());
              System.out.println("Fecha Inicio: " + proyecto.getFechaInicio());
              System.out.println("Fecha Fin: " + proyecto.getFechaFin());
              System.out.println("Etapa: " + proyecto.getEtapa());
              return;
          }

      System.out.println("Proyecto no encontrado.");
  }

  // Método para crear un nuevo proyecto
  public void crearProyecto() {

    Scanner scanner = new Scanner(System.in);

    System.out.print("\nIngrese el nombre del Proyecto: ");
    String nombreProyecto = scanner.nextLine();

    System.out.print("Ingrese el Departamento: ");
    String departamento = scanner.nextLine();

    System.out.print("Ingrese la Provincia: ");
    String provincia = scanner.nextLine();

    System.out.print("Ingrese el Distrito: ");
    String distrito = scanner.nextLine();

    System.out.print("Ingrese el Costo Total: ");
    double costoTotal = scanner.nextDouble();
    scanner.nextLine();

    System.out.print("Ingrese la Etapa: ");
    String etapa = scanner.nextLine();

    System.out.print("Ingrese el Avance Fisico: ");
    double avanceFisico = scanner.nextDouble();
    scanner.nextLine();

    System.out.print("Ingrese la Fecha de Inicio: ");
    LocalDate fechaInicio = LocalDate.now();

    System.out.print("Ingrese el Fecha Fin: ");
    LocalDate fechaFin = LocalDate.now();;

    System.out.print("Ingrese el Ubigeo: ");
    String ubigeo = scanner.nextLine();

    System.out.print("Ingrese el Contratista Consultor: ");
    String contratistaConsultor = scanner.nextLine();

    int idProyecto = obtenerNuevoIdProyecto();
    Proyecto nuevoProyecto = new Proyecto(idProyecto, nombreProyecto, departamento, provincia,
        distrito, costoTotal, etapa, avanceFisico, fechaInicio, fechaFin, ubigeo,
        contratistaConsultor);
    proyectos.add(nuevoProyecto);

    System.out.printf("Proyecto %s creado correctamente Id de proyecto: %d ", nombreProyecto, idProyecto);

  }

  // Método para editar los datos de un proyecto existente
  public void editarProyecto(int idProyecto) {
    Proyecto proyecto = buscarProyectoPorId(idProyecto);
    if (proyecto != null) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEditar el nombre del Proyecto (actual: " + proyecto.getNombreProyecto() + "): ");
        String nombreProyecto = scanner.nextLine();
        if (!nombreProyecto.isEmpty()) {
            proyecto.setNombreProyecto(nombreProyecto);
        }

        System.out.print("Editar el Departamento (actual: " + proyecto.getDepartamento() + "): ");
        String departamento = scanner.nextLine();
        if (!departamento.isEmpty()) {
            proyecto.setDepartamento(departamento);
        }

        System.out.print("Editar la Provincia (actual: " + proyecto.getProvincia() + "): ");
        String provincia = scanner.nextLine();
        if (!provincia.isEmpty()) {
            proyecto.setProvincia(provincia);
        }

        System.out.print("Editar el Distrito (actual: " + proyecto.getDistrito() + "): ");
        String distrito = scanner.nextLine();
        if (!distrito.isEmpty()) {
            proyecto.setDistrito(distrito);
        }

        System.out.print("Editar el Costo Total (actual: " + proyecto.getCostoTotal() + "): ");
        String costoTotalInput = scanner.nextLine();
        if (!costoTotalInput.isEmpty()) {
            double costoTotal = Double.parseDouble(costoTotalInput);
            proyecto.setCostoTotal(costoTotal);
        }

        System.out.print("Editar la Etapa (actual: " + proyecto.getEtapa() + "): ");
        String etapa = scanner.nextLine();
        if (!etapa.isEmpty()) {
            proyecto.setEtapa(etapa);
        }

        System.out.print("Editar el Avance Fisico (actual: " + proyecto.getAvanceFisico() + "): ");
        String avanceFisicoInput = scanner.nextLine();
        if (!avanceFisicoInput.isEmpty()) {
            double avanceFisico = Double.parseDouble(avanceFisicoInput);
            proyecto.setAvanceFisico(avanceFisico);
        }

        System.out.print("Editar la Fecha de Inicio (actual: " + proyecto.getFechaInicio() + "): ");
        String fechaInicioInput = scanner.nextLine();
        if (!fechaInicioInput.isEmpty()) {
            LocalDate fechaInicio = LocalDate.parse(fechaInicioInput);
            proyecto.setFechaInicio(fechaInicio);
        }

        System.out.print("Editar el Fecha Fin (actual: " + proyecto.getFechaFin() + "): ");
        String fechaFinInput = scanner.nextLine();
        if (!fechaFinInput.isEmpty()) {
            LocalDate fechaFin = LocalDate.parse(fechaFinInput);
            proyecto.setFechaFin(fechaFin);
        }

        System.out.print("Editar el Ubigeo (actual: " + proyecto.getUbigeo() + "): ");
        String ubigeo = scanner.nextLine();
        if (!ubigeo.isEmpty()) {
            proyecto.setUbigeo(ubigeo);
        }

        System.out.print("Editar el Contratista Consultor (actual: " + proyecto.getContratistaConsultor() + "): ");
        String contratistaConsultor = scanner.nextLine();
        if (!contratistaConsultor.isEmpty()) {
            proyecto.setContratistaConsultor(contratistaConsultor);
        }

        System.out.println("Proyecto editado correctamente.");
    } else {
        System.out.println("Proyecto no encontrado.");
    }
}


    public void cambiarEtapaProyecto(int idProyecto) {
      Proyecto proyecto = buscarProyectoPorId(idProyecto);
      if (proyecto != null) {
          Scanner scanner = new Scanner(System.in);
      
          System.out.print("La etapa actual del proyecto es: " + proyecto.getEtapa() + ". Ingrese la nueva etapa: ");
          String nuevaEtapa = scanner.nextLine();
      
          proyecto.setEtapa(nuevaEtapa);
      
          System.out.println("La etapa del proyecto ha sido actualizada correctamente a: " + nuevaEtapa);
      } else {
          System.out.println("Proyecto no encontrado.");
      }
    }

  // Método para eliminar un proyecto por su ID
  public void eliminarProyecto(int idProyecto) {
    Proyecto proyecto = buscarProyectoPorId(idProyecto);
    if (proyecto != null) {
      proyectos.remove(proyecto);
      System.out.println("Proyecto eliminado correctamente.");
    } else {
      System.out.println("Proyecto no encontrado.");
    }
  }

  // Método para buscar un proyecto por su ID
  public Proyecto buscarProyectoPorId(int idProyecto) {
    for (Proyecto proyecto : proyectos) {
      if (proyecto.getIdProyecto() == idProyecto) {
        return proyecto;
      }
    }
    return null;
  }

  // Método para listar todos los proyectos
  public void listarProyectos() {
    if (proyectos.isEmpty()) {
      System.out.println("No hay proyectos registrados.");
    } else {
      System.out.println("\nListado de Proyectos:");
      System.out.println("Id \t Nombre \t\t\t Etapa");
      for (Proyecto proyecto : proyectos) {
        System.out.printf("%s \t %s \t %s \n",proyecto.getIdProyecto(), proyecto.getNombreProyecto().substring(0,15), proyecto.getEtapa());
      }
    }
  }

  // Método para cargar proyectos desde un archivo CSV
  public void cargarProyectosDesdeCSV(String rutaArchivo) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
      String linea;

      while ((linea = reader.readLine()) != null) {
        String[] datos = linea.split(";");
        String nombreProyecto = datos[1].trim();
        String departamento = datos[2].trim();
        String provincia = datos[3].trim();
        String distrito = datos[4].trim();
        double costoTotal = Double.parseDouble(datos[5].length()>0?datos[5].trim() : "0");
        String etapa = datos[6].trim();
        double avanceFisico = Double.parseDouble(datos[7].length()>0?datos[7].trim() : "0");
        LocalDate fechaInicio = LocalDate.parse(datos[8].trim(),formatter);
        LocalDate fechaFin = LocalDate.parse(datos[9].trim(),formatter);
        String ubigeo = datos[10].trim();
        String contratistaConsultor = datos[11].trim();
        // Crear el proyecto y agregarlo a la lista
        int idProyecto = obtenerNuevoIdProyecto();
        Proyecto proyecto = new Proyecto(idProyecto, nombreProyecto, departamento, provincia,
            distrito, costoTotal, etapa, avanceFisico, fechaInicio, fechaFin, ubigeo,
            contratistaConsultor);
        proyectos.add(proyecto);
      }
      System.out.println("Proyectos cargados correctamente desde el archivo CSV.");
    } catch (IOException e) {
      System.out.println("Error al cargar proyectos desde el archivo CSV: " + e.getMessage());
    }
  }



  // Getters y setters (opcional, dependiendo de las necesidades)
  public List<Proyecto> getProyectos() {
    return proyectos;
  }

  public void setProyectos(List<Proyecto> proyectos) {
    this.proyectos = proyectos;
  }
}
