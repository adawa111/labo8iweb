package daos;

import beans.Objetos;

import java.sql.*;
import java.util.ArrayList;

public class ObjetoDao {
    public ArrayList<Objetos> listarObjetos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab8";
        ArrayList<Objetos> lista = new ArrayList<>();
        String sql = "select * from objetos";

        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                Objetos objetos = new Objetos();
                objetos.setNombreobjeto(rs.getString(1));
                objetos.setEfecto(rs.getString(2));
                objetos.setPeso(rs.getFloat(3));
                objetos.setUsado(rs.getBoolean(4));

                lista.add(objetos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
