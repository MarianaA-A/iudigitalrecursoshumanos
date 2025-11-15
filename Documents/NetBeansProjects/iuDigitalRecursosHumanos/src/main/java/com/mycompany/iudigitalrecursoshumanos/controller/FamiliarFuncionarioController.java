package com.mycompany.iudigitalrecursoshumanos.controller;

import com.mycompany.iudigitalrecursoshumanos.dao.FamiliarFuncionarioDao;
import com.mycompany.iudigitalrecursoshumanos.domain.FamiliarFuncionario;
import java.sql.SQLException;
import java.util.List;

public class FamiliarFuncionarioController {
    
    private FamiliarFuncionarioDao familiarFuncionarioDao;
    
    public FamiliarFuncionarioController() {
        familiarFuncionarioDao = new FamiliarFuncionarioDao();
    }
    
    public List<FamiliarFuncionario> getFamiliarFuncionarios() throws SQLException {
        return familiarFuncionarioDao.getFamiliarFuncionarios();
    }
    
    public void create(FamiliarFuncionario familiarFuncionario) throws SQLException {
        familiarFuncionarioDao.create(familiarFuncionario);
    }
    
    public FamiliarFuncionario getFamiliarFuncionario(int id) throws SQLException {
        return familiarFuncionarioDao.getFamiliarFuncionario(id);
    }
    
    public void updateFamiliarFuncionario(int id, FamiliarFuncionario familiarFuncionario) throws SQLException {
        familiarFuncionarioDao.updateFamiliarFuncionario(id, familiarFuncionario);
    }
    
    public void delete(int id) throws SQLException {
        familiarFuncionarioDao.delete(id);
    }
}