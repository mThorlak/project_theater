package bd_request;

import javax.el.PropertyNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class bd_request {
    /* La liste qui contiendra tous les résultats de nos essais */
    private List<String> messages = new ArrayList<>();

    // Données nécessaire à la connexion à la bdd
    private static final String PROPERTY_FILE = "bd.properties";
    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_USERNAME = "userName";
    private static final String PROPERTY_PASSWORD  = "password";

    private String urlBD;
    private String userNameBD;
    private String passwordBD;

    private Connection connexion = null;
    private Statement statement = null;
    private ResultSet result = null;

    public bd_request () {

        /* Récupération des valeurs du fichier properties */
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fileProperties = classLoader.getResourceAsStream( PROPERTY_FILE );

        if ( fileProperties == null ) {
            throw new PropertyNotFoundException( "Le fichier properties " + PROPERTY_FILE + " est introuvable. : " + fileProperties );
        }

        String driverBD;
        try {
            properties.load( fileProperties );
            driverBD = properties.getProperty( PROPERTY_DRIVER );
            this.urlBD = properties.getProperty( PROPERTY_URL );
            this.userNameBD = properties.getProperty( PROPERTY_USERNAME );
            this.passwordBD = properties.getProperty( PROPERTY_PASSWORD );
        } catch ( IOException e ) {
            throw new PropertyNotFoundException( "Impossible de charger le fichier properties " + PROPERTY_FILE, e );
        }

        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName(driverBD);
        } catch ( ClassNotFoundException e ) {
            e.getMessage();
        }
    }

    public List<String> executerTests( HttpServletRequest request ) {

        try {
            messages.add( "Connexion à la base de données..." );
            this.connexion = DriverManager.getConnection(this.urlBD, this.userNameBD, this.passwordBD);
            messages.add( "Connexion réussie !" );

            /* Création de l'objet gérant les requêtes */
            statement = connexion.createStatement();
            messages.add( "Objet requête créé !" );

            /* Exécution d'une requête d'écriture */
            int statut = statement.executeUpdate( "INSERT INTO roomManager (id, password) VALUES ('test1', MD5('test1'));" );

            /* Formatage pour affichage dans la JSP finale. */
            messages.add( "Résultat de la requête d'insertion : " + statut + "." );

            /* Exécution d'une requête de lecture */
            this.result = statement.executeQuery( "SELECT id, password FROM roomManager;" );
            messages.add( "Requête \"SELECT id, password FROM roomManager;\" effectuée !" );

            /* Récupération des données du résultat de la requête de lecture */
            while ( this.result.next() ) {
                String id = this.result.getString( "id" );
                String password = this.result.getString( "password" );
                /* Formatage des données pour affichage dans la JSP finale. */
                messages.add( "Données retournées par la requête : id = " + id + ", password = " + password + "." );
            }
        } catch ( SQLException e ) {
            messages.add( "Erreur lors de la connexion : <br/>"
                    + e.getMessage() );
        } finally {
            closeObject(connexion, statement, this.result);
        }

        return messages;
    }

    public List<String> showRoomManager( HttpServletRequest request ) {

        try {
            this.connexion = DriverManager.getConnection(this.urlBD, this.userNameBD, this.passwordBD);

            /* Requête préparée et execution de cette dernière
            *  (permet d'éviter les injections SQL par le client
            */
            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT id, password FROM roomManager;");
            this.result = preparedStatement.executeQuery();


            /* Récupération des données du résultat de la requête de lecture */
            while ( this.result.next() ) {
                String id = this.result.getString( "id" );
                String password = this.result.getString( "password" );
                /* Formatage des données pour affichage dans la JSP finale. */
                messages.add( "showRoomManager : id = " + id + ", password = " + password + "." );
            }
        } catch ( SQLException e ) {
            e.getMessage();
        } finally {
            closeObject(connexion, statement, this.result);
        }

        return messages;
    }

    private void closeObject(Connection connexion, Statement statement, ResultSet resultat) {

        if ( resultat != null ) {
            try {
                resultat.close();
            } catch ( SQLException e ) {
                e.getMessage();
            }
        }

        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException e ) {
                e.getMessage();
            }
        }

        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException e ) {
                e.getMessage();
            }
        }
    }
}
