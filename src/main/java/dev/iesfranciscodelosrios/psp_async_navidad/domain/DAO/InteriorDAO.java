package dev.iesfranciscodelosrios.psp_async_navidad.domain.DAO;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Interior;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;
import dev.iesfranciscodelosrios.psp_async_navidad.interfaces.iInteriorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InteriorDAO implements iInteriorDAO {

    private Connection conn;

    public InteriorDAO(Connection conn) throws SQLException {
        this.conn = conn;
    }

    public InteriorDAO() throws SQLException {
        this.conn = Connect.getConnect();
    }

    @Override
    public boolean addInterior(Interior interior) {
        String sql = "INSERT INTO interior (id_rev, antirobo, antideslizante, frenado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, interior.getRevision().getId());
            stmt.setBoolean(2, interior.isAntirobo());
            stmt.setBoolean(3, interior.isAntideslizante());
            stmt.setBoolean(4, interior.isFrenado());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Revision getInteriorByRevision(Revision revision) {
        String sql = "SELECT * FROM interior WHERE id_rev = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, revision.getId());

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    boolean antirobo = resultSet.getBoolean("antirobo");
                    boolean antideslizante = resultSet.getBoolean("antideslizante");
                    boolean frenado = resultSet.getBoolean("frenado");

                    return new Interior(revision, antirobo, antideslizante, frenado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
