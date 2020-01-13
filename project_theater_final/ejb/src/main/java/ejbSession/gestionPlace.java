package ejbSession;

import ejbEntity.place;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class gestionPlace implements gestionPlaceRemote {

    @PersistenceContext(unitName = "contactUnit")
    private EntityManager em;


    @Override
    public place buyPlace(place place) {
        place.setState(true);
        return em.merge(place);
    }
}