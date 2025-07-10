package model;

public class Contribuicao {
    private int id;
    private String titulo;
    private String descricao;
    private String ods;
    private String autor;

    public Contribuicao(String titulo, String descricao, String ods, String autor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.ods = ods;
        this.autor = autor;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getOds() { return ods; }
    public String getAutor() { return autor; }
}