package ufc.si.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PapeisDosUsuariosDAO {
	
	private Connection conn;
	
	@Autowired
	public PapeisDosUsuariosDAO(DataSource dataSource) {
		try {
			this.conn = dataSource.getConnection();
		} catch (Exception e) {
			
		}
	}
	
	public void adicionar(int idPapel, String loginUsuario){
		String sql = "insert into papeisDosUsuarios(id_role, id_usuario) values(?,?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(0, idPapel);
			stmt.setString(1, loginUsuario);
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
