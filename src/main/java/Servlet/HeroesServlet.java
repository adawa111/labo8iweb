package Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import beans.Heroes;
import daos.HeroeDao;
import java.util.ArrayList;

@WebServlet(name = "HeroesServlet", value = "/HeroesServlet")
public class HeroesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HeroeDao heroeDao = new HeroeDao();
        System.out.println("]*********");
        String accion = request.getParameter("accion")==null?"heroes":request.getParameter("accion");
        RequestDispatcher view;

        switch (accion){
            case ("añadir"):

                break;
            case "heroes":
                request.setAttribute("ListaHeroes", heroeDao.listarHeroes());
                System.out.println("a");
                view = request.getRequestDispatcher("menuheroe.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
