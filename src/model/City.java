package model;

import util.Coordinate;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Felix
 */
public class City extends JLabel implements Serializable {
    
    private String name;
    private Coordinate point;
    
    private ArrayList<Route> routes = new ArrayList<>();

    public City (String name, Coordinate point) {
//        setIcon(new ImageIcon("./images/city.png"));
        this.name = name;
        this.point = point;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Coordinate getPoint () {
        return point;
    }

    public void setPoint (Coordinate point) {
        this.point = point;
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList<Route> routes) {
        this.routes = routes;
    }

    /**
     * @author Nathan
     */
    public ArrayList<Route> generateOwnedRoutes (Player player){
        ArrayList<Route> list = new ArrayList<>();

        for(Route r: routes) {
            if(r.getOwner() != null && r.getOwner().equals(player)){
                list.add(r);
            }
        }

        return list;
    }

    public boolean equals (City other) {
        return this.name.equals(other.name);
    }

    @Override
    public String toString () {
        return name;
    }
    
}
