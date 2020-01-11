package ejbSession;

import ejbEntity.roomManager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Stateless
@LocalBean
public class gestionRoomManager implements gestionRoomManagerRemote {
    private static final EntityManagerFactory emf = null;

    @PersistenceContext(unitName = "contactUnit", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public roomManager addRoomManager(roomManager roomManager) throws Exception {
        System.out.println("In gestion room manager" + roomManager.toString());
        if (em == null)
        {
            System.err.println("Entity manager is null");
        }
        else
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
