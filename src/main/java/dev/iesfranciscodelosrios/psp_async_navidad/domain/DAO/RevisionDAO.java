package dev.iesfranciscodelosrios.psp_async_navidad.domain.DAO;

import dev.iesfranciscodelosrios.psp_async_navidad.Connection.ConnectionData;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Coche;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;
import dev.iesfranciscodelosrios.psp_async_navidad.interfaces.iRevisionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RevisionDAO implements iRevisionDAO {
    private static RevisionDAO _instance;
    private static Connection conn;
    private RevisionDAO(){
        conn = ConnectionData.getConnection();
    }

    @Override
    public boolean addRevision(Revision revision) {
        String query = "INSERT INTO revision (fecha, estado) VALUES (?, ?)";

        try {
            // Segundo parámetro de getGeneratedKeys indica que se desea recuperar la columna "id"
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, new java.sql.Date(new Date().getTime()));
            ps.setBoolean(2, false);
            ps.executeUpdate();

            // Obtener las claves generadas después de la inserción
            ResultSet generatedKeys = ps.getGeneratedKeys();

            if (generatedKeys.next()) {
                // Recuperar el ID generado
                int idGenerado = generatedKeys.getInt(1);

                // Asignar el ID generado a la revisión
                revision.setId(idGenerado);

                // Luego, puedes continuar con la inserción en otras tablas
                IdentificacionDAO.getInstance().addIdentificacion(revision.getIdentificacion());
                InteriorDAO.getInstance().addInterior(revision.getInterior());
                ExteriorDAO.getInstance().addExterior(revision.getExterior());
                AlineacionDAO.getInstance().addAlineacion(revision.getAlineacion());
                EmisionesDAO.getInstance().addEmisiones(revision.getEmisores());

                return true;
            } else {
                // No se pudo recuperar el ID generado
                throw new SQLException("No se pudo obtener el ID generado después de la inserción en la tabla 'revision'");
            }

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

    public List<Revision> getAllRevisions(){
        String query = "select id,fecha,estado from revision";
        List<Revision> revisiones = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Revision result = new Revision();
                result.setId(rs.getInt("id"));
                result.setFecha(rs.getDate("fecha"));
                result.setEstado(rs.getBoolean("estado"));
                result = getEtapas(result);
                revisiones.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return !revisiones.isEmpty()?revisiones:null;
    }

    public static RevisionDAO getInstance(){
        if(_instance == null){
            _instance = new RevisionDAO();
        }
        return _instance;
    }

    public Revision getEtapas(Revision revision){
        revision.setIdentificacion(IdentificacionDAO.getInstance().getIdentificacionByRevision(revision));
        revision.setExterior(ExteriorDAO.getInstance().getExteriorByRevision(revision));
        revision.setInterior(InteriorDAO.getInstance().getInteriorByRevision(revision));
        revision.setAlineacion(AlineacionDAO.getInstance().getAlineacionByRevision(revision));
        revision.setEmisores(EmisionesDAO.getInstance().getEmisionesByRevision(revision));
        return revision;
    }
}
