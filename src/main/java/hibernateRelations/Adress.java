package hibernateRelations;

import javax.persistence.*;

@Entity
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String streetName;
    private int houseNr;
    private String postalCode;


    public Adress(String city, String streetName, int houseNr, String postalCode) {
        this.houseNr = houseNr;
        this.postalCode = postalCode;
        this.city = city;
        this.streetName = streetName;
    }

    public Adress (){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(int houseNr) {
        this.houseNr = houseNr;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNr='" + houseNr + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

}
