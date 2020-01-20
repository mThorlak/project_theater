package theater_forms;

import connect_db.connexionDB;
import ejbEntity.roomManager;
import ejbSession.gestionRoomManagerRemote;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
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
            // Hash sha-256
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
            password = new String(messageDigest.digest());
            roomManager.setPassword(password);
        } catch (Exception e) {
            setError(FIELD_PASSWORD, e.getMessage());
        }

        try {
            roomManager roomManagerExist = gestionRoomManager.findRoomManagerByName(roomManager);
            result = "Fail - This name already existing";
        } catch (Exception e) {
            if (error.isEmpty()) {
                gestionRoomManager.addRoomManager(roomManager);
                result = "Success for creating room manager";
            } else {
                result = "Fail to create room manager";
            }
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

