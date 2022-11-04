package Servlet;

import beans.Enemigos;
import daos.EnemigoDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EnemigosServlet", value = "/EnemigosServlet")
public class EnemigosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EnemigoDao enemigoDao = new EnemigoDao();
        ArrayList<Enemigos> lista = enemigoDao.listarEnemigos();

        request.setAttribute("listaEnemigos", lista);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("menuenemigos.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
