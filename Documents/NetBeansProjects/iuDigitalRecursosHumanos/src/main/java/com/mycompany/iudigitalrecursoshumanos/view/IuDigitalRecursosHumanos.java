package com.mycompany.iudigitalrecursoshumanos.view;

import com.mycompany.iudigitalrecursoshumanos.controller.FamiliarFuncionarioController;
import com.mycompany.iudigitalrecursoshumanos.controller.FuncionarioController;
import com.mycompany.iudigitalrecursoshumanos.domain.FamiliarFuncionario;
import com.mycompany.iudigitalrecursoshumanos.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class IuDigitalRecursosHumanos {

    
    public static void getFuncionarios(FuncionarioController funcionarioController) { 
        
        try {
            List<Funcionario> funcionarios = funcionarioController.getFuncionarios();
            
            if (funcionarios.isEmpty()){
                System.out.println("No hay funcionarios ingresados en la base de datos");
            } else {
                System.out.println("====================================================");
                System.out.println("============== REPORTE DE FUNCIONARIOS =============");
                System.out.println("====================================================");
                
                funcionarios.forEach(funcionario -> {
                    
                    System.out.println("\n--- DATOS DEL FUNCIONARIO ---");
                    System.out.println("id: " + funcionario.getId());
                    System.out.println("Tipo de identificación: " + funcionario.getNombreTipoIdentificacion());
                    System.out.println("Número de identificación: " + funcionario.getNumero_identificacion());
                    System.out.println("Nombre: " + funcionario.getNombre());
                    System.out.println("Apellido: " + funcionario.getApellido());
                    System.out.println("Estado civil: " + funcionario.getNombreEstadoCivil());
                    System.out.println("Género: " + funcionario.getNombreGenero());
                    System.out.println("Dirección: " + funcionario.getDireccion());
                    System.out.println("Télefono: " + funcionario.getTelefono());
                    System.out.println("Fecha de nacimiento: " + funcionario.getFecha_nacimiento());
                    System.out.println("Universidad: " + funcionario.getNombreUniversidad());
                    System.out.println("Nivel de estudio: " + funcionario.getNombreNivelEstudio());
                    System.out.println("Titulo de estudio: " + funcionario.getNombreTituloEstudio());

                    System.out.println("\n=================================================");
                    });
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error general de base de datos: " + ex.getMessage());
            }
        }
    
        public static void main(String[] args) {
            FuncionarioController funcionarioController = new FuncionarioController();
            getFuncionarios(funcionarioController);
        }
    }
        
        
