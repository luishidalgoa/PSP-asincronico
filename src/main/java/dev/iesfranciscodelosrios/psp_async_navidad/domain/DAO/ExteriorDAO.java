package dev.iesfranciscodelosrios.psp_async_navidad.domain.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.iesfranciscodelosrios.psp_async_navidad.Connection.ConnectionData;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.enums.Neumaticos;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Exterior;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;
import dev.iesfranciscodelosrios.psp_async_navidad.interfaces.iExteriorDAO;

public class ExteriorDAO implements iExteriorDAO {

    private static Connection connection; // Necesitarás establecer la conexión a la base de datos
    private static ExteriorDAO _instance;

    // Constructor que recibe la conexión a la base de datos
    private ExteriorDAO(Connection connection) {
        this.connection = ConnectionData.getConnection();
    }

    @Override
    public boolean addExterior(Exterior exterior) {
        String query = "INSERT INTO Exterior (id_rev, neumaticos, testLimpiaParabrisas, testLuces, testCinturones, testDeposito) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, exterior.getRevision().getId());
            preparedStatement.setString(2, exterior.getNeumaticos().toString());
            preparedStatement.setBoolean(3, exterior.isTestLimpiaParabrisas());
            preparedStatement.setBoolean(4, exterior.isTestLuces());
            preparedStatement.setBoolean(5, exterior.isTestCinturones());
            preparedStatement.setBoolean(6, exterior.isTestDeposito());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    @Override
    public Revision getExteriorByRevision(Revision revision) {
        String query = "SELECT * FROM Exterior WHERE id_rev = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, revision.getId());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Exterior exterior = mapResultSetToExterior(resultSet);
                    exterior.setRevision(revision);
                    return exterior.getRevision();
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }

        return null;
    }

    // Método para cerrar la conexión (debería ser llamado al finalizar el uso del DAO)
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    // Método para manejar excepciones de SQL
    private void handleSQLException(SQLException e) {
        e.printStackTrace(); // Manejo adecuado de la excepción en una aplicación real
    }

    // Método para mapear un ResultSet a un objeto Exterior
    private Exterior mapResultSetToExterior(ResultSet resultSet) throws SQLException {
        Exterior exterior = new Exterior();
        exterior.setRevision(new Revision(resultSet.getInt("id_rev")));
        exterior.setNeumaticos(Neumaticos.valueOf(resultSet.getString("neumaticos")));
        exterior.setTestLimpiaParabrisas(resultSet.getBoolean("testLimpiaParabrisas"));
        exterior.setTestLuces(resultSet.getBoolean("testLuces"));
        exterior.setTestCinturones(resultSet.getBoolean("testCinturones"));
        exterior.setTestDeposito(resultSet.getBoolean("testDeposito"));

        return exterior;
    }


    public static ExteriorDAO getInstance() {

        if (_instance == null) {
            _instance = new ExteriorDAO(connection);
        }

        return _instance;
    }
}
