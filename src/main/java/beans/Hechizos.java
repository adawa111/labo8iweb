package beans;

public class Hechizos {
    private String nombreHechizo;
    private int potencia;
    private int precision;
    private int nivelAprendizaje;
    private int hechizoBase;

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

    public int getHechizoBase() {
        return hechizoBase;
    }

    public void setHechizoBase(int hechizoBase) {
        this.hechizoBase = hechizoBase;
    }
}
