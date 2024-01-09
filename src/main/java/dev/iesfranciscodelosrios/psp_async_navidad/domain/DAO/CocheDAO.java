package dev.iesfranciscodelosrios.psp_async_navidad.domain.DAO;

import dev.iesfranciscodelosrios.psp_async_navidad.Connection.ConnectionData;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.enums.Marca;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Coche;
import dev.iesfranciscodelosrios.psp_async_navidad.interfaces.iCocheDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CocheDAO implements iCocheDAO {
    Connection conn;
    private static CocheDAO _instance;
    private  CocheDAO(){
        conn = ConnectionData.getConnection();
    }

    @Override
    public Coche getCocheByMat(String matricula) {
        String query = "select id,marca,modelo,matricula from coche where matricula = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,matricula);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Coche result = new Coche();
                result.setId(rs.getInt("id"));
                result.setMarca(Marca.valueOf(rs.getString("marca")));
                result.setModelo(rs.getString("modelo"));
                result.setMatricula(rs.getString("matricula"));
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Coche getCocheById(int id) {
        String query = "select id,marca,modelo,matricula from coche where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Coche result = new Coche();
                result.setId(rs.getInt("id"));
                result.setMarca(Marca.valueOf(rs.getString("marca")));
                result.setModelo(rs.getString("modelo"));
                result.setMatricula(rs.getString("matricula"));
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean addCoche(Coche coche) {
        String query = "Insert Into coche (id,marca,modelo,matricula) values(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,coche.getId());
            ps.setString(2,coche.getMarca().toString());
            ps.setString(3,coche.getModelo());
            ps.setString(4,coche.getMatricula());
            return ps.executeUpdate() >0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static CocheDAO getInstance(){
        if(_instance==null){
            _instance = new CocheDAO();
        }
        return _instance;
    }
}
