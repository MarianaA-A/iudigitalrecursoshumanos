package com.mycompany.iudigitalrecursoshumanos.dao;

import com.mycompany.iuDigitalRecursosHumanos.config.ConnectionConfig;
import com.mycompany.iudigitalrecursoshumanos.domain.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Types;

public class FuncionarioDao {
    
    private static final String GET_FUNCIONARIOS = "select f.funcionario_id,"
            + "    f.tipo_identificacion_id, f.estado_civil_id, f.genero_id, f.universidad_id, f.nivel_estudio_id, f.titulo_estudio_id,\n" 
            + "    ti.name AS tipo_identificacion,\n" 
            + "    f.numero_identificacion,\n" 
            + "    f.nombre,\n" 
            + "    f.apellido,\n" 
            + "    ec.name AS estado_civil,\n" 
            + "    g.name AS genero,\n" 
            + "    f.direccion,\n" 
            + "    f.telefono,\n" 
            + "    f.fecha_nacimiento,\n" 
            + "    u.name AS universidad,\n" 
            + "    ne.name AS nivel_estudio,\n" 
            + "    te.name AS titulo_estudio "
            + "from funcionario f "
            + "INNER JOIN tipo_identificacion ti ON f.tipo_identificacion_id = ti.tipo_identificacion_id\n" 
            + "INNER JOIN estado_civil ec ON f.estado_civil_id = ec.estado_civil_id\n" 
            + "INNER JOIN genero g ON f.genero_id = g.genero_id\n" 
            + "INNER JOIN universidad u ON f.universidad_id = u.universidad_id\n" 
            + "INNER JOIN nivel_estudio ne ON f.nivel_estudio_id = ne.nivel_estudio_id\n" 
            + "INNER JOIN titulo_estudio te ON f.titulo_estudio_id = te.titulo_estudio_id";
    
    private static final String CREATE_FUNCIONARIOS = "insert into funcionario (tipo_identificacion_id, "
            + "numero_identificacion, nombre, apellido, estado_civil_id, genero_id, direccion, telefono, "
            + "fecha_nacimiento, universidad_id, nivel_estudio_id, titulo_estudio_id) values "
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String GET_FUNCIONARIOS_BY_ID = "select f.funcionario_id,\n" 
            + "    ti.name AS tipo_identificacion,\n" 
            + "    f.numero_identificacion,\n" 
            + "    f.nombre,\n" 
            + "    f.apellido,\n" 
            + "    ec.name AS estado_civil,\n" 
            + "    g.name AS genero,\n" 
            + "    f.direccion,\n" 
            + "    f.telefono,\n" 
            + "    f.fecha_nacimiento,\n" 
            + "    u.name AS universidad,\n" 
            + "    ne.name AS nivel_estudio,\n" 
            + "    te.name AS titulo_estudio "
            + "from funcionario f "
            + "INNER JOIN tipo_identificacion ti ON f.tipo_identificacion_id = ti.tipo_identificacion_id\n" 
            + "INNER JOIN estado_civil ec ON f.estado_civil_id = ec.estado_civil_id\n" 
            + "INNER JOIN genero g ON f.genero_id = g.genero_id\n" 
            + "INNER JOIN universidad u ON f.universidad_id = u.universidad_id\n" 
            + "INNER JOIN nivel_estudio ne ON f.nivel_estudio_id = ne.nivel_estudio_id\n" 
            + "INNER JOIN titulo_estudio te ON f.titulo_estudio_id = te.titulo_estudio_id"
            + "WHERE f.funcionario_id = ?";
    
    private static final String UPDATE_FUNCIONARIOS = "update funcionario set tipo_identificacion_id = ?, "
            + "numero_identificacion = ?, nombre = ?, apellido = ?, estado_civil_id = ?, genero_id = ?,"
            + "direccion = ?, telefono = ?, fecha_nacimiento = ?, universidad_id = ?, nivel_estudio_id = ?,"
            + "titulo_estudio_id = ? where funcionario_id = ?";
    
    private static final String DELETE_FUNCIONARIOS = "delete from funcionario where funcionario_id = ?";

    public List<Funcionario> getFuncionarios()throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            
        connection = ConnectionConfig.getConnection();
        preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
        resultSet = preparedStatement.executeQuery();
        
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                
                funcionario.setId(resultSet.getInt("funcionario_id"));
                funcionario.setTipo_identificacion_id(resultSet.getInt("tipo_identificacion_id"));
                funcionario.setNombreTipoIdentificacion(resultSet.getString("tipo_identificacion"));
                funcionario.setNumero_identificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setEstado_civil_id(resultSet.getInt("estado_civil_id"));
                funcionario.setNombreEstadoCivil(resultSet.getString("estado_civil"));
                funcionario.setGenero_id(resultSet.getInt("genero_id"));
                funcionario.setNombreGenero(resultSet.getString("genero"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getLong("telefono"));
                java.sql.Date sqlDate = resultSet.getDate("fecha_nacimiento");
                funcionario.setFecha_nacimiento(sqlDate != null ? sqlDate.toLocalDate() : null);
                funcionario.setUniversidad_id(resultSet.getInt("universidad_id"));
                funcionario.setNombreUniversidad(resultSet.getString("universidad"));
                funcionario.setNivel_estudio_id(resultSet.getInt("nivel_estudio_id"));
                funcionario.setNombreNivelEstudio(resultSet.getString("nivel_estudio"));
                funcionario.setTitulo_estudio_id(resultSet.getInt("titulo_estudio_id"));
                funcionario.setNombreTituloEstudio(resultSet.getString("titulo_estudio"));
                funcionarios.add(funcionario);
            
            }
            return funcionarios;
        
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
    
    public void create(Funcionario funcionario) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_FUNCIONARIOS);
            
            preparedStatement.setInt(1, funcionario.getTipo_identificacion_id());
            preparedStatement.setString(2, funcionario.getNumero_identificacion());
            preparedStatement.setString(3, funcionario.getNombre());
            preparedStatement.setString(4, funcionario.getApellido());
            preparedStatement.setInt(5, funcionario.getEstado_civil_id());
            preparedStatement.setInt(6, funcionario.getGenero_id());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setLong(8, funcionario.getTelefono());
            java.time.LocalDate localDate = funcionario.getFecha_nacimiento();
            if (localDate != null) {
                preparedStatement.setDate(9, java.sql.Date.valueOf(localDate));
            } else {
                preparedStatement.setNull(9, java.sql.Types.DATE);
}           preparedStatement.setInt(10, funcionario.getUniversidad_id());
            preparedStatement.setInt(11, funcionario.getNivel_estudio_id());
            preparedStatement.setInt(12, funcionario.getTitulo_estudio_id()); 
        
        } finally {
            
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public Funcionario getFuncionario(int id) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;

        try {
            
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                
                funcionario = new Funcionario();
                
                funcionario.setId(resultSet.getInt("funcionario_id"));
                funcionario.setTipo_identificacion_id(resultSet.getInt("tipo_identificacion_id"));
                funcionario.setNombreTipoIdentificacion(resultSet.getString("tipo_identificacion"));
                funcionario.setNumero_identificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setEstado_civil_id(resultSet.getInt("estado_civil_id"));
                funcionario.setNombreEstadoCivil(resultSet.getString("estado_civil"));
                funcionario.setGenero_id(resultSet.getInt("genero_id"));
                funcionario.setNombreGenero(resultSet.getString("genero"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getLong("telefono"));
                java.sql.Date sqlDate = resultSet.getDate("fecha_nacimiento");
                funcionario.setFecha_nacimiento(sqlDate != null ? sqlDate.toLocalDate() : null);
                funcionario.setUniversidad_id(resultSet.getInt("universidad_id"));
                funcionario.setNombreUniversidad(resultSet.getString("universidad"));
                funcionario.setNivel_estudio_id(resultSet.getInt("nivel_estudio_id"));
                funcionario.setNombreNivelEstudio(resultSet.getString("nivel_estudio"));
                funcionario.setTitulo_estudio_id(resultSet.getInt("titulo_estudio_id"));
                funcionario.setNombreTituloEstudio(resultSet.getString("titulo_estudio"));
            }
            return funcionario;
                
            } finally {
            
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }
    
    public void updateFuncionario(int id, Funcionario funcionario) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIOS);

            preparedStatement.setInt(1, funcionario.getTipo_identificacion_id());
            preparedStatement.setString(2, funcionario.getNumero_identificacion());
            preparedStatement.setString(3, funcionario.getNombre());
            preparedStatement.setString(4, funcionario.getApellido());
            preparedStatement.setInt(5, funcionario.getEstado_civil_id());
            preparedStatement.setInt(6, funcionario.getGenero_id());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setLong(8, funcionario.getTelefono());
            java.time.LocalDate localDate = funcionario.getFecha_nacimiento();
            if (localDate != null) {
                preparedStatement.setDate(9, java.sql.Date.valueOf(localDate));
            } else {
                preparedStatement.setNull(9, java.sql.Types.DATE); // Requiere 'import java.sql.Types;'
            }
            preparedStatement.setInt(10, funcionario.getUniversidad_id());
            preparedStatement.setInt(11, funcionario.getNivel_estudio_id());
            preparedStatement.setInt(12, funcionario.getTitulo_estudio_id());
            preparedStatement.setInt(13, id);
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
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIOS);

            preparedStatement.setInt(1, id); 
            preparedStatement.executeUpdate();
            
        } finally {
            
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }        
    }
}
