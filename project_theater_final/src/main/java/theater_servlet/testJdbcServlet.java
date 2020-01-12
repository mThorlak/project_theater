package theater_servlet;

import bd_request.bd_request;
import ejbEntity.roomManager;
import ejbSession.gestionRoomManager;
import ejbSession.gestionRoomManagerRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class testJdbcServlet extends HttpServlet {
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE = "/WEB-INF/vue/test_jdbc.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {
            gestionRoomManagerRemote gestion = lookupRemoteStatelessGestionRoomManager();
            roomManager roomManager = gestion.addRoomManager(new roomManager("allez", "on y croit2"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Transmission vers la page en charge de l'affichage des résultats */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public static gestionRoomManagerRemote lookupRemoteStatelessGestionRoomManager() throws NamingException {
        gestionRoomManagerRemote fct = null;
        System.out.println("dans le lookup0");
        try{
            System.out.println("dans le lookup1");
            Properties jndiProps=new Properties();
            jndiProps.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            InitialContext ctx= new InitialContext(jndiProps);
            System.out.println("dans le lookup: ");
            fct=(gestionRoomManagerRemote) ctx.lookup("ejb:/project_theater_final_war_exploded/gestionRoomManager!ejbSession.gestionRoomManagerRemote");
            System.out.println("voici la fct:" );

        }catch(Exception ignored){

        }
        return fct;
    }
}