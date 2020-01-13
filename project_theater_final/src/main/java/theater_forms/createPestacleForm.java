package theater_forms;

import ejbEntity.spectacle;
import ejbSession.gestionSpectacleRemote;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public final class createPestacleForm {

    private static final String FIELD_NAME = "name";
    private static final String FIELD_CATEGORY = "category";
    private static final String FIELD_DATE = "date";
    private static final String FIELD_PLACE = "place";

    private ejbSession.gestionSpectacleRemote gestionSpectacle;

    private String result;
    private Map<String, String> error = new HashMap<String, String>();

    public createPestacleForm (gestionSpectacleRemote gestionSpectacle) {
        this.gestionSpectacle = gestionSpectacle;
    }

    public String getResult() {
        return result;
    }

    public Map<String, String> getError() {
        return error;
    }

    public spectacle create(HttpServletRequest request) {
        String name = getValueField(request, FIELD_NAME);
        String category = getValueField(request, FIELD_CATEGORY);
        String date = getValueField(request, FIELD_DATE);

        try {
            validateString(name);
        } catch (Exception e) {
            setError(FIELD_NAME, e.getMessage());
        }

        try {
            validateString(category);
        } catch (Exception e) {
            setError(FIELD_CATEGORY, e.getMessage());
        }

        spectacle pestacle = new spectacle(name, category, date);

        if (error.isEmpty()) {
            result = "Succès de la création du pestacle.";
        } else {
            result = "Échec de la création du pestacle.";
        }

        System.out.println("In end create pestacle form");
        System.out.println(pestacle.toString());

        return pestacle;
    }

    private void validateString(String value) throws Exception {
        if (value == null)
            throw new Exception("Le champ ne ne peut pas être vide.");
    }

    private void validateSalle(Integer place) throws Exception {
        if (place == 0) {
            throw new Exception("Le specatcle doit au moins pouvoir accueillir un spectateur.");
        }
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

