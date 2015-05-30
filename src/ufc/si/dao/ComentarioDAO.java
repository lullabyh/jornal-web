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

import ufc.si.model.Comentario;

@Repository
public class ComentarioDAO {
	private Connection conn;

	@Autowired
	public ComentarioDAO(DataSource dataSource) {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void adicionar(Comentario comentario) {
		String sql = "INSERT INTO comentario(id, noticia, autor, texto) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, comentario.getId());
			stmt.setInt(2, comentario.getNoticia());
			stmt.setString(3, comentario.getAutor());
			stmt.setString(4, comentario.getTexto());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Comentario> getLista() {
		List<Comentario> comentarios = new ArrayList<Comentario>();

		String sql = "SELECT id, noticia, autor, texto FROM comentario";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Comentario comentario = new Comentario();
				comentario.setId(rs.getInt(1));
				comentario.setNoticia(rs.getInt(2));
				comentario.setAutor(rs.getString(3));
				comentario.setTexto(rs.getString(4));
				comentarios.add(comentario);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return comentarios;
	}
	
	public void excluir(Comentario comentario){
		String sql = "DELETE FROM comentario WHERE id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, comentario.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
