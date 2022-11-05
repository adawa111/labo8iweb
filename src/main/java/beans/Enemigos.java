package beans;

public class Enemigos {
    private String nombre;
    private int ataque;
    private int experiencia;
    private String objeto;
    private float probabilidadObjeto;
    private String genero;

    private int claseidClase;

    private String clase;

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getClaseidClase() {
        return claseidClase;
    }

    public void setClaseidClase(int claseidClase) {
        this.claseidClase = claseidClase;
    }

    private int idVillanos;

    public int getIdVillano() {
        return idVillanos;
    }

    public void setIdVillano(int idVillano) {
        this.idVillanos = idVillano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public float getProbabilidadObjeto() {
        return probabilidadObjeto;
    }

    public void setProbabilidadObjeto(float probabilidadObjeto) {
        this.probabilidadObjeto = probabilidadObjeto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
