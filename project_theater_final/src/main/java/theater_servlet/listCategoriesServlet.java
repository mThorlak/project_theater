package theater_servlet;

import connect_db.connexionDB;
import ejbEntity.spectacle;
import ejbSession.gestionSpectacleRemote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class listCategoriesServlet extends HttpServlet {
    public static final String VUE = "/WEB-INF/vue/showSpectacle/listCategories.jsp";

    List<spectacle> categories;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {
            gestionSpectacleRemote gestion = new connexionDB().getConnexionManagerSpectacle();
            this.categories = gestion.listAllCategory();
            this.categories = deleteDoublon(categories);
            System.out.println("in list categories");
            request.setAttribute("categories", categories);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Transmission vers la page en charge de l'affichage des résultats */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */

        try {
            gestionSpectacleRemote gestionSpectacle = new connexionDB().getConnexionManagerSpectacle();
            spectacle spectacle = null;
            System.out.println("Here");
            System.out.println(request.getParameter("politique"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public List deleteDoublon(List list) {
        Set set = new HashSet(list);
        List result = new ArrayList(set);
        return result;
    }
}