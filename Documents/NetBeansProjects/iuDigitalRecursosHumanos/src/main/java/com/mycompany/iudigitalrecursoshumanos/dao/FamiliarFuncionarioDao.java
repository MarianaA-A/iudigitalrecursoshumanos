package com.mycompany.iudigitalrecursoshumanos.dao;

import com.mycompany.iuDigitalRecursosHumanos.config.ConnectionConfig;
import com.mycompany.iudigitalrecursoshumanos.domain.FamiliarFuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FamiliarFuncionarioDao {
    
    private static final String GET_FAMILIARFUNCIONARIOS = "select ff.familiar_id,\n" 
            + "    ff.nombre AS nombre_familiar,\n" 
            + "    ff.apellido AS apellido_familiar,\n" 
            + "    ff.telefono,\n"
            + "    ff.parentezco_id, ff.funcionario_id,"
            + "    p.name AS parentezco,\n" 
            + "    f.nombre AS nombre_funcionario,\n" 
            + "    f.apellido AS apellido_funcionario\n" 
            + "FROM\n" 
            + "    familiarFuncionario ff\n" 
            + "INNER JOIN parentezco p ON ff.parentezco_id = p.parentezco_id\n" 
            + "INNER JOIN funcionario f ON ff.funcionario_id = f.funcionario_id";
    
    private static final String CREATE_FAMILIARFUNCIONARIOS = "insert into familiarFuncionario "
            + "(nombre, apellido, telefono, parentezco_id, funcionario_id) values "
            + "(?, ?, ?, ?, ?)";
    
    private static final String GET_FAMILIARFUNCIONARIOS_BY_ID = "select ff.familiar_id,\n" 
            + "    ff.nombre AS nombre_familiar,\n" 
            + "    ff.apellido AS apellido_familiar,\n" 
            + "    ff.telefono,\n" 
            + "    ff.parentezco_id, ff.funcionario_id,"
            + "    p.name AS parentezco,\n" 
            + "    f.nombre AS nombre_funcionario,\n" 
            + "    f.apellido AS apellido_funcionario\n" 
            + "FROM\n" 
            + "    familiarFuncionario ff\n" 
            + "INNER JOIN parentezco p ON ff.parentezco_id = p.parentezco_id\n" 
            + "INNER JOIN funcionario f ON ff.funcionario_id = f.funcionario_id"
            + "WHERE ff.familiar_id = ?";
    
    private static final String UPDATE_FAMILIARFUNCIONARIOS = "update familiarFuncionario set nombre = ?, "
            + "apellido = ?, telefono = ?, parentezco_id = ?, funcionario_id = ? where familiar_id = ?";
    
    private static final String DELETE_FAMILIARFUNCIONARIOS = "delete from familiarFuncionario where familiar_id = ?";

    public List<FamiliarFuncionario> getFamiliarFuncionarios()throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<FamiliarFuncionario> familiarFuncionarios = new ArrayList<>();
        
        try {
            
        connection = ConnectionConfig.getConnection();
        preparedStatement = connection.prepareStatement(GET_FAMILIARFUNCIONARIOS);
        resultSet = preparedStatement.executeQuery();
        
            while (resultSet.next()) {
                FamiliarFuncionario familiarFuncionario = new FamiliarFuncionario();
                
                familiarFuncionario.setId(resultSet.getInt("familiar_id"));
                familiarFuncionario.setNombre(resultSet.getString("nombre_familiar"));
                familiarFuncionario.setApellido(resultSet.getString("apellido_familiar"));
                familiarFuncionario.setTelefono(resultSet.getLong("telefono"));
                familiarFuncionario.setParentezco_id(resultSet.getInt("parentezco_id"));
                familiarFuncionario.setFuncionario_id(resultSet.getInt("funcionario_id"));
                familiarFuncionario.setNombreParentesco(resultSet.getString("parentezco"));
                familiarFuncionario.setNombreFuncionario(resultSet.getString("nombre_funcionario"));
                familiarFuncionarios.add(familiarFuncionario);
            
            }
            return familiarFuncionarios;
        
        } finally {
            
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
        }   
    }
    
    public void create(FamiliarFuncionario familiarFuncionario) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_FAMILIARFUNCIONARIOS);
            
            preparedStatement.setString(1, familiarFuncionario.getNombre());
            preparedStatement.setString(2, familiarFuncionario.getApellido());
            preparedStatement.setLong(3, familiarFuncionario.getTelefono());
            preparedStatement.setInt(4, familiarFuncionario.getParentezco_id());
            preparedStatement.setInt(5, familiarFuncionario.getFuncionario_id());
            preparedStatement.executeUpdate();
            
        } finally {
            
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public FamiliarFuncionario getFamiliarFuncionario(int id) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        FamiliarFuncionario familiarFuncionario = null;

        try {
            
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(GET_FAMILIARFUNCIONARIOS_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                
                familiarFuncionario = new FamiliarFuncionario();
                
                familiarFuncionario.setId(resultSet.getInt("familiar_id"));
                familiarFuncionario.setNombre(resultSet.getString("nombre_familiar"));
                familiarFuncionario.setApellido(resultSet.getString("apellido_familiar"));
                familiarFuncionario.setTelefono(resultSet.getLong("telefono"));
                familiarFuncionario.setParentezco_id(resultSet.getInt("parentezco_id"));
                familiarFuncionario.setFuncionario_id(resultSet.getInt("funcionario_id"));
                familiarFuncionario.setNombreParentesco(resultSet.getString("parentezco"));
                familiarFuncionario.setNombreFuncionario(resultSet.getString("nombre_funcionario"));
            }
            return familiarFuncionario;
                
            } finally {
            
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }
    
    public void updateFamiliarFuncionario(int id, FamiliarFuncionario familiarFuncionario) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FAMILIARFUNCIONARIOS);

            preparedStatement.setString(1, familiarFuncionario.getNombre());
            preparedStatement.setString(2, familiarFuncionario.getApellido());
            preparedStatement.setLong(3, familiarFuncionario.getTelefono());
            preparedStatement.setInt(4, familiarFuncionario.getParentezco_id());
            preparedStatement.setInt(5, familiarFuncionario.getFuncionario_id());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();

        } finally {

            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
            }
        }
    
        public void delete(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FAMILIARFUNCIONARIOS);

            preparedStatement.setInt(1, id); 
            preparedStatement.executeUpdate();
            
        } finally {
            
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }        
    }
}
