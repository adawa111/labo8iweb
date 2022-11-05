package Servlet;

import beans.Enemigos;
import daos.EnemigoDao;
import daos.HeroeDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EnemigosServlet", value = "/EnemigosServlet")
public class EnemigosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");

        EnemigoDao enemigoDao = new EnemigoDao();
        RequestDispatcher requestDispatcher;

        String villanoId;
        Enemigos enemigos;

        switch (action) {
            case "listar":
                request.setAttribute("listaEnemigos", enemigoDao.listarEnemigos());

                requestDispatcher = request.getRequestDispatcher("menuenemigos.jsp");
                requestDispatcher.forward(request, response);
                break;

            case "borrar":
                villanoId = request.getParameter("id");


                response.sendRedirect(request.getContextPath() + "/EnemigoServlet");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}