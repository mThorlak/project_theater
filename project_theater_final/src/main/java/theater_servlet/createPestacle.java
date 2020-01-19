package theater_servlet;

import connect_db.connexionDB;
import ejbEntity.spectacle;
import ejbSession.gestionSpectacleRemote;
import theater_forms.createPestacleForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class createPestacle extends HttpServlet {
    public static final String ATTRIBUT_PESTACLE = "pestacle";
    public static final String ATTRIBUT_FORM_PESTACLE = "formPestacle";
    public static final String VUE = "/WEB-INF/vue/formCreatePestacle.jsp";
    public static final String VUE_PUBLIC = "/WEB-INF/vue/restrictAccess.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        // Affichage de la page de restriction
        HttpSession session = request.getSession();
        if (session.getAttribute("roomManager") == null)
            this.getServletContext().getRequestDispatcher( VUE_PUBLIC ).forward( request, response );
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */

        try {
            gestionSpectacleRemote gestionSpectacle = new connexionDB().getConnexionManagerSpectacle();
            createPestacleForm pestacleForm = new createPestacleForm(gestionSpectacle);
            spectacle spectacle = null;
            /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
            spectacle = pestacleForm.create( request );
            System.out.println("End form, try to add in bd : ");
            gestionSpectacle.addSpectacle(spectacle);

            /* Stockage du formulaire et du bean dans l'objet request */
            request.setAttribute( ATTRIBUT_FORM_PESTACLE, pestacleForm );
            request.setAttribute( ATTRIBUT_PESTACLE, spectacle );

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
