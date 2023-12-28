package dev.iesfranciscodelosrios.psp_async_navidad.domain.DAO;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Alineacion;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;
import dev.iesfranciscodelosrios.psp_async_navidad.interfaces.iAlineacionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AlineacionDAO implements iAlineacionDAO {
    private Connection conn;
    private static AlineacionDAO _instance;
    @Override
    public boolean addAlineacion(Alineacion alineacion) {
        String query = "INSERT INTO alineacion (id_rev, testFugas, testDireccion, amortiguacion,volante) VALUES (?, ?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            Alineacion result = new Alineacion();
            ps.setInt(1, alineacion.getRevision().getId());
            ps.setBoolean(2, alineacion.isTestFugas());
            ps.setBoolean(3, alineacion.isTestDireccion());
            ps.setBoolean(4, alineacion.isAmortiguacion());
            ps.setBoolean(5, alineacion.isVolante());
            return ps.executeUpdate() >0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Alineacion getAlineacionByRevision(Revision revision) {
        RevisionDAO revDAO = RevisionDAO.getInstance();

        String query = "select id_rev, testFugas, testDireccion,amortiguacion,volante from alineacion where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, revision.getId());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Alineacion result = new Alineacion();
                result.setRevision(revDAO.getRevisionById(rs.getInt("id_rev")));
                result.setTestFugas(rs.getBoolean("testFugas"));
                result.setTestDireccion(rs.getBoolean("testDireccion"));
                result.setAmortiguacion(rs.getBoolean("amortiguacion"));
                result.setVolante(rs.getBoolean("volante"));
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static AlineacionDAO getInstance() {
        if (_instance == null) {
            _instance = new AlineacionDAO();
        }
        return _instance;
    }
}
