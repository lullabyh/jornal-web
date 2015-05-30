package ufc.si.model;

import java.util.Date;

public class Classificado {
	private int id;
	private String titulo;
	private String texto;
	private float preco;
	private String telefone;
	private float melhorOferta;
	private Date dataOferta;
	private String autorOferta;

	public Classificado() {
		// TODO Auto-generated constructor stub
	}

	public Classificado(int id, String titulo, String texto, float preco,
			String telefone, float melhorOferta, Date dataOferta,
			String autorOferta) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.preco = preco;
		this.telefone = telefone;
		this.melhorOferta = melhorOferta;
		this.dataOferta = dataOferta;
		this.autorOferta = autorOferta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public float getMelhorOferta() {
		return melhorOferta;
	}

	public void setMelhorOferta(float melhorOferta) {
		this.melhorOferta = melhorOferta;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}

	public String getAutorOferta() {
		return autorOferta;
	}

	public void setAutorOferta(String autorOferta) {
		this.autorOferta = autorOferta;
	}
}
