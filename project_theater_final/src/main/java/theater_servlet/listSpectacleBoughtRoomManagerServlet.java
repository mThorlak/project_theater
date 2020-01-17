package theater_servlet;

import connect_db.connexionDB;
import ejbEntity.place;
import ejbEntity.spectacle;
import ejbSession.gestionRoomManagerRemote;
import ejbSession.gestionSpectacleRemote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class listSpectacleBoughtRoomManagerServlet extends HttpServlet {
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE = "/WEB-INF/vue/roomManager/listPlaceBoughtSpectacleRoomManager.jsp";

    List<spectacle> categories;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {
            gestionRoomManagerRemote gestionRoomManager = new connexionDB().getconnexionManagerRoomManager();
            gestionSpectacleRemote gestionSpectacle = new connexionDB().getConnexionManagerSpectacle();
            Long id_test = Long.parseLong(request.getParameter("spectacle"));
            spectacle spectacle = gestionSpectacle.findSpectacle(id_test);
            List<place> places = gestionRoomManager.listAllBoughtPlaceSpectacle(spectacle);
            System.out.println(spectacle);
            System.out.println(places);
            request.setAttribute( "places", places );
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Transmission vers la page en charge de l'affichage des résultats */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}