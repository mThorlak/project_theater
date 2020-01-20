package theater_forms;

import connect_db.connexionDB;
import ejbEntity.place;
import ejbEntity.spectacle;
import ejbSession.gestionPlaceRemote;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

    public void create(HttpServletRequest request) throws NamingException {

        int nbPlace = 0;
        int price = Integer.parseInt(Objects.requireNonNull(getValueField(request, FIELD_PRICE)));

        if (Objects.equals(getValueField(request, FIELD_PLACE), null)) {
            setError(FIELD_PLACE, "Le nombre de place acheté ne peut pas être vide ou égal à 0");
        }
        else
            nbPlace = Integer.parseInt(Objects.requireNonNull(getValueField(request, FIELD_PLACE)));

        List<place> places;
        spectacle spectacle = this.spectacle;
        gestionPlaceRemote gestionPlace = new connexionDB().getConnexionManagerPlace();

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
            result = "Achat impossible, vérifiez les informations entrées";
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

    private boolean isNullOrZero(Integer i){
        return 0 == ( i == null ? 0 : i);
    }
}

