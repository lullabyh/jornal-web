package ufc.si.model;

public class Comentario {
	private int id;
	private int noticia;
	private String autor;
	private String texto;
	
	public Comentario() {
		// TODO Auto-generated constructor stub
	}
	
	public Comentario(int id, int noticia, String autor, String texto){
		this.id = id;
		this.noticia = noticia;
		this.autor = autor;
		this.texto = texto;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoticia() {
		return noticia;
	}
	public void setNoticia(int noticia) {
		this.noticia = noticia;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
