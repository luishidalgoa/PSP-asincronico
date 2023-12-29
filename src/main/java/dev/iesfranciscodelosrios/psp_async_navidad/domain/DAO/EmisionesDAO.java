package dev.iesfranciscodelosrios.psp_async_navidad.domain.DAO;

import dev.iesfranciscodelosrios.psp_async_navidad.Connection.ConnectionData;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Emisores;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;
import dev.iesfranciscodelosrios.psp_async_navidad.interfaces.iEmisionesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmisionesDAO implements iEmisionesDAO {

    private Connection conn;
    private static EmisionesDAO _instance;

    private EmisionesDAO() throws SQLException {
        this.conn = ConnectionData.getConnection();
    }
    @Override
    public boolean addEmisiones(Emisores emisores) {
        String sql = "INSERT INTO emisores (id_rev, indice, test_emisiones) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, emisores.getRevision().getId());
            stmt.setFloat(2, emisores.getIndice());
            stmt.setBoolean(3, emisores.isTestEmisiones());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Emisores getEmisionesByRevision(Revision revision) {
        String sql = "SELECT * FROM emisores WHERE id_rev = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, revision.getId());

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    float indice = resultSet.getFloat("indice");
                    boolean testEmisiones = resultSet.getBoolean("test_emisiones");

                    return new Emisores(revision, indice, testEmisiones);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static EmisionesDAO getInstance() {
        if (_instance == null) {
            try {
                _instance = new EmisionesDAO();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return _instance;
    }
}
