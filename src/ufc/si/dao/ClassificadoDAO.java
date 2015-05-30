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

import ufc.si.model.Classificado;

@Repository
public class ClassificadoDAO {
	private Connection conn;
	
	@Autowired
	public ClassificadoDAO(DataSource dataSource) {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void adicionar(Classificado classificado) {
		String sql = "INSERTE INTO classificado (id, titulo, texto, preco, telefone, melhor_oferta, data_oferta, autor_oferta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, classificado.getId());
			stmt.setString(2, classificado.getTitulo());
			stmt.setString(3, classificado.getTexto());
			stmt.setFloat(4, classificado.getPreco());
			stmt.setString(5, classificado.getTelefone());
			stmt.setFloat(6, classificado.getMelhorOferta());
			// stmt.setDate(6, classificado.getDataOferta());
			stmt.setString(8, classificado.getAutorOferta());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public List<Classificado> getLista() {
		List<Classificado> classificados = new ArrayList<Classificado>();

		String sql = "SELECT id, titulo, texto, preco, telefone, melhor_oferta, data_oferta, autor_oferta FROM classificados";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Classificado classificado = new Classificado();
				classificado.setId(rs.getInt(1));
				classificado.setTitulo(rs.getString(2));
				classificado.setTexto(rs.getString(3));
				classificado.setPreco(rs.getFloat(4));
				classificado.setTelefone(rs.getString(5));
				classificado.setMelhorOferta(rs.getFloat(6));
				classificado.setDataOferta(rs.getDate(7));
				classificado.setAutorOferta(rs.getString(8));
				classificados.add(classificado);

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return classificados;
	}

	public void excluir(Classificado classificado) {
		String sql = "DELETE FROM classificado WHERE id = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, classificado.getId());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
