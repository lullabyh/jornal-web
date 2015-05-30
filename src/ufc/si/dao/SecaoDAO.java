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

import ufc.si.model.Secao;

@Repository
public class SecaoDAO {

	private Connection conn;

	@Autowired
	public SecaoDAO(DataSource dataSource) {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void adicionar(Secao secao) {
		String sql = "INSERT INTO secao (id, titulo, descricao) VALUES (?, ?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, secao.getId());
			stmt.setString(2, secao.getTitulo());
			stmt.setString(3, secao.getDescricao());

			stmt.execute();
			stmt.close();

			System.out.println("Secao adicionada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Secao> getLista() {
		List<Secao> secoes = new ArrayList<Secao>();

		String sql = "SELECT id, titulo, descricao FROM secao order by titulo";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Secao secao = new Secao();
				secao.setId(rs.getInt(1));
				secao.setTitulo(rs.getString(2));
				secao.setDescricao(rs.getString(3));
				secoes.add(secao);
			}

			rs.close();
			stmt.close();

			System.out.println("Listar Secao : ok!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return secoes;
	}

	public void excluir(Secao secao) {
		String sql = "DELETE FROM secao WHERE id = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, secao.getId());
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Secao getSecao(int id) {
		Secao s = null;
		String sql = "SELECT id, titulo, descricao "
				+ "FROM secao  WHERE id = ?";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				s = new Secao();
				s.setId(rs.getInt(1));
				s.setTitulo(rs.getString(2));
				s.setDescricao(rs.getString(3));
				System.out.println("DAO + ");
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
	}

}
