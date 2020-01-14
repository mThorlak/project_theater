package theater_forms;

import connect_db.connexionDB;
import ejbEntity.place;
import ejbEntity.spectacle;
import ejbSession.gestionPlaceRemote;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class buyTicketForm {

    private static final String FIELD_PLACE = "place";
    private static final String FIELD_PRICE = "price";

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

    public List<place> create(HttpServletRequest request) throws NamingException {
        int nbPlace = Integer.parseInt(Objects.requireNonNull(getValueField(request, FIELD_PLACE)));
        int price = Integer.parseInt(Objects.requireNonNull(getValueField(request, FIELD_PRICE)));
        List<place> places;
        spectacle spectacle = this.spectacle;
        gestionPlaceRemote gestionPlace = new connexionDB().getConnexionManagerPlace();

/*        try {
            validateNbTicketBuying(place, spectacle.getPlace());
            spectacle.setPlace(spectacle.getPlace() - place);
        } catch (Exception e) {
            setError(FIELD_PLACE, e.getMessage());
        }*/

        places = gestionPlace.findPlaceAvailable(price, spectacle);

        int i = 0;
        if (places.size() >= nbPlace) {
            for (place eachPlace : places) {
                if (i < nbPlace) {
                    eachPlace.setState(true);
                    gestionPlace.buyPlace(eachPlace);
                    i++;
                }
                else
                    break;;
            }
        }
        else
            setError(FIELD_PLACE, "Il n'y a plus assez de place de cette catégorie");

        if (error.isEmpty()) {
            result = "Achat de place(s) enregistré";
        } else {
            result = "Vous ne pouvez pas acheter plus de place que disponible";
        }
        return places;
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

