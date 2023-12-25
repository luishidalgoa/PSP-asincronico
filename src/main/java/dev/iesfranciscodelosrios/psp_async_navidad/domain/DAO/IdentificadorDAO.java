package dev.iesfranciscodelosrios.psp_async_navidad.domain.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Coche;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Identificacion;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;
import dev.iesfranciscodelosrios.psp_async_navidad.interfaces.iIdentificacionDAO;

public class IdentificacionDAO implements iIdentificacionDAO {

    private Connection connection; // Necesitarás establecer la conexión a la base de datos

    // Constructor que recibe la conexión a la base de datos
    public IdentificacionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean addIdentificacion(Identificacion identificacion) {
        String query = "INSERT INTO Identificacion (id_rev, id_coche) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, identificacion.getRevision().getId());
            preparedStatement.setInt(2, identificacion.getCoche().getId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    @Override
    public Revision getIdentificacionByRevision(Revision revision) {
        String query = "SELECT * FROM Identificacion WHERE id_rev = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, revision.getId());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Identificacion identificacion = mapResultSetToIdentificacion(resultSet);
                    identificacion.setRevision(revision);
                    return identificacion.getRevision();
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }

        return null;
    }

    @Override
    public Revision getIdentificacionByCocheMat(Coche coche) {
        String query = "SELECT * FROM Identificacion WHERE id_coche = ?";

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
}
