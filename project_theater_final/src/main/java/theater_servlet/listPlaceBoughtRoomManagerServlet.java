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

public class listPlaceBoughtRoomManagerServlet extends HttpServlet {
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE = "/WEB-INF/vue/roomManager/listPlaceBoughtSpectacleRoomManager.jsp";

    List<spectacle> categories;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {
            int nbPlaceBought;
            int nbPlaceAvailable;
            int totalReservation = 0;
            gestionRoomManagerRemote gestionRoomManager = new connexionDB().getconnexionManagerRoomManager();
            gestionSpectacleRemote gestionSpectacle = new connexionDB().getConnexionManagerSpectacle();

            Long id_test = Long.parseLong(request.getParameter("spectacle"));
            spectacle spectacle = gestionSpectacle.findSpectacle(id_test);
            List<place> placesBought = gestionRoomManager.listAllBoughtPlaceSpectacle(spectacle);
            for (place eachPlace : placesBought)
                totalReservation = totalReservation + eachPlace.getPrice();

            List<place> placesAvailable = gestionRoomManager.listAllAvailablePlaceSpectacle(spectacle);
            nbPlaceBought = placesBought.size();
            nbPlaceAvailable = placesAvailable.size();

            request.setAttribute( "placesBought", placesBought );
            request.setAttribute( "placesAvailable", placesAvailable );
            request.setAttribute("nbPlaceBought", nbPlaceBought);
            request.setAttribute("nbPlaceAvailable", nbPlaceAvailable);
            request.setAttribute("totalReservation", totalReservation);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Transmission vers la page en charge de l'affichage des résultats */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}