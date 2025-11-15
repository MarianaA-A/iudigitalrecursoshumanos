package com.mycompany.iudigitalrecursoshumanos.domain;

public class FamiliarFuncionario {

    private int id;
    private String nombre;
    private String apellido;
    private long telefono;
    private int parentezco_id;
    private String nombreParentesco;
    private int funcionario_id;
    private String nombreFuncionario; 

    public FamiliarFuncionario() {
    }

    public FamiliarFuncionario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getParentezco_id() {
        return parentezco_id;
    }

    public void setParentezco_id(int parentezco_id) {
        this.parentezco_id = parentezco_id;
    }
    
    public String getNombreParentesco() {
        return nombreParentesco;
    }

    public void setNombreParentesco(String nombreParentesco) {
        this.nombreParentesco = nombreParentesco;
    }

    public int getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }
    
    public String getNombreFuncionario() {
        return nombreFuncionario;
    }

    public void setNombreFuncionario(String nombreFuncionario) {
        this.nombreFuncionario = nombreFuncionario;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

}
