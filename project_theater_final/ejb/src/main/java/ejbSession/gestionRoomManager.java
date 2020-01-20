package ejbSession;

import ejbEntity.place;
import ejbEntity.roomManager;
import ejbEntity.spectacle;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class gestionRoomManager implements gestionRoomManagerRemote {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addRoomManager(roomManager roomManager) throws Exception {
        em.persist(roomManager);
    }

    @Override
    public roomManager findRoomManagerByName(roomManager roomManager) {
        return (ejbEntity.roomManager) em.createNamedQuery( "findRoomManagerByName" ).setParameter(1, roomManager.getName()).getSingleResult();
    }

    @Override
    public roomManager findRoomManager(roomManager roomManager) {
        return (ejbEntity.roomManager) em.createNamedQuery( "findRoomManager" ).setParameter(1, roomManager.getName()).setParameter(2, roomManager.getPassword()).getSingleResult();
    }

    @Override
    public List<roomManager> listAllRoomManager() {
        return null;
    }

    @Override
    public List<place> listAllBoughtPlaceSpectacle(spectacle spectacle) {
        return em.createNamedQuery( "listPlaceBought" ).setParameter(1, spectacle.getIdSpectacle()).getResultList();
    }

    @Override
    public List<place> listAllAvailablePlaceSpectacle(spectacle spectacle) {
        return em.createNamedQuery( "listPlaceAvailable" ).setParameter(1, spectacle.getIdSpectacle()).getResultList();
    }

    @Override
    public List<place> listAllAvailablePlace20Spectacle(spectacle spectacle) {
        return em.createNamedQuery( "listPlace20Available" ).setParameter(1, spectacle.getIdSpectacle()).getResultList();
    }

    @Override
    public List<place> listAllAvailablePlace40Spectacle(spectacle spectacle) {
        return em.createNamedQuery( "listPlace40Available" ).setParameter(1, spectacle.getIdSpectacle()).getResultList();
    }

    @Override
    public List<place> listAllAvailablePlace55Spectacle(spectacle spectacle) {
        return em.createNamedQuery( "listPlace55Available" ).setParameter(1, spectacle.getIdSpectacle()).getResultList();
    }
}