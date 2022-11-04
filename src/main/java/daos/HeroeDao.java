package daos;
import beans.Heroes;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class HeroeDao {
    public ArrayList<Heroes> obtenerListaHeroes(){
        ArrayList<Heroes> listaHeroes = new ArrayList<>();
        String user = "usuario";
        String pass = "password";
        String url = "jbdc:mysql://localhost:3306/FINALFANTASYLAB8?serverTimezone=America/Lima";

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();
            float exp = 0;
            int level = 0;
            ResultSet rs = stmt.executeQuery("select  * from heroes");
            while (rs.next()){
                Heroes heroe = new Heroes();
                heroe.setNombre(rs.getString("nombre"));
                heroe.setClase(rs.getString("clase"));
                heroe.setEdad(rs.getInt("edad"));
                heroe.setNivel(rs.getInt("nivel"));
                level = rs.getInt("nivel");
                if (0<level && level<=15){
                    exp = (level*level*level)*(24+((level+1)/3))/50;
                } else if (16<=level && level<=35) {
                    exp = (level*level*level)*(14+level)/50;
                } else if (36<=level && level<=100) {
                    exp = (level*level*level)*(35+((level)/2))/50;
                }
                heroe.setAtaque(rs.getInt("ataque"));
                heroe.setGenero(rs.getString("genero"));
                heroe.setExperiencia(exp);
                heroe.setPareja(rs.getInt("pareja"));

                listaHeroes.add(heroe);
            }

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return listaHeroes;
    }

}
