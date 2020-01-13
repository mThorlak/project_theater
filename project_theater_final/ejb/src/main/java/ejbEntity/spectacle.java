package ejbEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="listCategory", query="SELECT pestacle FROM spectacle pestacle"),
})
public class spectacle implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idSpectacle;
    private String name;
    private String category;
    private String date;
    private int place;

    @OneToMany(mappedBy = "spectacle", cascade={CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval=true)
    private List<place> places;

    public spectacle(){};

    public spectacle (String name, String category, String date, int place) {
        System.out.println("In spectacle constructor");
        this.name = name;
        this.category = category;
        this.date = date;
        this.place = place;
        this.places = generatePlace();
        System.out.println(this.places);
    }

    public int getIdSpectacle() {
        return idSpectacle;
    }

    public void setIdSpectacle(int idSpectacle) {
        this.idSpectacle = idSpectacle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public List<place> getPlaces() {
        return places;
    }

    public void setPlaces(List<place> places) {
        this.places = places;
    }

    public List<place> generatePlace() {

        List<place> places = new ArrayList<place>() {
        };
        int i = 0;
        int price = 55;

        while (i < 100) {
            if (i < 30)
                places.add(new place(i, price, false));
            else if (i < 70) {
                price = 40;
                places.add(new place(i, price, false));
            }
            else {
                price = 20;
                places.add(new place(i, price, false));
            }
                i++;
        }

        return places;
    }

    @Override
    public String toString() {
        return "spectacle : " +
                "idSpectacle=" + idSpectacle +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", place=" + place;
    }
}