package com.mycompany.iudigitalrecursoshumanos.controller;

import com.mycompany.iudigitalrecursoshumanos.dao.FuncionarioDao;
import com.mycompany.iudigitalrecursoshumanos.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
        
    private FuncionarioDao funcionarioDao;
    
    public FuncionarioController() {
        funcionarioDao = new FuncionarioDao();
    }
    
    public List<Funcionario> getFuncionarios() throws SQLException {
        return funcionarioDao.getFuncionarios();
    }
    
    public void create(Funcionario funcionario) throws SQLException {
        funcionarioDao.create(funcionario);
    }
    
    public Funcionario getFuncionario(int id) throws SQLException {
        return funcionarioDao.getFuncionario(id);
    }
    
    public void updateFuncionario(int id, Funcionario funcionario) throws SQLException {
        funcionarioDao.updateFuncionario(id, funcionario);
    }
    
    public void delete(int id) throws SQLException {
        funcionarioDao.delete(id);
    }
}