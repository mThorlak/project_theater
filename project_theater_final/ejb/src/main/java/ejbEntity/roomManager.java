package ejbEntity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "listPlaceBought", query = "SELECT place FROM place place WHERE place.state = true AND spectacle.idSpectacle = ?1"),
        @NamedQuery(name = "listPlaceAvailable", query = "SELECT place FROM place place WHERE place.state = false AND spectacle.idSpectacle = ?1"),
        @NamedQuery(name = "listPlace20Available", query = "SELECT place FROM place place WHERE place.price = 20 AND place.state = false AND spectacle.idSpectacle = ?1"),
        @NamedQuery(name = "listPlace40Available", query = "SELECT place FROM place place WHERE place.price = 40 AND place.state = false AND spectacle.idSpectacle = ?1"),
        @NamedQuery(name = "listPlace55Available", query = "SELECT place FROM place place WHERE place.price = 55 AND place.state = false AND spectacle.idSpectacle = ?1"),
        })
public class roomManager implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String password;

    public roomManager (){};

    public roomManager(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "roomManager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}