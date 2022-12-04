package menu.airlines;

import menu.plane.RacePlane;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Airlines extends RacePlane {
    private String namePlane;
    private String city1;
    private String country1;
    private String country2;
    private String city2;
    private String date;
    private double coast;
    private int id;

    private List<Airlines> listAirLines = new ArrayList<>();


    public Airlines(String namePlane, String city1, String country1, String country2, String city2, String date, double coast) {
        this.namePlane = namePlane;
        this.city1 = city1;
        this.country1 = country1;
        this.country2 = country2;
        this.city2 = city2;
        this.date = date;
        this.coast = coast;
    }

    public Airlines() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }


    public String getCity1() {
        return city1;
    }

    public void setCity1(String city) {
        this.city1 = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCoast() {
        return coast;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }
    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public String getNamePlane() {
        return namePlane;
    }

    public void setNamePlane(String namePlane) {
        this.namePlane = namePlane;
    }



    public List<Airlines> findAirlineToCity(List<Airlines> list, String city1, String city2){
        List<Airlines> airlines = new ArrayList<>();
        for (Airlines airlines1 : list){

                if (airlines1.getCity2().equals(city2) || airlines1.getCity1().equals(city1)){
                    airlines.add(airlines1);
                }

        }
        return airlines;
    }

    public List<Airlines> findAirlineDate(List<Airlines> list,String date){
        List<Airlines> airlines = new ArrayList<>();

        for (Airlines airlines1 : list){

            if (airlines1.getDate().equals(date)){
                airlines.add(airlines1);
            }

        }
        return airlines;
    }

//
    @Override
    public String toString() {
        return city1 +", "+country1+ " -------------to-----------> " + city2+", "+country2 + "\nЛітак: " + namePlane + "\nВартість білету: "+ coast + "\nДата рейсу: " + date;
    }


    public String getCountry1() {
        return country1;
    }

    public void setCountry1(String country1) {
        this.country1 = country1;
    }

    public String getCountry2() {
        return country2;
    }

    public void setCountry2(String country2) {
        this.country2 = country2;
    }
}
