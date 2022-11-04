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
                hechizos.setIdHechizos(rs.getInt("idHechizos"));
                hechizos.setNombreHechizo(rs.getString("NombreHechizos"));
                hechizos.setPotencia(rs.getInt("Potencia"));
                hechizos.setPrecision(rs.getInt("Precision"));
                hechizos.setNivelAprendizaje(rs.getInt("NivelAprendizaje"));
                hechizos.setHechizoBase(rs.getInt("idHechizoBase"));
                String nombreelemento;
                int ele = rs.getInt("Elementos_idElementos");
                try (Connection connection1 = DriverManager.getConnection(url, "root", "123456");
                     Statement stmt1 = connection1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                     ResultSet rs1 = stmt1.executeQuery(sql);) {
                    rs1.absolute(ele);
                    nombreelemento = rs1.getString("Nombre");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                hechizos.setElemento(nombreelemento);
                listaHechizos.add(hechizos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaHechizos;
    }


}
