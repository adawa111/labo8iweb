package Servlet;

import beans.Hechizos;
import daos.HechizoDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "CatalogoServlet", value = "/CatalogoServlet")
public class CatalogoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion")==null?"listar":request.getParameter("accion");
        RequestDispatcher view;
        HechizoDao hechi = new HechizoDao();

        switch (accion){
            case ("principal"):
                view = request.getRequestDispatcher("/index.jps");
                view.forward(request,response);
                break;
            case ("heroes"):
                view = request.getRequestDispatcher("/menuheroe.jps");
                view.forward(request,response);
                break;
            case ("catalogo"):
                view = request.getRequestDispatcher("/catalogoobjetos.jps");
                view.forward(request,response);
                break;
            case ("enemigos"):
                view = request.getRequestDispatcher("/menuenemigos.jps");
                view.forward(request,response);
                break;
            case ("borrar"):
                String spell = request.getParameter("id");
                try {
                    int spelli = Integer.parseInt(spell);
                    hechi.eliminarHechizo(spelli);
                }catch (NumberFormatException e){
                    response.sendRedirect(request.getContextPath()+ "/HechizosServlet");
                }
                break;
            case ("añadir"):
                view = request.getRequestDispatcher("/añadirhechizos.jps");
                view.forward(request,response);
                break;
            case ("listar"):
                ArrayList<Hechizos> listaHechizos = null;
                try {
                    listaHechizos = hechi.listarHechizos();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("listaHechizos",listaHechizos);
                view = request.getRequestDispatcher("/menuhechizos.jsp");
                view.forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        HechizoDao hechi1 = new HechizoDao();

        switch (accion){

            case ("añadir"):
                String nombre = request.getParameter("nombrehechizo");
                String elemento = request.getParameter("elementohechizo");
                String potencia = request.getParameter("potenciahechizo");
                String precision = request.getParameter("precisionhechizo");
                String base = request.getParameter("basehechizo");
                String nivela = request.getParameter("nivelaprendizaje");
                int elel = Integer.parseInt(elemento);
                int pot = Integer.parseInt(potencia);
                int prec = Integer.parseInt(precision);
                int bas = Integer.parseInt(base);
                int lvl = Integer.parseInt(nivela);
                hechi1.agregarHechizo(nombre,pot,prec, lvl, bas,elel);
                break;

        }
    }
    }
}
