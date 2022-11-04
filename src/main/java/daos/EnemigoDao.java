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

                enemigos.setIdEnemigo(rs.getInt(1));
                enemigos.setNombre(rs.getString(2));
                enemigos.setAtaque(rs.getInt(3));
                enemigos.setExperiencia(rs.getInt(4));
                enemigos.setObjeto(rs.getString(5));
                enemigos.setExperiencia(rs.getInt(6));
                enemigos.setGenero(rs.getString(7));

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

        String url = "jdbc:mysql://localhost:3306/hr";
        ArrayList<Enemigos> lista = new ArrayList<>();
        String sql = "select * from enemigos"; //modificar Query
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {

                Enemigos enemigos = new Enemigos();

                enemigos.setIdEnemigo(rs.getInt(1));
                enemigos.setNombre(rs.getString(2));
                enemigos.setAtaque(rs.getInt(3));
                enemigos.setExperiencia(rs.getInt(4));
                enemigos.setObjeto(rs.getString(5));
                enemigos.setExperiencia(rs.getInt(6));
                enemigos.setGenero(rs.getString(7));

                lista.add(enemigos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}