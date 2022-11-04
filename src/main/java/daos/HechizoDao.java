package daos;

import beans.Hechizos;

import java.sql.*;
import java.util.ArrayList;

public class HechizoDao {
    public ArrayList<Hechizos> listarHechizos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab8";
        ArrayList<Hechizos> listaHechizos = new ArrayList<>();
        String sql = "select * from hechizos";

        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                Hechizos hechizos = new Hechizos();
                hechizos.setNombreHechizo(rs.getString(1));
                hechizos.setPotencia(rs.getInt(2));
                hechizos.setPrecision(rs.getInt(3));
                hechizos.setNivelAprendizaje(rs.getInt(4));
                hechizos.setHechizoBase(rs.getInt(5));
                listaHechizos.add(hechizos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaHechizos;
    }
}
