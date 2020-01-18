package theater_servlet;

import connect_db.connexionDB;
import ejbEntity.spectacle;
import ejbSession.gestionSpectacleRemote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class listSpectacleRoomManagerServlet extends HttpServlet {
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE = "/WEB-INF/vue/roomManager/listSpectacleRoomManager.jsp";
    public static final String VUE_PUBLIC = "/WEB-INF/vue/restrictAccess.jsp";

    List<spectacle> categories;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {
            /* Récupération de la session depuis la requête */
            HttpSession session = request.getSession();
            if (session.getAttribute("roomManager") == null)
                this.getServletContext().getRequestDispatcher( VUE_PUBLIC ).forward( request, response );
            gestionSpectacleRemote gestion = new connexionDB().getConnexionManagerSpectacle();
            List<spectacle> spectacles = gestion.listAllSpectacle();
            request.setAttribute( "spectacles", spectacles );
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Transmission vers la page en charge de l'affichage des résultats */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}