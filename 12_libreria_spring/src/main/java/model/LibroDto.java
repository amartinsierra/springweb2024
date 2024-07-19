package model;

public class LibroDto {
	private int isbn;
	private String titulo;
	private String autor;
	private double precio;
	private int paginas;
	private TemaDto temaDto;
	public LibroDto(int isbn, String titulo, String autor, double precio, int paginas, TemaDto temaDto) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		this.paginas = paginas;
		this.temaDto = temaDto;
	}
	public LibroDto() {
		
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public TemaDto getTemaDto() {
		return temaDto;
	}
	public void setTemaDto(TemaDto temaDto) {
		this.temaDto = temaDto;
	}
	
}
