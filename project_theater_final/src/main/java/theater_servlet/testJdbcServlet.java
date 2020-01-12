package theater_servlet;

import connect_db.connexionDB;
import ejbEntity.roomManager;
import ejbSession.gestionRoomManagerRemote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class testJdbcServlet extends HttpServlet {
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE = "/WEB-INF/vue/test_jdbc.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {
            gestionRoomManagerRemote gestion = new connexionDB().getconnexionManagerRoomManager();
            roomManager roomManager = gestion.addRoomManager(new roomManager("meeeeh", "on y croit2"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Transmission vers la page en charge de l'affichage des résultats */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}