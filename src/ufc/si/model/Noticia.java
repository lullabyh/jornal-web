package ufc.si.model;

import java.util.Date;

public class Noticia {
	private int id;
	private String titulo;
	private String subtitulo;
	private String texto;
	private String autor;
	private Date dataNoticia;
	private int idSecao;

	public Noticia() {
		// TODO Auto-generated constructor stub
	}

	public Noticia(int id, String titulo, String subtitulo, String texto,
			String autor, Date dataNoticia, int idSecao) {
		this.id = id;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.texto = texto;
		this.autor = autor;
		this.dataNoticia = dataNoticia;
		this.idSecao = idSecao;
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

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia = dataNoticia;
	}
	public int getIdSecao() {
		return idSecao;
	}
	public void setIdSecao(int idSecao) {
		this.idSecao = idSecao;
	}
}
