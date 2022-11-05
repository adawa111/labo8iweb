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