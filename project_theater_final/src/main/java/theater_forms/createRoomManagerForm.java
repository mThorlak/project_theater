package theater_forms;

import ejbEntity.roomManager;
import ejbSession.gestionRoomManager;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public final class createRoomManagerForm {

    private static final String FIELD_NAME = "name";
    private static final String FIELD_PASSWORD = "password";

    private gestionRoomManager gestionRoomManager;

    private String result;
    private Map<String, String> error = new HashMap<String, String>();

    public createRoomManagerForm(ejbSession.gestionRoomManager gestionRoomManager) {
        this.gestionRoomManager = gestionRoomManager;
    }

    public String getResult() {
        return result;
    }

    public Map<String, String> getError() {
        return error;
    }

    public roomManager create(HttpServletRequest request) throws Exception {
        String name = getValueField(request, FIELD_NAME);
        System.out.println(name);
        String password = getValueField(request, FIELD_PASSWORD);
        System.out.println(password);

        roomManager roomManager = new roomManager();

        try {
            validateString(name);
        } catch (Exception e) {
            setError(FIELD_NAME, e.getMessage());
        }
        roomManager.setName(name);

        try {
            validateString(password);
        } catch (Exception e) {
            setError(FIELD_PASSWORD, e.getMessage());
        }
        roomManager.setPassword(password);

        if (error.isEmpty()) {
            result = "Succès de la création du pestacle.";
        } else {
            result = "Échec de la création du pestacle.";
        }

        System.out.println("End createRoomManagerForm");
        gestionRoomManager.addRoomManager(roomManager);
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

