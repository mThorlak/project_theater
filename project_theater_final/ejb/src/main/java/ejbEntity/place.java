package ejbEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name="listPlace", query="SELECT place FROM place place"),
})
public class place implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idPlace;
    private int numPlace;
    private int price;
    private boolean state;

    public place(){};

    public place (int numPlace, int price, boolean state) {
        this.numPlace = numPlace;
        this.price = price;
        this.state = state;
    }

    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }

    public int getNumPlace() {
        return numPlace;
    }

    public void setNumPlace(int numPlace) {
        this.numPlace = numPlace;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}