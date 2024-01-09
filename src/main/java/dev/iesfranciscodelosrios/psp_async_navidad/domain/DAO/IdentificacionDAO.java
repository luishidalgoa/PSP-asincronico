package dev.iesfranciscodelosrios.psp_async_navidad.domain.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.iesfranciscodelosrios.psp_async_navidad.Connection.ConnectionData;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Coche;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Identificacion;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;
import dev.iesfranciscodelosrios.psp_async_navidad.interfaces.iIdentificacionDAO;

public class IdentificacionDAO implements iIdentificacionDAO {

    private Connection connection; // Necesitarás establecer la conexión a la base de datos
    private static IdentificacionDAO _instance;

    // Constructor que recibe la conexión a la base de datos
    private IdentificacionDAO() {
        this.connection = ConnectionData.getConnection();
    }

    @Override
    public boolean addIdentificacion(Identificacion identificacion) {
        String query = "INSERT INTO Identificacion (id_rev, matricula) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, identificacion.getRevision().getId());
            preparedStatement.setString(2, identificacion.getCoche().getMatricula());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    @Override
    public Identificacion getIdentificacionByRevision(Revision revision) {
        String query = "SELECT * FROM Identificacion WHERE id_rev = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, revision.getId());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Identificacion identificacion = new Identificacion();
                    identificacion.setRevision(revision);
                    identificacion.setContador(0);
                    identificacion.setCoche(CocheDAO.getInstance().getCocheByMat(resultSet.getString("matricula")));
                    return identificacion;
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }

        return null;
    }

    @Override
    public Revision getIdentificacionByCocheMat(Coche coche) {
        String query = "SELECT * FROM Identificacion WHERE matricula = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, coche.getId());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Identificacion identificacion = mapResultSetToIdentificacion(resultSet);
                    identificacion.setCoche(coche);
                    return identificacion.getRevision();
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }

        return null;
    }

    // Método para manejar excepciones de SQL
    private void handleSQLException(SQLException e) {
        e.printStackTrace(); // Manejo adecuado de la excepción en una aplicación real
    }

    // Método para mapear un ResultSet a un objeto Identificacion
    private Identificacion mapResultSetToIdentificacion(ResultSet resultSet) throws SQLException {
        Identificacion identificacion = new Identificacion();
        identificacion.setRevision(new Revision(resultSet.getInt("id_rev")));
        identificacion.setCoche(new Coche(resultSet.getInt("id_coche")));

        return identificacion;
    }

    public static IdentificacionDAO getInstance(){
        if(_instance == null){
            _instance = new IdentificacionDAO();
        }
        return _instance;
    }
}