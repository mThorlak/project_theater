package theater_servlet;

import bd_request.bd_request;
import ejbEntity.roomManager;
import ejbSession.gestionRoomManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class testJdbcServlet extends HttpServlet {
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE = "/WEB-INF/vue/test_jdbc.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        roomManager roomManager = new roomManager();
        roomManager.setName("JeanMichel1");
        roomManager.setPassword("test1jeanmichel");
        System.out.println(roomManager.toString());

        gestionRoomManager manageRoomManager = new gestionRoomManager();
        manageRoomManager.addRoomManager(roomManager);

        System.out.println(manageRoomManager.findRoomManager("test1"));

        /* Enregistrement de la liste des messages dans l'objet requête */
        request.setAttribute( ATT_MESSAGES, manageRoomManager.findRoomManager("JeanMichel1"));

        /* Transmission vers la page en charge de l'affichage des résultats */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}