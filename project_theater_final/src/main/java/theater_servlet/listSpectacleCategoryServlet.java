package theater_servlet;

import connect_db.connexionDB;
import ejbEntity.spectacle;
import ejbSession.gestionSpectacleRemote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class listSpectacleCategoryServlet extends HttpServlet {
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE = "/WEB-INF/vue/showSpectacle/listSpectacle.jsp";

    List<spectacle> categories;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {
            String category = request.getParameter("category");
            gestionSpectacleRemote gestion = new connexionDB().getConnexionManagerSpectacle();
            List<spectacle> spectacles = gestion.listAllSpectacleForCategory(category);
            request.setAttribute( "spectacles", spectacles );
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Transmission vers la page en charge de l'affichage des résultats */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}