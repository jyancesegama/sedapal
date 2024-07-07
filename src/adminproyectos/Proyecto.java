package adminproyectos;

import java.time.LocalDate;

public class Proyecto {
  private int idProyecto;
  private String nombreProyecto;
  private String departamento;
  private String provincia;
  private String distrito;
  private double costoTotal;
  private String etapa;
  private double avanceFisico;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private String ubigeo;
  private String contratistaConsultor;

  public Proyecto(int idProyecto, String nombreProyecto, String departamento, String provincia, String distrito,
                  double costoTotal, String etapa, double avanceFisico, LocalDate fechaInicio, LocalDate fechaFin,
                  String ubigeo, String contratistaConsultor) {
    this.idProyecto = idProyecto;
    this.nombreProyecto = nombreProyecto;
    this.departamento = departamento;
    this.provincia = provincia;
    this.distrito = distrito;
    this.costoTotal = costoTotal;
    this.etapa = etapa;
    this.avanceFisico = avanceFisico;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.ubigeo = ubigeo;
    this.contratistaConsultor = contratistaConsultor;
  }

  public int getIdProyecto() {
    return idProyecto;
  }

  public void setIdProyecto(int idProyecto) {
    this.idProyecto = idProyecto;
  }

  public String getNombreProyecto() {
    return nombreProyecto;
  }

  public void setNombreProyecto(String nombreProyecto) {
    this.nombreProyecto = nombreProyecto;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public String getDistrito() {
    return distrito;
  }

  public void setDistrito(String distrito) {
    this.distrito = distrito;
  }

  public double getCostoTotal() {
    return costoTotal;
  }

  public void setCostoTotal(double costoTotal) {
    this.costoTotal = costoTotal;
  }

  public String getEtapa() {
    return etapa;
  }

  public void setEtapa(String etapa) {
    this.etapa = etapa;
  }

  public double getAvanceFisico() {
    return avanceFisico;
  }

  public void setAvanceFisico(double avanceFisico) {
    this.avanceFisico = avanceFisico;
  }

  public LocalDate getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(LocalDate fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public LocalDate getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(LocalDate fechaFin) {
    this.fechaFin = fechaFin;
  }

  public String getUbigeo() {
    return ubigeo;
  }

  public void setUbigeo(String ubigeo) {
    this.ubigeo = ubigeo;
  }

  public String getContratistaConsultor() {
    return contratistaConsultor;
  }

  public void setContratistaConsultor(String contratistaConsultor) {
    this.contratistaConsultor = contratistaConsultor;
  }
}
