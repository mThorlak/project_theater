package ejbSession;

import ejbEntity.place;
import ejbEntity.spectacle;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class gestionPlace implements gestionPlaceRemote {

    @PersistenceContext
    private EntityManager em;

    @Override
    public place findPlace(Long id_Place) {
        return em.find(place.class, id_Place);
    }

    @Override
    public List<place> findPlaceAvailable(int price, spectacle spectacle) {
        return em.createNamedQuery("listPlacePriceAvailable").setParameter(1, spectacle).setParameter(2, price).getResultList();
    }

    @Override
    public void buyPlace(place place) {
        System.out.println("buyPlace -> " + place);
        em.merge(place);
    }
}