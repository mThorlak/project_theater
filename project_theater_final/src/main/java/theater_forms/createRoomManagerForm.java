package theater_forms;

import connect_db.connexionDB;
import ejbEntity.roomManager;
import ejbSession.gestionRoomManager;
import ejbSession.gestionRoomManagerRemote;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public final class createRoomManagerForm {

    private static final String FIELD_NAME = "name";
    private static final String FIELD_PASSWORD = "password";


    private String result;
    private Map<String, String> error = new HashMap<String, String>();

    public String getResult() {
        return result;
    }

    public Map<String, String> getError() {
        return error;
    }

    public roomManager create(HttpServletRequest request) throws Exception {
        String name = getValueField(request, FIELD_NAME);
        String password = getValueField(request, FIELD_PASSWORD);

        roomManager roomManager = new roomManager();
        gestionRoomManagerRemote gestionRoomManager = new connexionDB().getconnexionManagerRoomManager();

        try {
            validateString(name);
            roomManager.setName(name);
        } catch (Exception e) {
            setError(FIELD_NAME, e.getMessage());
        }

        try {
            validateString(password);
            roomManager.setPassword(password);
        } catch (Exception e) {
            setError(FIELD_PASSWORD, e.getMessage());
        }

        if (error.isEmpty()) {
            System.out.println(roomManager);
            gestionRoomManager.addRoomManager(roomManager);
            result = "Succès de la création du room manager.";
        } else {
            result = "Échec de la création du room manager.";
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
    private void setError(String field, String message) {
        error.put(field, message);
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValueField(HttpServletRequest request, Object fieldValue) {

        String valeur = request.getParameter((String) fieldValue);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}

