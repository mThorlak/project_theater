package ejbSession;

import ejbEntity.place;
import ejbEntity.spectacle;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface gestionPlaceRemote {
    public place findPlace(Long id_Place);
    public List<place> findPlaceAvailable(int price, spectacle spectacle);
    public void buyPlace(place place);
}
