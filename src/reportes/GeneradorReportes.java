package reportes;

import adminproyectos.Proyecto;

import java.time.LocalDate;
import java.util.List;

public class GeneradorReportes {

  public void generarReporteProyectosEnProceso(List<Proyecto> proyectos) {
    System.out.println("Reporte de Proyectos en Proceso:");

    LocalDate fechaActual = LocalDate.now();

    for (Proyecto proyecto : proyectos) {
      LocalDate fechaInicio = proyecto.getFechaInicio();
      if (fechaInicio.isBefore(fechaActual) && !proyecto.getFechaFin().isBefore(fechaActual)) {
        System.out.println("Proyecto: " + proyecto.getNombreProyecto());
        System.out.println("Fecha de Inicio: " + fechaInicio);
        System.out.println("Fecha de Fin: " + proyecto.getFechaFin());
      }
    }
  }

  public void generarReporteProyectosTerminados(List<Proyecto> proyectos) {
    System.out.println("Reporte de Proyectos Terminados:");

    LocalDate fechaActual = LocalDate.now();

    for (Proyecto proyecto : proyectos) {
      LocalDate fechaFin = proyecto.getFechaFin();

      if (fechaFin != null && fechaActual.isAfter(fechaFin)) {
        System.out.println("Proyecto: " + proyecto.getNombreProyecto());
        System.out.println("Fecha de Inicio: " + proyecto.getFechaInicio());
        System.out.println("Fecha de Fin: " + fechaFin);
      }
    }
  }

  public void generarReporteResumen(List<Proyecto> proyectos) {
    int totalProyectos = proyectos.size();
    int proyectosEnProceso = 0;
    int proyectosTerminados = 0;

    LocalDate fechaActual = LocalDate.now();

    for (Proyecto proyecto : proyectos) {
      LocalDate fechaInicio = proyecto.getFechaInicio();
      LocalDate fechaFin = proyecto.getFechaFin();

      if (
        fechaInicio != null && 
        fechaFin != null && 
        (fechaActual.isAfter(fechaInicio) || 
        fechaActual.isEqual(fechaInicio)) && 
        fechaActual.isBefore(fechaFin)) {
        proyectosEnProceso++;
      } else if (fechaFin != null && fechaActual.isAfter(fechaFin)) {
        proyectosTerminados++;
      }
    }

    System.out.println("Resumen de Proyectos:");
    System.out.println("Total de proyectos: " + totalProyectos);
    System.out.println("Proyectos en proceso: " + proyectosEnProceso);
    System.out.println("Proyectos terminados: " + proyectosTerminados);
  }
}
