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
    private EntityManager em;

    @Override
    public roomManager addRoomManager(roomManager roomManager) throws Exception {
        System.out.println("In gestion room manager" + roomManager.toString());
        roomManager test2 = new roomManager("michel", "jkedzlk");
        System.out.println("In gestion room manager" + test2.toString());
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