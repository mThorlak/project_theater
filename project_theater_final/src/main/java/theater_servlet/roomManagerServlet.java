package theater_servlet;

import connect_db.connexionDB;
import ejbEntity.roomManager;
import ejbSession.gestionRoomManagerRemote;
import theater_forms.createRoomManagerForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class roomManagerServlet extends HttpServlet {
    public static final String ATT_USER         = "roomManager";
    public static final String ATT_FORM         = "createRoomManagerForm";
    public static final String VUE              = "/WEB-INF/vue/formCreateRoomManager.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */

        try {
            createRoomManagerForm roomManagerForm = new createRoomManagerForm();
            roomManager roomManager = null;
            /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
            roomManager = roomManagerForm.create( request );

            /* Stockage du formulaire et du bean dans l'objet request */
            request.setAttribute( ATT_FORM, roomManagerForm );
            request.setAttribute( ATT_USER, roomManager );

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}