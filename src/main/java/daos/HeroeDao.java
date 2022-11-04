package daos;

import beans.Heroes;

import java.sql.*;
import java.util.ArrayList;

public class HeroeDao {
    public ArrayList<Heroes> listarHeroes() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab8";
        ArrayList<Heroes> lista = new ArrayList<>();
        String sql = "select * from heroes";

        try (Connection connection = DriverManager.getConnection(url, "root", "123426");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {

                Heroes heroes = new Heroes();
                heroes.setNombre(rs.getString(1));
                heroes.setEdad(rs.getInt(2));
                heroes.setGenero(rs.getString(3));
                heroes.setNivel(rs.getInt(4));
                heroes.setAtaque(rs.getInt(5));
                heroes.setPareja(rs.getInt(6));
                heroes.setExperiencia(rs.getFloat(7));
                heroes.setClase(rs.getString(8));

                lista.add(heroes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }




}
