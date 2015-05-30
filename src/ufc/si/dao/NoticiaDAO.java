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

import ufc.si.model.Noticia;


@Repository
public class NoticiaDAO {

	private Connection conn;

	@Autowired
	public NoticiaDAO(DataSource dataSource) {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void adicionar(Noticia noticia) {
		String sql = "INSERT INTO noticia(id, titulo, subtitulo, texto, autor, data_noticia, id_secao) VALUES (?, ?, ?, ?, ?, ?, ? )";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, noticia.getId());
			stmt.setString(2, noticia.getTitulo());
			stmt.setString(3, noticia.getSubtitulo());
			stmt.setString(4, noticia.getTexto());
			stmt.setString(5, noticia.getAutor());
			// stmt.setLong(6, noticia.getDataNoticia());
			stmt.setInt(7, noticia.getIdSecao());

			stmt.execute();
			stmt.close();

			System.out.println("Noticia adicionada");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public List<Noticia> getLista() {
		List<Noticia> noticias = new ArrayList<Noticia>();

		String sql = "SELECT id, titulo, subtitulo, texto, autor, data_noticia, id_secao FROM noticias";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Noticia noticia = new Noticia();
				noticia.setId(rs.getInt(1));
				noticia.setTitulo(rs.getString(2));
				noticia.setSubtitulo(rs.getString(3));
				noticia.setTexto(rs.getString(4));
				noticia.setAutor(rs.getString(5));
				noticia.setDataNoticia(rs.getDate(6));
				noticia.setIdSecao(rs.getInt(7));
				noticias.add(noticia);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return noticias;
	}

	public List<Noticia> listaNoticiasSecao(int idSecao) {
		List<Noticia> noticias = new ArrayList<Noticia>();

		String sql = "SELECT id, titulo, subtitulo, texto, autor, data_noticia, id_secao FROM noticia WHERE id_secao = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idSecao);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Noticia noticia = new Noticia();
				noticia.setId(rs.getInt("id"));
				noticia.setTitulo(rs.getString("titulo"));
				noticia.setSubtitulo(rs.getString("subtitulo"));
				noticia.setTexto(rs.getString("texto"));
				noticia.setAutor(rs.getString("autor"));
				noticia.setDataNoticia(rs.getDate("data_noticia"));
				noticia.setIdSecao(rs.getInt("id_secao"));

				noticias.add(noticia);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return noticias;
	}

	public List<Noticia> ultimasNoticias() {
		List<Noticia> noticias = new ArrayList<Noticia>();
		String sql = "SELECT id, titulo, subtitulo, texto, autor, data_noticia, id_secao "
				+ "FROM noticia  ORDER BY data_noticia DESC LIMIT 3";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Noticia noticia = new Noticia();
				noticia.setId(rs.getInt("id"));
				noticia.setTitulo(rs.getString("titulo"));
				noticia.setSubtitulo(rs.getString("subtitulo"));
				noticia.setTexto(rs.getString("texto"));
				noticia.setAutor(rs.getString("autor"));
				noticia.setDataNoticia(rs.getDate("data_noticia"));
				noticia.setIdSecao(rs.getInt("id_secao"));

				noticias.add(noticia);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return noticias;
	}

	public void excluir(Noticia noticia) {
		String sql = "DELETE FROM noticia WHERE id = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, noticia.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public Noticia getNoticia(Noticia noticia) {

		Noticia n = null;
		String sql = "SELECT id, titulo, subtitulo, texto, autor, data_noticia, id_secao "
				+ "FROM noticia  WHERE id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, noticia.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				n = new Noticia();
				n.setId(rs.getInt(1));
				n.setTitulo(rs.getString(2));
				n.setSubtitulo(rs.getString(3));
				n.setTexto(rs.getString(4));
				n.setAutor(rs.getString(5));
				n.setDataNoticia(rs.getDate(6));
				n.setIdSecao(rs.getInt(7));
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

}
