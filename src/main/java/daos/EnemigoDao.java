package daos;

import beans.Enemigos;

import java.sql.*;
import java.util.ArrayList;
public class EnemigoDao {

    public ArrayList<Enemigos> listarEnemigos(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab8"; //modificar HR
        ArrayList<Enemigos> listaEnemigos = new ArrayList<>();
        String sql = "select * from enemigos";

        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            int clasene;
            String nombreclase;
            while (rs.next()){
                Enemigos enemigos = new Enemigos();
                enemigos.setIdVillanos(rs.getInt("Idvillanos"));
                clasene = (rs.getInt("Clase_idClase"));
                enemigos.setNombre(rs.getString("Nombre"));
                enemigos.setAtaque(rs.getInt("Ataque"));
                enemigos.setExperiencia(rs.getInt("Experiencia"));
                enemigos.setObjeto(rs.getString("Objeto"));
                enemigos.setGenero(rs.getString("Genero"));
                try (Connection connection2 = DriverManager.getConnection(url, "root", "123456");
                     Statement stmt2 = connection2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                     ResultSet rs1 = stmt2.executeQuery(sql);) {
                    rs1.absolute(clasene);
                    nombreclase = rs1.getString("Nombre");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                enemigos.setClase(nombreclase);
                listaEnemigos.add(enemigos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaEnemigos;
    }

    public void borrar(String villanoId) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/finalfantasy";
        String sql = "DELETE FROM enemigos WHERE idVillanos = ?";

        try(Connection connection = DriverManager.getConnection(url, "root","root");

            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,villanoId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void anadirEnemigo(String nombre,int ataque,int experiencia, String objeto, float probabilidadObjeto, String genero,int clase_idClase){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/finalfantasy";
        String sql= "insert into enemigos (nombre, ataque, experiencia, objeto, probabilidadObjeto, genero, clase_idClase) " +
                "values (?,?,?,?,?,?,?,?)";

        try(Connection connection = DriverManager.getConnection(url, "root", "root");
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1,nombre);
            pstmt.setInt(2,ataque);
            pstmt.setInt(3, experiencia);
            pstmt.setString(4,objeto);
            pstmt.setFloat(5,probabilidadObjeto);
            pstmt.setString(6,genero);
            pstmt.setInt(7,clase_idClase);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    public ArrayList<Enemigos> listarObjetosDeEnemigos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        ArrayList<Enemigos> listaObEn = new ArrayList<>();
        String sql = "select * from enemigos"; //modificar Query
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            int clasene;
            while (rs.next()) {

                Enemigos enemigos = new Enemigos();

                clasene = (rs.getInt(1));
                enemigos.setNombre(rs.getString(2));
                enemigos.setAtaque(rs.getInt(3));
                enemigos.setExperiencia(rs.getInt(4));
                enemigos.setObjeto(rs.getString(5));
                enemigos.setExperiencia(rs.getInt(6));
                enemigos.setGenero(rs.getString(7));

                listaObEn.add(enemigos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaObEn;
    }

    public int obtenerIdEnemigoDeEnemigo(String nombre){
        int idVillano=1;
        String url = "jdbc:mysql://localhost:3306/finalfantasy";
        String sql="select idTiposDeZombie from TiposDeZombie where nombre = ?";
        try(Connection connection = DriverManager.getConnection(url, "root", "root");
            PreparedStatement pstmt= connection.prepareStatement(sql);){
            pstmt.setString(1,nombre);

            try(ResultSet rs= pstmt.executeQuery()){
                if(rs.next()){
                    idVillano = rs.getInt(1);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return idVillano;
    }


}