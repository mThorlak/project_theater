package theater_forms;

import ejbEntity.spectacle;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class buyTicketForm {

    private static final String FIELD_PLACE = "place";

    private spectacle spectacle;

    private String result;
    private Map<String, String> error = new HashMap<String, String>();

    public buyTicketForm(spectacle spectacle) {
        this.spectacle = spectacle;
    }

    public String getResult() {
        return result;
    }

    public Map<String, String> getError() {
        return error;
    }

    public spectacle create(HttpServletRequest request) {
        int place = Integer.parseInt(Objects.requireNonNull(getValueField(request, FIELD_PLACE)));
        spectacle spectacle = this.spectacle;

        try {
            validateNbTicketBuying(place, spectacle.getPlace());
            spectacle.setPlace(spectacle.getPlace() - place);
        } catch (Exception e) {
            setError(FIELD_PLACE, e.getMessage());
        }

        System.out.println("In end create pestacle form");
        System.out.println(this.spectacle.toString());

        if (error.isEmpty()) {
            result = "Achat de place(s) enregistré";
        } else {
            result = "Vous ne pouvez pas acheter plus de place que disponible";
        }

        return spectacle;
    }

    private void validateNbTicketBuying(int placeToBuy, int placeAvailable) throws Exception {
        if (placeToBuy > placeAvailable)
            throw new Exception("Vous ne pouvez pas acheter plus de place que disponible");
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

