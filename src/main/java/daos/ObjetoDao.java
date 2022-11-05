package daos;


import beans.Objetos;

import java.sql.*;
import java.util.ArrayList;

public class ObjetoDao {
    public ArrayList<Objetos> listarObjetos() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab8";
        ArrayList<Objetos> listaObjetos = new ArrayList<>();
        String sql = "select * from objetos";
        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            int ele;
            while (rs.next()) {
                Objetos objeto = new Objetos();
                objeto.setIdObjetos(rs.getInt("idObjetos"));
                objeto.setNombreObjeto(rs.getString("NombreObjeto"));
                objeto.setEfecto(rs.getString("Efecto"));
                ele = rs.getInt("Usado");
                if (ele==1){
                    objeto.setUsado(true);
                } else if (ele==0) {
                    objeto.setUsado(false);
                }
                objeto.setPeso(rs.getFloat("Peso"));
                listaObjetos.add(objeto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaObjetos;
    }

    public void agregarHechizo(String nombre,int potencia, int accurate, int learn, int base,int elemento) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab8";
        String sql = "insert into hechizos (NombreHechizo,Potencia,Precision,NivelAprendizaje,idHechizoBase,Elementos_idElementos)";

        try (Connection conn1 = DriverManager.getConnection(url, "root", "123426");
             PreparedStatement pstmt1 = conn1.prepareStatement(sql);) {

            pstmt1.setString(1,nombre);
            pstmt1.setInt(2, potencia);
            pstmt1.setInt(3,accurate);
            pstmt1.setInt(4,learn);
            pstmt1.setInt(5,base);
            pstmt1.setInt(6,elemento);
            pstmt1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarObjeto (int idObjeto){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/lab8";
        String sql = "delete from objetos where idObjetos = ?";
        String sql1 = "delete from objetos_has_heroes where Objetos_idObjetos = ?";
        try (Connection conn5 = DriverManager.getConnection(url, "root", "123426");
             PreparedStatement pstmt5 = conn5.prepareStatement(sql1);) {

            pstmt5.setInt(1,idObjeto);
            pstmt5.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn6 = DriverManager.getConnection(url, "root", "123426");
             PreparedStatement pstmt6 = conn6.prepareStatement(sql);) {

            pstmt6.setInt(1,idObjeto);
            pstmt6.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
