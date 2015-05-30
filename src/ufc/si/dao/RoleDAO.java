package ufc.si.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ufc.si.model.Role;

@Repository
public class RoleDAO {

	private Connection conn;
	
	@Autowired
	public RoleDAO(DataSource dataSource) {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void adicionar(Role role) {
		String sql = "INSERT INTO role(id, role) VALUES (?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, role.getId());
			stmt.setString(2, role.getRole());

			stmt.execute();
			stmt.close();
			
			System.out.println("Role adicionada");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<Role> getLista() {
		List<Role> roles = new ArrayList<Role>();

		String sql = "SELECT id, role FROM role";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Role role = new Role();
				role.setId(rs.getInt(1));
				role.setRole(rs.getString(2));
				roles.add(role);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return roles;
	}
	
	public void excluir(Role role){
		String sql = "DELETE FROM role WHERE id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, role.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
