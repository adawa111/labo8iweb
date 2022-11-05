package beans;

public class Hechizos {
    private String nombreHechizo;
    private int potencia;
    private int precision;
    private int nivelAprendizaje;
    private int idhechizoBase;

    private int idHechizos;

    private String elemento;

    public int getIdHechizos() {
        return idHechizos;
    }

    public void setIdHechizos(int idHechizos) {
        this.idHechizos = idHechizos;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getNombreHechizo() {
        return nombreHechizo;
    }

    public void setNombreHechizo(String nombreHechizo) {
        this.nombreHechizo = nombreHechizo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getNivelAprendizaje() {
        return nivelAprendizaje;
    }

    public void setNivelAprendizaje(int nivelAprendizaje) {
        this.nivelAprendizaje = nivelAprendizaje;
    }

    public int getIdhechizoBase() {
        return idhechizoBase;
    }

    public void setHechizoBase(int idhechizoBase) {
        this.idhechizoBase = idhechizoBase;
    }
}
