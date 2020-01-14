package theater_servlet;

import connect_db.connexionDB;
import ejbEntity.place;
import ejbEntity.spectacle;
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

    private spectacle spectacle;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {
            // On cherche le spectacle selon l'id passé et on le renvoi dans la vue
            spectacle spectacle;
            Long idParam = Long.parseLong(request.getParameter( "spectacle" ));
            gestionSpectacleRemote gestion = new connexionDB().getConnexionManagerSpectacle();
            spectacle = gestion.findSpectacle(idParam);
            this.spectacle = spectacle;
            request.setAttribute( "spectacle", spectacle );
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
            System.out.println("In doPost : " + this.spectacle);
            buyTicketForm buyTicketForm = new buyTicketForm(this.spectacle);
            places = buyTicketForm.create( request );
            System.out.println("Out of form -> " + places);
            // gestionSpectacle.buyTicket(spectacle);
            request.setAttribute( ATTRIBUT_FORM_BUY_TICKET, buyTicketForm );
            request.setAttribute( ATTRIBUT_SPECTACLE, this.spectacle );

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}