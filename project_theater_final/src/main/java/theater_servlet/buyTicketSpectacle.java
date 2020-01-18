package theater_servlet;

import connect_db.connexionDB;
import ejbEntity.place;
import ejbEntity.spectacle;
import ejbSession.gestionRoomManagerRemote;
import ejbSession.gestionSpectacleRemote;
import theater_forms.buyTicketForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class buyTicketSpectacle extends HttpServlet {
    public static final String ATTRIBUT_SPECTACLE = "spectacle";
    public static final String ATTRIBUT_FORM_BUY_TICKET = "buyTicketForm";
    public static final String VUE = "/WEB-INF/vue/showSpectacle/buyTicketSpectacle.jsp";

    private gestionRoomManagerRemote gestionRoomManager;
    private int nbPlaceAvailable;
    private int nbPlacePrice55;
    private int nbPlacePrice40;
    private int nbPlacePrice20;

    private spectacle spectacle;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {
            this.gestionRoomManager = new connexionDB().getconnexionManagerRoomManager();
            // On cherche le spectacle selon l'id passé et on le renvoi dans la vue
            spectacle spectacle;
            Long idParam = Long.parseLong(request.getParameter( "spectacle" ));
            gestionSpectacleRemote gestion = new connexionDB().getConnexionManagerSpectacle();
            spectacle = gestion.findSpectacle(idParam);

            this.spectacle = spectacle;
            this.nbPlaceAvailable = this.gestionRoomManager.listAllAvailablePlaceSpectacle(spectacle).size();
            this.nbPlacePrice20 = this.gestionRoomManager.listAllAvailablePlace20Spectacle(spectacle).size();
            this.nbPlacePrice40 = this.gestionRoomManager.listAllAvailablePlace40Spectacle(spectacle).size();
            this.nbPlacePrice55 = this.gestionRoomManager.listAllAvailablePlace55Spectacle(spectacle).size();

            request.setAttribute( "spectacle", spectacle );
            request.setAttribute("nbPlaceAvailable", this.nbPlaceAvailable);
            request.setAttribute("nbPlacePrice20", this.nbPlacePrice20);
            request.setAttribute("nbPlacePrice40", this.nbPlacePrice40);
            request.setAttribute("nbPlacePrice55", this.nbPlacePrice55);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Transmission vers la page en charge de l'affichage des résultats */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */

        try {
            List<place> places;
            buyTicketForm buyTicketForm = new buyTicketForm(this.spectacle);
            buyTicketForm.create( request );
            this.nbPlaceAvailable = this.gestionRoomManager.listAllAvailablePlaceSpectacle(spectacle).size();
            this.nbPlacePrice20 = this.gestionRoomManager.listAllAvailablePlace20Spectacle(spectacle).size();
            this.nbPlacePrice40 = this.gestionRoomManager.listAllAvailablePlace40Spectacle(spectacle).size();
            this.nbPlacePrice55 = this.gestionRoomManager.listAllAvailablePlace55Spectacle(spectacle).size();

            request.setAttribute( ATTRIBUT_FORM_BUY_TICKET, buyTicketForm );
            request.setAttribute( ATTRIBUT_SPECTACLE, this.spectacle );
            request.setAttribute("nbPlaceAvailable", this.nbPlaceAvailable);
            request.setAttribute("nbPlacePrice20", this.nbPlacePrice20);
            request.setAttribute("nbPlacePrice40", this.nbPlacePrice40);
            request.setAttribute("nbPlacePrice55", this.nbPlacePrice55);

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}