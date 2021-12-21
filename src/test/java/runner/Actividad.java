package runner;

public class Actividad {
private String titulo;
private String nota;

public Actividad (String titulo, String nota){
    this.titulo=titulo;
    this.nota=nota;
}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
