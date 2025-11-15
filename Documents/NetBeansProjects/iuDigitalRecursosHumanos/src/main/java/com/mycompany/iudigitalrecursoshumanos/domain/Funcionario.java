package com.mycompany.iudigitalrecursoshumanos.domain;

import java.time.LocalDate;

public class Funcionario {
   
    private int id;
    private int tipo_identificacion_id;
    private String numero_identificacion;
    private String nombre;
    private String apellido;
    private int estado_civil_id;
    private int genero_id;
    private String direccion;
    private long telefono;
    private LocalDate fecha_nacimiento;
    private int universidad_id;
    private int nivel_estudio_id;
    private int titulo_estudio_id;
    private String nombreTipoIdentificacion;
    private String nombreEstadoCivil;
    private String nombreGenero;
    private String nombreUniversidad;
    private String nombreNivelEstudio;
    private String nombreTituloEstudio;

    public Funcionario() {
    }

    public Funcionario(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo_identificacion_id() {
        return tipo_identificacion_id;
    }

    public void setTipo_identificacion_id(int tipo_identificacion_id) {
        this.tipo_identificacion_id = tipo_identificacion_id;
    }

    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEstado_civil_id() {
        return estado_civil_id;
    }

    public void setEstado_civil_id(int estado_civil_id) {
        this.estado_civil_id = estado_civil_id;
    }

    public int getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(int genero_id) {
        this.genero_id = genero_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getUniversidad_id() {
        return universidad_id;
    }

    public void setUniversidad_id(int universidad_id) {
        this.universidad_id = universidad_id;
    }

    public int getNivel_estudio_id() {
        return nivel_estudio_id;
    }

    public void setNivel_estudio_id(int nivel_estudio_id) {
        this.nivel_estudio_id = nivel_estudio_id;
    }

    public int getTitulo_estudio_id() {
        return titulo_estudio_id;
    }

    public void setTitulo_estudio_id(int titulo_estudio_id) {
        this.titulo_estudio_id = titulo_estudio_id;
    }

    public String getNombreTipoIdentificacion() {
        return nombreTipoIdentificacion;
    }

    public void setNombreTipoIdentificacion(String nombreTipoIdentificacion) {
        this.nombreTipoIdentificacion = nombreTipoIdentificacion;
    }

    public String getNombreEstadoCivil() {
        return nombreEstadoCivil;
    }

    public void setNombreEstadoCivil(String nombreEstadoCivil) {
        this.nombreEstadoCivil = nombreEstadoCivil;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public String getNombreUniversidad() {
        return nombreUniversidad;
    }

    public void setNombreUniversidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }

    public String getNombreNivelEstudio() {
        return nombreNivelEstudio;
    }

    public void setNombreNivelEstudio(String nombreNivelEstudio) {
        this.nombreNivelEstudio = nombreNivelEstudio;
    }

    public String getNombreTituloEstudio() {
        return nombreTituloEstudio;
    }

    public void setNombreTituloEstudio(String nombreTituloEstudio) {
        this.nombreTituloEstudio = nombreTituloEstudio;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }  
}
