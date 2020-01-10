package ejbSession;

import ejbEntity.roomManager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class gestionRoomManager implements gestionRoomManagerRemote {

    @PersistenceContext
    EntityManager em;

    @Override
    public roomManager addRoomManager(roomManager roomManager) {
        em.persist(roomManager);
        return roomManager;
    }

    @Override
    public roomManager findRoomManager(String name) {
        return em.find(roomManager.class, name);
    }

    @Override
    public List<roomManager> listAllRoomManager() {
        return null;
    }
}
