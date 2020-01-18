package theater_servlet;

import ejbEntity.roomManager;
import theater_forms.connexionRoomManagerForm;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class connectRoomManager extends HttpServlet {
    public static final String ATT_USER         = "user";
    public static final String ATT_FORM         = "formConnexionRoomManager";
    public static final String ATT_USER_SESSION = "roomManager";
    public static final String VUE              = "/WEB-INF/vue/roomManager/formConnexionRoomManager.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        connexionRoomManagerForm formConnexionRoomManager = new connexionRoomManagerForm();

        /* Traitement de la requête et récupération du bean en résultant */
        roomManager roomManager = null;
        try {
            roomManager = formConnexionRoomManager.connectRoomManager( request );
        } catch (NamingException e) {
            System.err.println(e.toString());
        }

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /*
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if (roomManager != null) {
            System.out.println("roomManager found");
        } else {
            System.out.println("Room manager not found");
            session.setAttribute( ATT_USER_SESSION, null );
        }

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, formConnexionRoomManager );
        request.setAttribute( ATT_USER, roomManager );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}