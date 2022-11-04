package beans;

public class Enemigos {
    private String nombre;
    private int ataque;
    private int experiencia;
    private String objeto;
    private float probabilidadObjeto;
    private String genero;
    private String clase;

    private int idVillano;

    public int getIdVillano() {
        return idVillano;
    }

    public void setIdVillano(int idVillano) {
        this.idVillano = idVillano;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
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
