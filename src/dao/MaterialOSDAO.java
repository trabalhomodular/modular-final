package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Material;
import model.OrdemServico;
import util.SqliteUtil;

/*
"CREATE TABLE IF NOT EXISTS material_os (" 
				+ "id_os INTEGER PRIMARY KEY,"
				+ "id_material INTEGER NOT NULL," 
				+ "quantidade INTEGER NOT NULL,"
				+ "FOREIGN KEY(id_os) REFERENCES ordem_servico(id),"
				+ "FOREIGN KEY(id_material) REFERENCES material(id))"
 */

public class MaterialOSDAO {
	private SqliteUtil sqlUtil;
	
	public MaterialOSDAO(SqliteUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
	}
	
	public boolean insereMaterialOS(OrdemServico os) throws SQLException {
		StringBuilder sql = new StringBuilder();
		boolean ret = true;
		for (Material m : os.getListaMaterial()) {
	        sql.append("INSERT INTO material_os VALUES (" + os.getId() + ", ");
	        sql.append(m.getId());
	        sql.append(", 1)");
	        ret = sqlUtil.executeSQL(sql.toString()) > 0;
		}
        
		return ret;
	}
	
	public ArrayList<Material> selectByOS(OrdemServico os) throws SQLException {
		ArrayList<Material> materiais = new ArrayList<>();
        String sql = "SELECT m.id, m.nome, m.valor FROM material_os WHERE id_os = " + os.getId();
        ResultSet rs = sqlUtil.executeQuerySQL(sql);
        while (rs.next()) {
        	materiais.add(convertResultSet(rs));
        }

        return materiais;
    }
	
	private Material convertResultSet(ResultSet rs) throws SQLException {
        Material m = new Material();
        m.setId(rs.getInt("id"));
        m.setNome(rs.getString("nome"));
        m.setValor(rs.getDouble("valor"));

        return m;
    }

}
