package theater_servlet;

import ejbEntity.spectacle;
import ejbSession.gestionSpectacle;
import theater_forms.createPestacleForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class createPestacle extends HttpServlet {
    public static final String ATTRIBUT_PESTACLE = "pestacle";
    public static final String ATTRIBUT_FORM_PESTACLE = "formPestacle";
    public static final String VUE = "/WEB-INF/vue/formCreatePestacle.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */

        gestionSpectacle gestionSpectacle = new gestionSpectacle();
        createPestacleForm formPestacle = new createPestacleForm( gestionSpectacle);

        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        spectacle spectacle = formPestacle.create( request );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATTRIBUT_FORM_PESTACLE, formPestacle );
        request.setAttribute( ATTRIBUT_PESTACLE, spectacle );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
