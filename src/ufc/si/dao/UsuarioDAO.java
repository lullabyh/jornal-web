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

import ufc.si.model.Usuario;
@Repository
public class UsuarioDAO {

	private Connection conn;
	
	@Autowired
	public UsuarioDAO(DataSource dataSource) {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void adicionar(Usuario usuario) {
		String sql = "INSERT INTO usuario(nome, email, login, senha) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getLogin());
			stmt.setString(4, usuario.getSenha());

			stmt.execute();
			stmt.close();

			System.out.println("Usuario Adicionado");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Usuario> getLista() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		String sql = "SELECT login, senha, nome, email FROM usuario ";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString(1));
				usuario.setSenha(rs.getString(2));
				usuario.setNome(rs.getString(3));
				usuario.setEmail(rs.getString(4));
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuarios;
	}

	public void excluir(Usuario usuario) {
		String sql = "DELETE FROM usuario WHERE login = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
