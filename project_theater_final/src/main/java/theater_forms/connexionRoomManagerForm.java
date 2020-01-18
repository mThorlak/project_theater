package theater_forms;

import connect_db.connexionDB;
import ejbEntity.roomManager;
import ejbSession.gestionRoomManagerRemote;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

public class connexionRoomManagerForm {
    private static final String FIELD_NAME  = "name";
    private static final String FIELD_PASSWORD   = "password";

    private String result;
    private Map<String, String> errors = new HashMap<String, String>();

    public String getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public roomManager connectRoomManager(HttpServletRequest request ) throws NamingException {
        /* Récupération des champs du formulaire */
        String name = getValueField( request, FIELD_NAME );
        String password = getValueField( request, FIELD_PASSWORD );

        gestionRoomManagerRemote gestionRoomManager = new connexionDB().getconnexionManagerRoomManager();
        roomManager roomManager = new roomManager();

        /* Validation du champ nom. */
        try {
            validateString( name );
            roomManager.setName( name );
        } catch ( Exception e ) {
            setErrors( FIELD_NAME, e.getMessage() );
        }

        /* Validation du champ mot de passe. */
        try {
            validateString( password );
            roomManager.setPassword( password );
        } catch ( Exception e ) {
            setErrors( FIELD_PASSWORD, e.getMessage() );
        }

        try {
            roomManager = gestionRoomManager.findRoomManager(roomManager);
        } catch (Exception e) {
            setErrors(FIELD_NAME, e.getMessage());
        }

        /* Initialisation du résultat global de la validation. */
        if ( errors.isEmpty() ) {
            result = "Connexion success.";
        } else {
            result = "Connexion error, check again your name and password";
        }

        return roomManager;
    }

    private void validateString(String value) throws Exception {
        if (value == null)
            throw new Exception("Le champ ne ne peut pas être vide.");
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErrors( String champ, String message ) {
        errors.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValueField( HttpServletRequest request, String nameField ) {
        String value = request.getParameter( nameField );
        if ( value == null || value.trim().length() == 0 ) {
            return null;
        } else {
            return value;
        }
    }
}