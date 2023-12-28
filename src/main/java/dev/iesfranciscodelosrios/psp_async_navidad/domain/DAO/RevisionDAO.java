package dev.iesfranciscodelosrios.psp_async_navidad.domain.DAO;

import dev.iesfranciscodelosrios.psp_async_navidad.Connection.ConnectionData;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Coche;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;
import dev.iesfranciscodelosrios.psp_async_navidad.interfaces.iRevisionDAO;

import java.sql.*;
import java.util.Date;

public class RevisionDAO implements iRevisionDAO {
    private static RevisionDAO _instance;
    private Connection conn;
    private RevisionDAO(){
        conn = ConnectionData.getConnection();
    }

    @Override
    public boolean addRevision(Revision revision) {
        String query = "INSERT INTO revision (fecha, estado) VALUES (?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            Revision result = new Revision();
            ps.setDate(1, new java.sql.Date(new Date().getTime()));
            ps.setBoolean(2, false);
            return ps.executeUpdate() >0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Revision getRevisionById(int id) {
        String query = "select id,fecha,estado from revision where id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Revision result = new Revision();
                result.setId(rs.getInt("id"));
                result.setFecha(rs.getDate("fecha"));
                result.setEstado(rs.getBoolean("estado"));
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Revision getRevisionByCocheMat(Coche coche) {
        String query = "select id,fecha,estado from revision where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, coche.getId());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Revision result = new Revision();
                result.setId(rs.getInt("id"));
                result.setFecha(rs.getDate("fecha"));
                result.setEstado(rs.getBoolean("estado"));
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static RevisionDAO getInstance(){
        if(_instance == null){
            _instance = new RevisionDAO();
        }
        return _instance;
    }
}
