package ejbSession;

import ejbEntity.spectacle;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class gestionSpectacle implements gestionSpectacleRemote {

    @PersistenceContext
    EntityManager em;


    @Override
    public spectacle addSpectacle(spectacle spectacle) {
        System.out.println(spectacle);
        em.persist(spectacle);
        return spectacle;
    }

    @Override
    public spectacle findSpectacle(int id) {
        System.out.println("in find : " + id);
        return em.find(spectacle.class, id);
    }

    @Override
    public List<spectacle> listAllSpectacle() {
        return em.createNamedQuery( "listCategory" ).getResultList();
    }
}
