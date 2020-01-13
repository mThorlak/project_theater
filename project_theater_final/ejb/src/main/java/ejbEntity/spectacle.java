package ejbEntity;

import javax.persistence.*;
import java.io.Serializable;

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

    public spectacle(){};

    public spectacle (String name, String category, String date, int place) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.place = place;
    }

    public int getId() {
        return idSpectacle;
    }

    public void setId(int id) {
        this.idSpectacle = id;
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