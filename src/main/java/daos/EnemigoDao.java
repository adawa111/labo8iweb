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

        String url = "jdbc:mysql://localhost:3306/hr"; //modificar HR
        ArrayList<Enemigos> lista = new ArrayList<>();
        String sql = "select * from enemigos";

        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                Enemigos enemigos = new Enemigos();

                enemigos.setIdVillanos(rs.getInt(1));
                enemigos.setNombre(rs.getString(2));
                enemigos.setAtaque(rs.getInt(3));
                enemigos.setExperiencia(rs.getInt(4));
                enemigos.setObjeto(rs.getString(5));
                enemigos.setGenero(rs.getString(6));

                lista.add(enemigos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }


    public ArrayList<Enemigos> listarObjetosDeEnemigos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/finalfantasy";
        ArrayList<Enemigos> lista = new ArrayList<>();
        String sql = "select * from enemigos"; //modificar Query
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {

                Enemigos enemigos = new Enemigos();

                enemigos.setIdVillanos(rs.getInt(1));
                enemigos.setNombre(rs.getString(2));
                enemigos.setAtaque(rs.getInt(3));
                enemigos.setExperiencia(rs.getInt(4));
                enemigos.setObjeto(rs.getString(5));
                enemigos.setGenero(rs.getString(6));
                enemigos.setClase(Integer.parseInt(rs.getString(7)));

                lista.add(enemigos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void borrar(String villanoId) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/finalfantasy";
        String sql = "DELETE FROM enemigos WHERE idEnemigos = ?";

        try(Connection connection = DriverManager.getConnection(url, "root","root");

            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,villanoId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void anadirEnemigo(int idVillano,String nombre,int ataque,int experiencia, String objeto, float probabilidadObjeto, String genero){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/finalfantasy";
        String sql= "insert into enemigos (idVillanos, nombre, ataque, experiencia, objeto, probabilidadObjeto, genero) values (?,?,?,?,?,?,?,?)";

        try(Connection connection = DriverManager.getConnection(url, "root", "root");
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,idVillano);
            pstmt.setString(2,nombre);
            pstmt.setInt(3,ataque);
            pstmt.setInt(4, experiencia);
            pstmt.setString(5,objeto);
            pstmt.setFloat(6,probabilidadObjeto);
            pstmt.setString(7,genero);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}